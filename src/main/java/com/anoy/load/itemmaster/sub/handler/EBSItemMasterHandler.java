package com.anoy.load.itemmaster.sub.handler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.anoy.load.itemmaster.sub.client.EBSClient;
import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EBSItemMasterHandler {
	
	@Autowired
	EBSClient ebsClient;
	
	public Optional<EbsItemMasterEntity> getItemMasterFromEbs(String itemNumner) {
		int tries = 1;
		Optional<ResponseEntity<EbsItemMasterEntity>> ebsItemMasterResponse;
		do {
			ebsItemMasterResponse = Optional.ofNullable(ebsClient.performRequest(EbsItemMasterEntity.class,HttpMethod.GET,itemNumner));
		}while(tries++ <= 3 && !ebsItemMasterResponse.isPresent());
		
return !ebsItemMasterResponse.isPresent()?Optional.empty() : Optional.ofNullable(ebsItemMasterResponse.get().getBody());
	}

}
