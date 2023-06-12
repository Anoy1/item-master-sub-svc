package com.anoy.load.itemmaster.sub.service;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import com.anoy.load.itemmaster.sub.handler.DhlItemMasterHandler;
import com.anoy.load.itemmaster.sub.handler.EBSItemMasterHandler;
import com.anoy.load.itemmaster.sub.model.DhlResponseEntity;
import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;
import com.anoy.load.itemmaster.sub.model.ItemMasterData;

@Service
public class ItemMasterSubService {

	@Autowired
	EBSItemMasterHandler ebsItemMasterHandler;
	@Autowired
	DhlItemMasterHandler dhlItemMasterHandler;


	public Optional<EbsItemMasterEntity> getItemFromEbs(Optional<ItemMasterData> itemMasterData) {
		Optional<EbsItemMasterEntity> ebsResponse = ebsItemMasterHandler.getItemMasterFromEbs(itemMasterData.get().getItemId().toString());
		Optional<DhlResponseEntity> dhlResponse = dhlItemMasterHandler.postItemMastertoDhl(ebsResponse);
	return ebsResponse;
	}

}
