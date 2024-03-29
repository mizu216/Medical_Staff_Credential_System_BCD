package bloackchain;

import java.nio.file.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class KeyAccess {
	
	public static PublicKey getPublicKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		//convert the keybytes into appropriate keySpec
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePublic(spec);
		
		
	}
	
	public static PrivateKey getPrivateKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePrivate(spec);
	}
	

}
