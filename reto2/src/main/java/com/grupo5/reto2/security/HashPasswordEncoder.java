package com.grupo5.reto2.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class HashPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {

        return cifradoHash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return cifradoHash(rawPassword.toString()).equals(encodedPassword);
    }
    /**
     * dado una contraseña sin cifrar , devuelve la contraseña cifrada
     * @param texto la contraseña cin cifrar 
     * @return la contraseña cifrada segun lo que implementemos 
     */
    private String cifradoHash(String texto) {
        String textoCifrado="";
        
        MessageDigest algoritmo;
        try {
            algoritmo = MessageDigest.getInstance("SHA"); // Algoritmo a usar
            algoritmo.reset(); // Limpiamos la instancia por si acaso
            byte dataBytes[] = texto.getBytes(); 
            algoritmo.update(dataBytes); // El mensaje que queremos cifrar
            byte resumen[] = algoritmo.digest(); // Generamos el resumen
            textoCifrado=byteArrayToString(resumen);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        
        
        return textoCifrado;
    }
    
    
    private String byteArrayToString(byte[] resumen) {
        String HEX = "";
        for (int i = 0; i < resumen.length; i++) {
            String h = Integer.toHexString(resumen[i] & 0xFF);
            if (h.length() == 1)
                HEX += "0";
            HEX += h;
        }
        return HEX.toUpperCase();
    }
}