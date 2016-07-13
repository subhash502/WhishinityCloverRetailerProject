package com.trendbrew.entity;

import com.koinplus.common.data.GenericKoinPlusDataEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Abhijit Patil
 */

@Entity @Table(name = "item_code")
public class ItemCodeEntity extends GenericKoinPlusDataEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sgid") private               Long       sgid;
	@Column(name = "item_code") private          String     itemCode;
	@Column(name = "item_code_type") private     String     itemCodeType;
	@Column(name = "inventory_status") private   String     inventoryStatus;
	@Column(name = "list_price") private         BigDecimal listPrice;
	@Column(name = "sale_price") private         BigDecimal salePrice;
	@Column(name = "shipping_surcharge") private BigDecimal shippingSurcharge;

	@JoinColumn(name = "item_sgid") @ManyToOne(fetch = FetchType.LAZY)
	private ItemEntity item;

	@JoinColumn(name = "provider_sgid") @ManyToOne(fetch = FetchType.LAZY)
	private RetailerEntity retailer;

	@JoinColumn(name = "manufacturer_sgid") @ManyToOne(fetch = FetchType.LAZY)
	private BrandEntity manufacturer;

	public Long getSgid() {
		return sgid;
	}

	public void setSgid(Long sgid) {
		this.sgid = sgid;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemCodeType() {
		return itemCodeType;
	}

	public void setItemCodeType(String itemCodeType) {
		this.itemCodeType = itemCodeType;
	}

	public String getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getShippingSurcharge() {
		return shippingSurcharge;
	}

	public void setShippingSurcharge(BigDecimal shippingSurcharge) {
		this.shippingSurcharge = shippingSurcharge;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public RetailerEntity getProvider() {
		return retailer;
	}

	public void setProvider(RetailerEntity retailer) {
		this.retailer = retailer;
	}

	public BrandEntity getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(BrandEntity manufacturer) {
		this.manufacturer = manufacturer;
	}

	public RetailerEntity getRetailer() {
		return retailer;
	}

	public void setRetailer(RetailerEntity retailer) {
		this.retailer = retailer;
	}
}
