package com.anoy.load.itemmaster.sub.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.anoy.load.itemmaster.sub.model.DhlResponseEntity;
import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DHLClient {
	@Autowired
	RestTemplate restTemplate;

	public <Response> ResponseEntity<DhlResponseEntity> performRequest(Class<DhlResponseEntity> responseClass, HttpMethod method, Optional<EbsItemMasterEntity> ebsResponse) {
		 ResponseEntity<DhlResponseEntity> ebsItemMasterResponse = null;
		 try {
			 ebsItemMasterResponse = restTemplate.exchange(buildUrl(ebsResponse), method,getHttpEntity(),responseClass);
		 }catch(Exception e) {
			 
		 }
		 return ebsItemMasterResponse;
		 }

	private HttpEntity getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(null,headers);
	}

	private String buildUrl(Optional<EbsItemMasterEntity> ebsResponse) throws Exception{
try {
		return UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port("8099")
				.path(getEndpoint(ebsResponse.get().getItemId()))
				.build().toString();
}catch(Exception e) {
	throw new Exception();
}
	}

	private String getEndpoint(String itemNumber) {
		return String.format("api/%s", itemNumber);
	}
	
}
