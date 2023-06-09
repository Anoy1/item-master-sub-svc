package com.anoy.load.itemmaster.sub.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.anoy.load.itemmaster.sub.model.EbsItemMasterEntity;
import com.sun.net.httpserver.Headers;

import lombok.extern.slf4j.Slf4j;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@Component
@Slf4j
public class EBSClient {
	
	@Autowired
	RestTemplate restTemplate;

	public <Response> ResponseEntity<EbsItemMasterEntity> performRequest(Class<EbsItemMasterEntity> responseClass, HttpMethod method, String itemNumber) {
		 ResponseEntity<EbsItemMasterEntity> ebsItemMasterResponse = null;
		 try {
			 ebsItemMasterResponse = restTemplate.exchange(buildUrl(itemNumber), method,getHttpEntity(),responseClass);
		 }catch(Exception e) {
			 
		 }
		 return ebsItemMasterResponse;
		 }

	private HttpEntity getHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(null,headers);
	}

	private String buildUrl(String itemNumber) throws Exception{
try {
		return UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port("8090")
				.path(getEndpoint(itemNumber))
				.build().toString();
}catch(Exception e) {
	throw new Exception();
}
	}

	private String getEndpoint(String itemNumber) {
		return String.format("api/%s", itemNumber);
	}

}
