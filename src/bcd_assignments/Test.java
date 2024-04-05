package bcd_assignments;

import java.security.Key;
import java.security.PublicKey;
import java.security.Signature;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) throws Exception {
//		 TODO Auto-generated method stub
//		BlockChainn bc = new BlockChainn("master/chain.bin");
//		System.out.println(bc.get());
//		Block genesis = new Block("0");
//		System.out.println(genesis);
		
//		String tranx1 = "alice|bob|debit|rm|10";
//		String tranx2 = "helen|bob|debit|rm|20";
//		
//		TransactionCollection tranxList = new TransactionCollection();
//		tranxList.add(tranx1);
//		tranxList.add(tranx2);
//		
//		System.out.println("merkle root");
//		System.out.println(tranxList.getMerkleRoot());
//		
//		Block b1 = new Block(genesis.getHeader().getCurrentHash());
//		b1.setTransaction(tranxList);
//		System.out.println(b1);
//		
//		BlockChainn b = new BlockChainn("test");
//		b.tester();
//		
		//lab 7
//		Symmetric sym = new Symmetric();
//		
//		Key secretKey = PredefinedCharsSecretKey.create();
//		String secretKeyString = Base64.getEncoder().encodeToString(secretKey.getEncoded());
//		System.out.println("My Secret Key: " + secretKeyString);
//		
//		String msg = "thankyou so much!";
//		
//		String encrypted = sym.encrypt(msg, secretKey);
//		System.out.println("Encrypted: " + encrypted);
//		
//		TimeUnit.SECONDS.sleep(3);
//		
//		Key anotherKey = RandomSecretKey.create();
//		String decrypted = sym.decrypt(encrypted, secretKey);
//		System.out.println("\n\n> Original Content: " + decrypted);
		
		//lab8
//		MyKeyPair.create();
//		byte[] publicKey = MyKeyPair.getPublicKey().getEncoded();
//		byte[] privateKey = MyKeyPair.getPrivateKey().getEncoded();
//		
//		System.out.println("Public Key = " + Base64.getEncoder().encodeToString(publicKey));
//		System.out.println("Private Key = " + Base64.getEncoder().encodeToString(privateKey));
//		
//		MyKeyPair.put(privateKey, "MyKeypair/PrivateKey");
//		MyKeyPair.put(publicKey, "MyKeypair/PublicKey");
		
//		PublicKey publicKeyy = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
//		PrivateKey privateKeyy = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
		
//		System.out.println("Public Key = " + Base64.getEncoder().encodeToString(publicKeyy.getEncoded()));
//		System.out.println("Private Key = " + Base64.getEncoder().encodeToString(privateKeyy.getEncoded()));
//		
//		Asymmetric a = new Asymmetric();
//		
//		String msg = "thankyou so much!";
//		
//		String encrypted = a.encrypt(msg, publicKeyy);
//		
//		System.out.println("Encrypted: " + encrypted);
//		
//		TimeUnit.SECONDS.sleep(3);
//		
//		String decrypted = a.decrypt(encrypted, privateKeyy);
//		System.out.println("\n\n> Original Content: " + decrypted);
		
		//lab 9
		PublicKey publicKeyy = KeyAccess.getPublicKey("MyKeyPair/PublicKey");
		PrivateKey privateKeyy = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
		
		MySignature sig = new MySignature();
		
		String text = "simple digital signature demo";
		
		byte[] s = sig.getSignature(text, privateKeyy);
		System.out.println(sig.isTextAndSignatureValid(text, s, publicKeyy));
		
		//lab10
//		String line1 = "bob|alice|debit|100";
//		String line2 = "mick|alice|debit|200";
//		String line3 = "peter|alice|debit|300";
//		String line4 = "ali|alice|debit|400";
//		
//		List<String> lst = new ArrayList<>();
//		lst.add(line1);
//		lst.add(line2);
//		lst.add(line3);
//		lst.add(line4);
//		
//		MerkleTree mt = MerkleTree.getInstance(lst);
//		mt.build();
//		String root = mt.getRoot();
//		
//		System.out.println("Merkle Root = " + root);

		
		
		
		
	}

}
