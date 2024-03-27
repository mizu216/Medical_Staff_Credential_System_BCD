package bcd_assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

public class BlockChainn {
	
	private static LinkedList<Block> db = new LinkedList<Block>();
	private static BlockChainn _instance = null;
	public  String chainFile;
	private static String masterFolder = "master";
	private static String fileName = masterFolder + "/chain.bin";
	
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
		Block genesis = new Block("0");
		db.add(genesis);
		persist();
	}
	
	public void nextBlock(Block newBlock) {
		db = get();
		db.add(newBlock);
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
	
	private void persist() {
		try
			(FileOutputStream fout = new FileOutputStream(this.chainFile);
				ObjectOutputStream out = new ObjectOutputStream( fout );
				){
			out.writeObject(db);
			System.out.println(">> Master file is updated");
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void distribute() {
		String chain = new GsonBuilder().setPrettyPrinting().create().toJson(db);
		System.out.println( chain );
	}
	
	public void tester() {
		BlockChainn bc = BlockChainn.getInstance(fileName);
		if (!new File(masterFolder).exists()) {
			System.err.println("> creating BlokcChain binary!");
			new File(masterFolder).mkdir();
			bc.genesis();
		}else {
			String line1 = "bob|alice|debit|100";
			String line2 = "mick|alice|debit|200";
			
			TransactionCollection tranxLst = new TransactionCollection();
			tranxLst.add(line1);
			tranxLst.add(line2);
			
			String previousHash = bc.get().getLast().getHeader().getCurrentHash();
			Block b1 = new Block(previousHash);
			b1.setTransaction(tranxLst);
			bc.nextBlock(b1);
			System.out.println("This is b1");
			System.out.println(b1);
			bc.distribute();
			
		}
	}
	


}