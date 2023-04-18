package org.springboot.kafka.example.controller;

import org.springboot.kafka.example.kafka.JsonKafkaProducer;
import org.springboot.kafka.example.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	JsonKafkaProducer  kafkaProducer;

	public JsonMessageController(JsonKafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(User user){
		kafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json Message sent to kafka Topic");
	}
	
	
}
