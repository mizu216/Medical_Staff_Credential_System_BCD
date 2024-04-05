package bcd_assignments;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.*;

public class BlockChainn {
	
	private static LinkedList<Block> db = new LinkedList<Block>();
	private static LinkedList<TransactionCollection> name = new LinkedList<TransactionCollection>();
	private static BlockChainn _instance = null;
	public  String chainFile;
	private static String masterFolder = "master";
	private static String fileName = masterFolder + "/chain.bin";
	private static String listFile = masterFolder + "/name.bin";
	
	public BlockChainn(String chainFile){
		this.chainFile = chainFile;
	}
	
	public static BlockChainn getInstance(String chainFile) {
		if(_instance == null) {
			_instance = new BlockChainn(chainFile);
		}
		
		return _instance;
	}
	
	
	
	public void genesis() {
		Block genesis = new Block("0", "");
		db.add(genesis);
		persist();
	}
	
	public void nextBlock(Block newBlock, TransactionCollection tranxList) {
		db = get();
		name = getList();
		db.add(newBlock);
		name.add(tranxList);
		persist();
	}
	
	public LinkedList<Block> get() {
		try
			(FileInputStream fin = new FileInputStream(this.chainFile);
				ObjectInputStream in = new ObjectInputStream( fin );
				
				){
			return (LinkedList<Block>)in.readObject();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public LinkedList<TransactionCollection> getList() {
		try
			(FileInputStream fin = new FileInputStream(this.listFile);
				ObjectInputStream in = new ObjectInputStream( fin );
				
				){
			return (LinkedList<TransactionCollection>)in.readObject();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void persist() {
		try
			(FileOutputStream fout = new FileOutputStream(this.chainFile);
				ObjectOutputStream out = new ObjectOutputStream( fout );
				FileOutputStream lout = new FileOutputStream(this.listFile);
				ObjectOutputStream listOut = new ObjectOutputStream( lout );
				){
			out.writeObject(db);
			listOut.writeObject(name);
			System.out.println(">> Master file is updated");
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void distribute() {
		String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
		System.out.println( chain);
		System.out.println(db.get(1));
		System.out.println(name.get(0));
		
		
		
		
	}
	
	public static void tester(String data, byte[] signature) throws Exception {
		BlockChainn bc = BlockChainn.getInstance(fileName);
		if (!new File(masterFolder).exists()) {
			System.err.println("> creating BlokcChain binary!");
			new File(masterFolder).mkdir();
			bc.genesis();
		}else {
			Asymmetric a = new Asymmetric();
			
			PrivateKey privateKeyy = KeyAccess.getPrivateKey("MyKeyPair/PrivateKey");
			String s = a.decrypt(data, privateKeyy);
			String[] credentials = s.split(",");
			
			TransactionCollection tranxLst = new TransactionCollection();
			
			for (String c: credentials) {
				System.out.println(c);
				tranxLst.add(c);
			}
			String merkleRoot = tranxLst.getMerkleRoot();
			String previousHash = bc.get().getLast().getHeader().getCurrentHash();
			Block b1 = new Block(previousHash, merkleRoot);
			b1.setTransaction(tranxLst);
			bc.nextBlock(b1, tranxLst);
			System.out.println("This is b1");
			System.out.println(b1);
			bc.distribute();
			
		}
	}
	


}