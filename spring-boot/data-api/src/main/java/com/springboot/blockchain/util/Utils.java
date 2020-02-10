package com.springboot.blockchain.util;

import java.security.MessageDigest;
import java.util.List;

import com.springboot.blockchain.domain.Block;
import com.springboot.blockchain.exceptions.InvalidBlockChainException;

public class Utils {

	// Applies Sha256 to a string and returns the result.
	public static String applySha256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			// Applies sha256 to our input,
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void validateBlockChain(List<Block> blockchain) {
		Block currentBlock;
		Block previousBlock;
		for (int i = 0; i < blockchain.size()-1; i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i + 1);
			if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
				throw new InvalidBlockChainException(
						String.format("Block %d hash is not matching with its block data", i));
			}
			if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
				System.out.println("Previous Hashes not equal");
				throw new InvalidBlockChainException(
						String.format("Block %d previous hash and %d block hash values are not matching", i - 1, i));
			}
		}
	}

}
