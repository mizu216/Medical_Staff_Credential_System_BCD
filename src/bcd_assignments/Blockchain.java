package bloackchain;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


public class Blockchain {
	
	private static String hash(String input, String algorithm)
	 {
	 String hashCode = "";
	 try {
	 MessageDigest md = MessageDigest.getInstance(algorithm);
	 md.update( input.getBytes() );
	 //digesting...
	 byte[] hashBytes = md.digest();
	 //convert the byte[] to String
	 //1)
	 hashCode = Base64.getEncoder().encodeToString(hashBytes);
	 //2) hex format output - recommended!
	 //hashCode = Hex.encodeHexString(hashBytes);
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 return hashCode;
	}
	
	public static String sha512(String input)
	 {
	 return hash( input, "SHA-512" );
	} 

	
//	public static String md5(String input)
//	 {
//	 return hash( input, "MD5" );
//	 }
//	
	public static String sha256(String input)
	 {
	 return hash( input, "SHA-256" );
	} 
//	
//	public static String sha384(String input)
//	 {
//	 return hash( input, "SHA-384" );
//	} 
	
//	public static String sha512(String input, byte[] salt)
//	 {
//	 return hash( input, salt, "SHA-512" );
//	} 

	
	
	
	
	public static byte[] generate() {
		SecureRandom sr = new SecureRandom();
		byte[] b = new byte[16];
		sr.nextBytes(b);
		return b;
	}
	
	
//	private static String hash(String input, byte[] salt, String algorithm) {
//		MessageDigest md;
//		
//		try {
//			md = MessageDigest.getInstance(algorithm);
//			md.update(input.getBytes());
//			md.update(salt);
//			
//			byte[] hashBytes = md.digest();
//			return Base64.getEncoder().encodeToString(hashBytes);
//					
//			
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	


	public static void main(String[] args) {
//		byte[] salt = generate();
//		String input = "username";
//		
//		System.out.println(sha512(input, salt));
//		System.out.println("sada");
		
		
		
//		 String str1 = "alice";
//		 String str2 = "bob";
//
//		/* hashcode for String object */
//		 System.out.println( String.join(":", str1,
//		 String.valueOf(str1.hashCode())) );
//		 System.out.println( String.join(":", str2,
//		String.valueOf(str2.hashCode())) );
		
//		String str1 = "alice";
//		 String str2 = "bob";
//		 String str3 = "ben";
//		 String str4 = "max";
//		 
//		 /* string collection */
//		 List<String> lst = new ArrayList<>();
//		 List<String> lst2 = new ArrayList<>();
//		 lst.add(str1); lst.add(str2);
//		 System.out.println( "hashcode = "+ lst.hashCode() );
//		 lst.add(str3); lst2.add(str4);
//		 System.out.println( "List = "+lst );
//		 System.out.println( "hashcode = "+ lst.hashCode() );
//		 System.out.println( "hashcode = "+ lst2.hashCode() );
		
//		String input = "username";
		
//		System.out.println(String.join("|", "md5", md5(input)));
//		System.out.println(sha256(input));
//		System.out.println(sha384(input));
//		System.out.println(sha512(input));
		 
		 
		 

	 } 


}
