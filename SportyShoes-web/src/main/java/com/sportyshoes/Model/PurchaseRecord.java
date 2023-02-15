package com.sportyshoes.Model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Purchase_Record")
public class PurchaseRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String productName;
	@Column(name="Category")
	private String productCategory;
	@Column
	private Double productPrice;
	@Column
	private String purchasedBy;
	@Column
	private String userAddress;
	@Column
	private String paymentType;
	@Column(name="Purchase_Date")
	private String datoOfPurchase;
	public PurchaseRecord(int id, String productName, String productCategory, Double productPrice, String purchasedBy,
			String userAddress, String paymentType, String datoOfPurchase ) {
		super();
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.purchasedBy = purchasedBy;
		this.userAddress = userAddress;
		this.paymentType = paymentType;
		this.datoOfPurchase=datoOfPurchase;
	}
	public PurchaseRecord(String productName, String productCategory, Double productPrice, String purchasedBy,
			String userAddress, String paymentType, String datoOfPurchase ) {
		super();
		
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.purchasedBy = purchasedBy;
		this.userAddress = userAddress;
		this.paymentType = paymentType;
		this.datoOfPurchase=datoOfPurchase;
	}
	public PurchaseRecord() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public String getPurchasedBy() {
		return purchasedBy;
	}
	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getDatoOfPurchase() {
		return datoOfPurchase;
	}
	public void setDatoOfPurchase(String datoOfPurchase) {
		this.datoOfPurchase = datoOfPurchase;
	}
	@Override
	public String toString() {
		return String.format("PurchaseRecord [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", productPrice=" + productPrice + ", purchasedBy=" + purchasedBy + ", userAddress=" + userAddress
				+ ", paymentType=" + paymentType + ", datoOfPurchase=" + datoOfPurchase + "]", id,productName,productCategory,productPrice,purchasedBy,userAddress,paymentType,datoOfPurchase) ;
	}
	
	
	
	
	
	
	
	
	
}
