package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@SpringBootApplication
public class ServerApplication {

}

@RestController
class ServerController{
	 public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	    {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input  
	        // and return array of byte 
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	 
	 public  String bytesToHex(byte[] bytes) {
		    StringBuilder builder = new StringBuilder();
		    for (byte b: bytes) {
		      builder.append(String.format("%02x", b));
		    }
		    return builder.toString();
		  }
	
//FIXME:  Add hash function to return the checksum value for the data string that should contain your name.    
    @RequestMapping("/hash")
    public String myHash() throws NoSuchAlgorithmException{
    	String data = "Raphael Rose";
    	 // Static getInstance method is called with hashing SHA  
    	MessageDigest md = MessageDigest.getInstance("SHA-256");  
  	  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        byte[] hashData = md.digest(data.getBytes(StandardCharsets.UTF_8));  
        String checkSum = bytesToHex(hashData);
    	
       
        return "<p>data:"+ data +"\n" + "Name of Cipher Algorith: SHA-256" +"\n" + "Check Sum Value: " + checkSum;
    }

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		
	}
    
}
