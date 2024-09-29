package com.deliveryboy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstant;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, String>KafkaTempelate;
	
	
	private Logger logger = LoggerFactory.getLogger(KafkaService.class);
	
	public boolean UpdateLocation(String location) {
		
		this.KafkaTempelate.send(AppConstant.LOCATION_TOPIC_NAME,location);
		this.logger.info("Message Produces");
		return true;
	}

}
