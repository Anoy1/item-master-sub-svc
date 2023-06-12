package com.anoy.load.itemmaster.sub.handler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.anoy.load.itemmaster.sub.client.DHLClient;
import com.anoy.load.itemmaster.sub.client.EBSClient;
import com.anoy.load.itemmaster.sub.model.DhlResponseEntity;
import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;

import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
public class DhlItemMasterHandler {

	@Autowired
	DHLClient dhlClient;
	
	public Optional<DhlResponseEntity> postItemMastertoDhl(Optional<EbsItemMasterEntity> ebsResponse) {
		int tries = 1;
		Optional<ResponseEntity<DhlResponseEntity>> ebsItemMasterResponse;
		do {
			ebsItemMasterResponse = Optional.ofNullable(dhlClient.performRequest(DhlResponseEntity.class,HttpMethod.POST,ebsResponse));
		}while(tries++ <= 3 && !ebsItemMasterResponse.isPresent());
		
return !ebsItemMasterResponse.isPresent()?Optional.empty() : Optional.ofNullable(ebsItemMasterResponse.get().getBody());
	}
	
}
