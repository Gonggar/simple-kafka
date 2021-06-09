package edu.bjtu.stream.producer.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import edu.bjtu.stream.model.Customer;

@Service
public class KafkaSender {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;

	@Value("${spring.kafka.topic.name}")
	private String topicName;

	public void sendData(Customer customer) {
		// TODO Auto-generated method stub
//		Map<String, Object> headers = new HashMap<>();
//		headers.put(KafkaHeaders.TOPIC, topicName);
//		kafkaTemplate.send(new GenericMessage<String>(student.toString(), headers));
		// use the below to send String values through kafka
		this.kafkaTemplate.send(topicName, customer);
		LOGGER.info("Data - " + customer.toString() + " sent to Kafka Topic - " + topicName);
	}
}
