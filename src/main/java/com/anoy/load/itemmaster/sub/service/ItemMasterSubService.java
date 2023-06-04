package com.anoy.load.itemmaster.sub.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ItemMasterSubService {

@KafkaListener(topics = "itemmaster", groupId = "group_id")
public void consume(String message)
{
 System.out.println("message = " + message);
}
	public void processData() {
		
	}
}
