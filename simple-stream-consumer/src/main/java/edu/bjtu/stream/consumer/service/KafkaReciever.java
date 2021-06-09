package edu.bjtu.stream.consumer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import edu.bjtu.stream.model.Customer;

@Service
public class KafkaReciever {
	
	private List<Customer> allList = new ArrayList<>(); 
	private List<Customer> currentList = new ArrayList<>(); 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

	@KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	public void recieveData(Customer student) {
		LOGGER.info("Data - " + student.toString() + " recieved");
		//LOGGER.info("Data - " + student + " recieved");
		System.out.println("Received Message - student id : " + student.getCustomerId());
		System.out.println("Received Message - student name: " + student.getFirstName() + " " + student.getLastName());
        currentList.add(student);
 	}
	
	@KafkaListener(topicPartitions = @TopicPartition(topic = "${spring.kafka.topic.name}", partitionOffsets = {
		    @PartitionOffset(partition = "0", initialOffset = "0") }), containerFactory = "kafkaListenerContainerFactory",
		    groupId = "group-2")
	public void addtoList(Customer student) {
		LOGGER.info("Data - " + student.toString() + " recieved");
		//LOGGER.info("Data - " + student + " recieved");
		System.out.println("Received Message - student id : " + student.getCustomerId());
		System.out.println("Received Message - student name: " + student.getFirstName() + " " + student.getLastName());
        allList.add(student);
	}
	
	public List<Customer> getCurrent() {
		return currentList;
	}
	
	public List<Customer> getAll() {
		return allList;
	}

}
