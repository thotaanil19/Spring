package com.springboot.blockchain.domain;

import java.util.Date;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.blockchain.util.Utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Document("Block")
@Entity("Block")

public class Block {

	@Id
	@Field("_id")
	@org.mongodb.morphia.annotations.Id
	private String id;
	
	//@Reference
	private Registration data;
	
	@Field("Hash")
	@Property("Hash")
	private String hash;
	
	@Field("PreviousHash")
	@Property("PreviousHash")
	private String previousHash;
	
	@Field("TimeStamp")
	@Property("TimeStamp")
	private long timeStamp;

	public Block(Registration data, String previousHash) {
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		this.hash = calculateHash();
	}

	public String calculateHash() {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(this.data);
		} catch (Exception e) {
			throw new RuntimeException("Failed to convert Registration data into JSON String");
		}
		String calculatedhash = Utils.applySha256(previousHash + Long.toString(timeStamp) + json);
		return calculatedhash;
	}
}
