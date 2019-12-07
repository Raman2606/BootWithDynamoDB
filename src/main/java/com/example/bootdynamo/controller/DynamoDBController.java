package com.example.bootdynamo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootdynamo.model.Music;
import com.example.bootdynamo.repository.DynamoDBRepository;

@RestController()
public class DynamoDBController {

	@Autowired
	private DynamoDBRepository dynamoDBRepository;

	@PostMapping
	public String insertDynamoDB(@RequestBody Music music) {
		dynamoDBRepository.insertIntoDynamoDB(music);
		
		return "Successfully iniserted";
	}

	@GetMapping("/test")
	public ResponseEntity<Music> getMusicDetails(@RequestParam String artist, @RequestParam String songTitle) {
		Music music  = dynamoDBRepository.getMusicDetails(artist, songTitle);
		return new ResponseEntity<Music>(music, HttpStatus.OK);
	}
}
