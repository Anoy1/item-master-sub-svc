package com.anoy.load.itemmaster.sub.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class ItemMasterSubService {

@KafkaListener(topics = "itemmaster", groupId = "group_id")
public void consume(ConsumerRecord<String, String> data)
{
 System.out.println("message = " + data.value().toString());
 //acknowledgment.acknowledge();
}
	public void processData() {
		
	}
}
