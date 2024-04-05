package bcd_assignments;

import java.io.Serializable;
import java.sql.Timestamp;

public class Block implements Serializable {
	
	Header header;
	TransactionCollection tc;
	private static final long serialVersionUID = 1L;
	
	public Block(String previousHash, String merkleRoot) {
		header = new Header();
		header.setTimeStamp(new Timestamp(System.currentTimeMillis()).getTime());
		header.setPreviousHash(previousHash);
		header.setMerkleRoot(merkleRoot);
		String info = String.join("+", Integer.toString(header.getIndex()), 
				Long.toString(header.getTimeStamp()), header.getPreviousHash());
		String blockHash  = Blockchain.sha256(info);
		header.setCurrentHash(blockHash);
	}
	
	public Header getHeader() {
		return this.header;
	}
	
	public void setTransaction(TransactionCollection tc) {
		this.tc = tc;
	}

	@Override
	public String toString() {
		return "Block [header=" + header + ", tc=" + tc + "]";
	}
	
	public class Header implements Serializable {
		int index;
		String currentHash;
		String previousHash;
		long timeStamp;
		String merkleRoot;
		private static final long serialVersionUID = 1L;
		
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getCurrentHash() {
			return currentHash;
		}
		public void setCurrentHash(String currentHash) {
			this.currentHash = currentHash;
		}
		public String getPreviousHash() {
			return previousHash;
		}
		public void setPreviousHash(String previousHash) {
			this.previousHash = previousHash;
		}
		public long getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(long timeStamp) {
			this.timeStamp = timeStamp;
		}
		public void setMerkleRoot(String merkleRoot) {
			this.merkleRoot = merkleRoot;
		}
		@Override
		public String toString() {
			return "Header [index=" + index + ", currentHash=" + currentHash + ", previousHash=" + previousHash
					+ ", timeStamp=" + timeStamp + ", merkleRoot=" + merkleRoot + "]";
		}
		
		
		
		

	}

	
	

}