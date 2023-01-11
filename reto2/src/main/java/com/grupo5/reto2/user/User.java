package com.grupo5.reto2.user;

import java.util.HashSet;
import java.util.Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.grupo5.reto2.role.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ForeignKey;

@Entity
@Table(name="user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String dni;
	
	@Column(length = 100)
	private String password;
	
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "user_role",
		joinColumns = @JoinColumn(
				name = "userDni", referencedColumnName = "dni", foreignKey = @ForeignKey(name = "fk_userDni")
		),
		inverseJoinColumns = @JoinColumn(
				name = "roleId", referencedColumnName = "roleId", foreignKey = @ForeignKey(name = "fk_roleId")
		)
	)
	private Set<Role> roles = new HashSet<>();
	
	public User() {
		super();
	}
	
	public User(String dni, String password) {
		super();
		this.dni = dni;
		this.password = password;
	}

	public User(String dni, String password, boolean isEnabled, Set<Role> roles) {
		super();
		this.dni = dni;
		this.password = password;
		this.isEnabled = isEnabled;
		this.roles = roles;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (final Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}

	@Override
	public String getUsername() {
		return dni;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}
	
	@Override
	public String toString() {
		return "User [dni=" + dni + ", password=" + password + ", roles=" + roles + "]";
	}
	

}
