package bcd_assignments;

import java.util.Arrays;
import java.security.Key;
import javax.crypto.spec.*;

public class PredefinedCharsSecretKey {
	
	private static final String ALGORITHM = "AES";
	
	private static final String SECRET_CHARS = "asddasdqwewertett1233456";
	
	public static Key create() {
		int keySize = 16;
		return new SecretKeySpec(Arrays.copyOf(SECRET_CHARS.getBytes(), keySize), ALGORITHM);
	}

}
