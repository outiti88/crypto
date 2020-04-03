package crypto;


import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

import org.bouncycastle.jce.provider.BouncyCastleProvider;



public class idea {

	public static void encrypt(String originalString, String secretKey) {
		try{
      Security.addProvider(new BouncyCastleProvider());
	  SecureRandom sr = new SecureRandom(secretKey.getBytes());
      KeyGenerator kg = KeyGenerator.getInstance("IDEA");
      kg.init(sr);
      SecretKey secretkey = kg.generateKey();
   

    // create a cipher based upon Blowfish
    Cipher cipher = Cipher.getInstance("IDEA");

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
	
	public static void appIdea(String text, String key) {
		System.out.println("*************************");
	    System.out.println("algorithme IDEA");
	    idea.encrypt(text, key) ;
	    System.out.println("*************************");
	}
  
}