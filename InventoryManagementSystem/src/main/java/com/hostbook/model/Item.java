package com.hostbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Item {

	@Id
	@NonNull
	@GeneratedValue
	private Integer id;
	private String itemName;
	private String itemImage;
	private String itemCategory;

	private Integer itemQuantity;
	private Integer itemUnit;
	private Double itemUnitPrice;
	private String itemStatus;

}
