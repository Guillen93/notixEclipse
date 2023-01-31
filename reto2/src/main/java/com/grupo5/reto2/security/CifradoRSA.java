package com.grupo5.reto2.security;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.Cipher;

/**
 * <b>Criptografia Asimetrica (Clave publica) - Generador Clave Publica</b>
 * <br/>
 * <br/>
 * 
 * En un <b>Cifrado asimetrico</b> hay dos participantes: el emisor y el
 * receptor. Los pasos a seguir son:
 * 
 * <ul>
 * <li>Generar una <b>clave publica</b> y otra <b>privada</b>. La clave publica
 * se envia al emisor</li>
 * <li>El emisor <u>cifra</u> los datos con <b>clave publica</b> y se envian al
 * receptor</li>
 * <li>El receptor <u>descifra</u> los datos con <b>clave privada</b></li>
 * </ul>
 * 
 * Esta clase genera primero cifra un mensaje con la <b>clave publica</b>. A
 * continuaci�n, lo descifra mediante la <b>clave privada</b>. En este caso
 * vamos a utilizar:
 * 
 * <ul>
 * <li>El algoritmo RSA</li>
 * <li>El modo ECB: Existen dos, el ECB que es sencillo, y el CBC que necesita
 * un vector de inicializacion(IV)</li>
 * <li>El padding PKCS1Padding: Si el mensaje no es multiplo de la longitud del
 * algoritmo se indica un relleno.</li>
 * </ul>
 */
public class CifradoRSA {

	 private static final String PRIVATE_KEY_FILE_PATH = "EjemploRSA_Private.key";
	 

    /**
     * Descifra un texto con RSA, modo ECB y padding PKCS1Padding (asim�trica) y lo
     * retorna
     * 
     * @param mensaje El mensaje a descifrar
     * @return El mensaje descifrado
     */
    public byte[] descifrarTexto(byte[] mensaje) {
        byte[] decodedMessage = null;
        try {
            // Clave privada
    		File ficheroPrivada = new File(PRIVATE_KEY_FILE_PATH);
    		byte[] clavePrivada = Files.readAllBytes(ficheroPrivada.toPath());

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(clavePrivada);
            PrivateKey privateKey = keyFactory.generatePrivate(pKCS8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            decodedMessage = cipher.doFinal(mensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decodedMessage;
    }

}
