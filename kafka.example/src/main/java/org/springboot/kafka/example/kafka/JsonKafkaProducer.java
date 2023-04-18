package org.springboot.kafka.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.kafka.example.payload.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

	
	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	private KafkaTemplate<String,User> kafkaTemplate;

	public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		LOGGER.info(String.format("Message sent -> %s",data.toString()));
		Message<User>message=MessageBuilder
				.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC,"Topic_2")
				.build();
		kafkaTemplate.send(message);
	}
}
