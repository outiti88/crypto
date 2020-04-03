package crypto;

import java.math.BigInteger;
import java.util.Scanner;


public class home {

	public static void main(String[] args) 
	{
	    final String secretKey = "r";
	    
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Entrer votre texte: ");
	    String originalString = sc.nextLine();
	   
	    cesar.appCesar(originalString,4);
	     
	    
	    AES.appAes(originalString, secretKey);
	    
	    
	    DES.appDes(originalString, secretKey);
	    
	    System.out.println("*************************");
	    System.out.println("algorithme RSA");
	    RSA rsa = new RSA(1024);
	    System.out.println("Plaintext: " + originalString);
	    BigInteger plaintext = new BigInteger(originalString.getBytes());

	    BigInteger ciphertext = rsa.encrypt(plaintext);
	    System.out.println("Ciphertext: " + ciphertext);
	    plaintext = rsa.decrypt(ciphertext);

	    String text2 = new String(plaintext.toByteArray());
	    System.out.println("Plaintext: " + text2);
	    
	    
	}
}
