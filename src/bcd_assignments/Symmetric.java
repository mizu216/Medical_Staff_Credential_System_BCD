package bcd_assignments;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class Symmetric {
	private Cipher cipher;
	
	
	public Symmetric(String s) throws Exception {
		this.cipher = Cipher.getInstance(s);
	}
	
	public Symmetric() throws Exception {
		this.cipher = Cipher.getInstance("AES");
	}
	
	public String encrypt(String data, Key key) throws Exception{
		String cipherText = null;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cipherBytes = cipher.doFinal(data.getBytes());
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	public String decrypt(String cipherText, Key key) throws Exception{
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] cipherBytes = Base64.getDecoder().decode(cipherText);
		byte[] dataBytes = cipher.doFinal(cipherBytes);
		return new String(dataBytes);
		
		
	}
}
