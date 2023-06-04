package com.anoy.load.itemmaster.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.anoy.load.itemmaster.sub.service.ItemMasterSubService;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ItemMasterSubSvcApplication {

	@Autowired
	ItemMasterSubService itemMasterSubService;
	
	public static void main(String[] args) {
		SpringApplication.run(ItemMasterSubSvcApplication.class, args);
	}
	

}
