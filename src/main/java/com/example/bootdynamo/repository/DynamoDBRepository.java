package com.example.bootdynamo.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.bootdynamo.model.Music;

@Repository
public class DynamoDBRepository {
	
	private static final Logger log = LoggerFactory.getLogger(DynamoDBRepository.class);
	
	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public void insertIntoDynamoDB(Music music) {
		dynamoDBMapper.save(music);
		
	}
	public Music getMusicDetails(String artist,String songTitle) {
		return dynamoDBMapper.load(Music.class, artist,songTitle);
	}
}
