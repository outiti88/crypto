package crypto;

import javax.crypto.spec.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.*;
import javax.crypto.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
  
public class RC {
	public static void encrypt(String originalString, String secretKey) {
		try{
	  Security.addProvider(new BouncyCastleProvider());
	  SecureRandom sr = new SecureRandom(secretKey.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance("RC6");
      kg.init(sr);
      SecretKey secretkey = kg.generateKey();
   

    // create a cipher based upon Blowfish
    Cipher cipher = Cipher.getInstance("RC6");

    // initialise cipher to with secret key
    cipher.init(Cipher.ENCRYPT_MODE, secretkey);

    // get the text to encrypt
    String inputText = originalString;

    // encrypt message
    byte[] encrypted = cipher.doFinal(inputText.getBytes());
    System.out.println("Text : " + new String(encrypted));

    // re-initialise the cipher to be in decrypt mode
    cipher.init(Cipher.DECRYPT_MODE, secretkey);

    // decrypt message
    byte[] decrypted = cipher.doFinal(encrypted);

    // and display the results
    System.out.println("Text Decryted : " + new String(decrypted));
		}catch(Exception e){
			e.printStackTrace();
		}
		}
	
	public static void appRc(String text, String key) {
	    System.out.println("*************************");
		System.out.println("algorithme RC6");
	    RC.encrypt(text, key) ;
	    System.out.println("*************************");

	}
}