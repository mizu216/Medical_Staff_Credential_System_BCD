package bcd_assignments;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionCollection implements Serializable{
	int SIZE = 10;
	String merkleRoot;
	List<String> tranxList = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	
	public void add(String tranx) {
		tranxList.add(tranx);
	}

	@Override
	public String toString() {
		String res = "";
		for(String credentials: tranxList) {
			res = res + credentials + ",";
			
		}
		return res;
	}
	
	public String getMerkleRoot() {
		MerkleTree mt = MerkleTree.getInstance(tranxList);
		mt.build();
		String root = mt.getRoot();
		return root;
		
	}
	
	

	
	
	

}
