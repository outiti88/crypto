package crypto;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;


public class Blowfish{

	public static void encrypt(String originalString, String secretKey) {
		try{

	  SecureRandom sr = new SecureRandom(secretKey.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
      kg.init(sr);
      SecretKey secretkey = kg.generateKey();
   

    // create a cipher based upon Blowfish
    Cipher cipher = Cipher.getInstance("Blowfish");

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
	
	public static void appBlowfish(String originalString, String secretKey) {
		System.out.println("*************************");
		System.out.println("algorithme BLOWFISH");
	    
	    Blowfish.encrypt(originalString, secretKey) ;
	    System.out.println("*************************");
	}
  
}