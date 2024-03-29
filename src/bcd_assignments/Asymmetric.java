package bcd_assignments;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import javax.crypto.Cipher;

public class Asymmetric {
	private Cipher cipher;
	
	
	private Asymmetric(String s) throws Exception {
		this.cipher = Cipher.getInstance(s);
	}
	
	public Asymmetric() throws Exception {
		this.cipher = Cipher.getInstance("RSA");
	}
	
	public String encrypt(String data, PublicKey key) throws Exception{
		String cipherText = null;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String cipherText, PrivateKey key) throws Exception{
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
		
		
	}

}
