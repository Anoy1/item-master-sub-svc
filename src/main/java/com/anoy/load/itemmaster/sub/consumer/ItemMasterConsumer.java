package com.anoy.load.itemmaster.sub.consumer;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.anoy.load.itemmaster.sub.handler.EBSItemMasterHandler;
import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;
import com.anoy.load.itemmaster.sub.model.ItemMasterData;
import com.anoy.load.itemmaster.sub.service.ItemMasterSubService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemMasterConsumer {
	
	@Autowired
	ObjectMapper mapper;
	@Autowired
	EBSItemMasterHandler ebsItemMasterHandler;
	@Autowired
	ItemMasterSubService itemMasterSubService;
	
	@KafkaListener(topics = "itemtopic", groupId = "group_id", containerFactory = "concurrentKafkaListenerContainerFactory")
	public void consume(ConsumerRecord<String, String> data,Acknowledgment acknowledgment) throws JsonMappingException, JsonProcessingException {
		acknowledgment.acknowledge();
		
		Optional<ItemMasterData> itemMasterData = Optional.ofNullable(mapper.readValue(data.value(),ItemMasterData.class));
		if(itemMasterData.isPresent()) {
			Optional<EbsItemMasterEntity> response = itemMasterSubService.getItemFromEbs(itemMasterData);
			System.out.println(response.get().toString());
			System.out.println("message = " + response.get().getItemId() + itemMasterData.get().getMessageId());
		
		}
		
		}

}
