package org.springboot.kafka.example.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.kafka.example.payload.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

	private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics="topic_2",groupId="myGroup")
	public void consume(User user) {
		LOGGER.info(String.format("Json message recieved -> %s",user.toString()));
	}
}
