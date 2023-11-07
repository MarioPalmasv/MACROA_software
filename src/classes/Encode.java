package classes;
//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author gergo
 */
public class Encode {

    String LLAVE = "contrasena123";
    // Clave de encriptación / desencriptación

    public SecretKeySpec CrearCalve(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            return new SecretKeySpec(cadena, "AES");
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return null;
        }
    }

    // Encriptar
    public String Encriptar(String encriptar) {
        try {
            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] cadena = encriptar.getBytes("UTF-8");
            byte[] encriptada = cipher.doFinal(cadena);
            return Base64.getEncoder().encodeToString(encriptada);
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            return "";
        }
    }

    // Desencriptación
    public String Desencriptar(String desencriptar) {
        try {
            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] cadena = Base64.getDecoder().decode(desencriptar);
            byte[] desencriptacion = cipher.doFinal(cadena);
            return new String(desencriptacion, "UTF-8");
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | UnsupportedEncodingException e) {
            return "";
        }
    }
}
