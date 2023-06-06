package com.anoy.load.itemmaster.sub.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.anoy.load.itemmaster.sub.model.ItemMasterData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemMasterConsumer {
	
	@Autowired
	ObjectMapper mapper;
	
	@KafkaListener(topics = "itemmaster", groupId = "group_id", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consume(ConsumerRecord<String, String> data,Acknowledgment acknowledgment) throws JsonMappingException, JsonProcessingException {
		acknowledgment.acknowledge();
		ItemMasterData itemMasterData = mapper.readValue(data.value(),ItemMasterData.class);
		System.out.println("message = " + itemMasterData.getItemId() + itemMasterData.getMessageId());
	}

}
