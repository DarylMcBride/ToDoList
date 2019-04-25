package com.qa.boot.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;


public class ShoppingListContent {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer Id;
	
	
	private String itemName;
	private int quantity;
	
	public ShoppingListContent(String itemName, int quantity) {
		this.setItemName(itemName);
		this.setQuantity(quantity);
	}
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
