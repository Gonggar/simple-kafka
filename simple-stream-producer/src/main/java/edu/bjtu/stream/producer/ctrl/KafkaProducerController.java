package edu.bjtu.stream.producer.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.bjtu.stream.model.Address;
import edu.bjtu.stream.model.Customer;
import edu.bjtu.stream.producer.service.KafkaSender;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

	@Autowired
	private KafkaSender sender;
	
	@GetMapping
	public Customer getCustomer() {
		Customer s = new Customer();
		s.setCustomerId("SID_001");
		s.setFirstName("Zhang");
		s.setLastName("Liping");
		s.setAge("25");
		
		Address a = new Address();
		a.setApartment("No.12-1001 Xinyuanxiaoqu ");
		a.setStreet("No.21 Xiangjiang Road");
		a.setCity("Xinglong");
		a.setState("Hubei");
		a.setPostCode("320120");
		s.setAddress(a);
		return s;
				
	}
	
	@PostMapping
	public ResponseEntity<String> sendData(@RequestBody Customer customer){
		sender.sendData(customer);
		return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
	}
}
