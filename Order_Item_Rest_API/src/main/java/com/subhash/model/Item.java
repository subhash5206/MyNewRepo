package com.subhash.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table(name="CreateItem")
public class Item {

	@Id
	@GeneratedValue
	@NonNull
	@Column(name="item_Id")
	private Integer itemId;

	@Column(name="item_name")
	private String itemName;

	@Column(name="item_unit_price")
	private Double itemUnitPrice;

	@Column(name="item_quantity")
	private Integer itemQuantity;

}
