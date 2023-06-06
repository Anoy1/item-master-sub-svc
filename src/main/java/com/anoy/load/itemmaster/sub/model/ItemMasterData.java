package com.anoy.load.itemmaster.sub.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemMasterData {
	
	private Integer itemId;
	private String interfaceName;
	private Date createdDate;
	private String itemStore;
	private String itemLocation;
	private Double itemPrice;
	private String itemStatus;
	private String itemType;
	private String messageId;
	private String runTime;
}
