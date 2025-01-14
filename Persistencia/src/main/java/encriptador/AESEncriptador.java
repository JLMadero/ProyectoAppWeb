/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptador;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author jl4ma
 */
public class AESEncriptador {
    private static final String ALGORITMO = "AES";
    private static final String CLAVE_SECRETA = "HectorAbel123678";

    /**
     * Permite encriptar la cadena de texto del parámetro.
     *
     * @param cadena La cadena de texto a encriptar
     * @return La cadena de texto encriptada
     */
    public static String encriptar(String cadena) {
        try {
            Key clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
            Cipher cifrador = Cipher.getInstance(ALGORITMO);
            cifrador.init(Cipher.ENCRYPT_MODE, clave);
            byte[] valorEncriptado = cifrador.doFinal(cadena.getBytes());
            return Base64.getEncoder().encodeToString(valorEncriptado);
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Método el cuál se usará para desencrptar, se usará algoritmo de cigrado
     * AES
     *
     * @param textoEncriptado texto que se quiere encriptar
     * @return texto desencriptado
     * @throws Exception
     */
    public static String desencriptar(String textoEncriptado) throws Exception {
        SecretKeySpec claveSecreta = new SecretKeySpec(CLAVE_SECRETA.getBytes(), "AES");
        Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cifrador.init(Cipher.DECRYPT_MODE, claveSecreta);
        byte[] textoDecodificado = Base64.getDecoder().decode(textoEncriptado);
        byte[] textoDesencriptado = cifrador.doFinal(textoDecodificado);
        return new String(textoDesencriptado);
    }
}
