package edu.bjtu.stream.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bjtu.stream.consumer.service.KafkaReciever;
//import edu.bjtu.stream.model.Address;
import edu.bjtu.stream.model.Customer;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private KafkaReciever reciever;
	
	@GetMapping("/current")
	public List<Customer> getCurrent() {
		return reciever.getCurrent();
				
	}

	@GetMapping("/all")
	public List<Customer> getAll() {
		return reciever.getAll();
				
	}

}
