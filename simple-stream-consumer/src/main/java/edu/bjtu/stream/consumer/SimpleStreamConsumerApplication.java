package edu.bjtu.stream.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("edu.bjtu.stream.consumer")
public class SimpleStreamConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleStreamConsumerApplication.class, args);
	}

}
