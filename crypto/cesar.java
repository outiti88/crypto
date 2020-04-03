package crypto;

public class cesar {
 
    public static String encoding (String t, int a)
    {	
    	t = t.toLowerCase();
    	char[] text = t.toCharArray();

    	for(int j=0;j<t.length();j++){
    		
    		if(text[j]!=32){
    		
    			if (text[j]> 'z'-a){
    			text[j]-=25-a+1;
    		
    			}
    				else
    				text[j]+=a;
    		}
    	}
    	t = String.valueOf(text);

		return t;
        
    }
    public static String decoding (String t, int a)
   
    {
    	char[] text = t.toCharArray();

    	for(int j=0;j<t.length();j++){
    		if(text[j]!=' '){

    	if (text[j] - a < 'a'){
    		text[j]+=26-a;
    	
    	}
    	else
    	text[j]-=a;
    	}
    }
    	t = String.valueOf(text);

		return t;
      
    }
    
    public static void appCesar(String text , int a) {
    	System.out.println("*************************");
    	System.out.println("algorithme cesar");
	    System.out.println("le texte original: "+text);
	    System.out.println(" Encrypted Text : " + cesar.encoding(text, a)) ;
        System.out.print(" Decryptd Text : ") ;
        System.out.println(cesar.decoding (cesar.encoding (text, a), a)) ;
        System.out.println("*************************");
    }

}
