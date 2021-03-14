package com.subhash.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "CreateOrder")
public class Order {

	@Id
	@GeneratedValue
	@NonNull
	@Column(name = "orderId")
	private Integer orderId;

	@Column(name = "order_Date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "order_Status")
	private String orderStatus;

	@OneToMany
	@JoinColumn(name = "itemIdFK")
	private List<Item> itemList;

}
