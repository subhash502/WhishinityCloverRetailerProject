package com.trendbrew.entity;


import com.koinplus.common.data.GenericKoinPlusDataEntity;
import com.trendbrew.vocab.ItemCodeType;
import org.apache.commons.collections.CollectionUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * @author Abhijit Patil
 */
@Entity @Table(name = "item")
public class ItemEntity extends GenericKoinPlusDataEntity<ItemEntity> {

	// Variables
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "sgid")                                            Long    itemSgid;
	private @Column(name = "name")                                            String  name;
	private @Column(name = "gender")                                          String  gender;
	private @Column(name = "display_name")                                    String  displayName;
	private @Column(name = "source_url")                                      String  sourceUrl;
	private @Column(name = "image_url")                                       String  imageUrl;
	private @Column(name = "description")                                     String  description;
	private @Column(name = "brew_channel")                                    Integer brewChannel;
	private @Column(name = "social_rank")                                     Integer socialRank;
	private @Column(name = "added_time") @Temporal(TemporalType.TIMESTAMP)    Date    addedTime;
	private @Column(name = "accessed_time") @Temporal(TemporalType.TIMESTAMP) Date    accessedTime;
	private @Column(name = "updated_time") @Temporal(TemporalType.TIMESTAMP)  Date    updatedTime;

	private @Column(name = "discontinued")    Boolean    discontinued   = Boolean.FALSE;
	private @Column(name = "predicted_price") BigDecimal predictedPrice = BigDecimal.ZERO;

	// Joins

	//@OneToOne(mappedBy = "product", fetch = FetchType.LAZY) private ProductContentEntity productContent;
	//@OneToMany(mappedBy = "product", fetch = FetchType.LAZY) private Collection<ProductImagesEntity> productImages;

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "brand_sgid")
	private BrandEntity brand;


	@ManyToMany @JoinTable(name = "retailer_item", joinColumns = {@JoinColumn(name = "item_sgid")}, inverseJoinColumns = {@JoinColumn(name = "retailer_sgid")})
	private Collection<RetailerEntity> retailers;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Collection<ItemCodeEntity> itemCodes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
	private Collection<ItemBuyingOptionsEntity> buyingOptions;

	// Getter Setters

	public Long getItemSgid() {
		return itemSgid;
	}

	public void setItemSgid(Long productId) {
		this.itemSgid = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String productUrl) {
		this.sourceUrl = productUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPredictedPrice() {
		return predictedPrice;
	}

	public void setPredictedPrice(BigDecimal predictedPrice) {
		this.predictedPrice = predictedPrice;
	}

	public Boolean getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}

	public Integer getBrewChannel() {
		return brewChannel;
	}

	public void setBrewChannel(Integer brewChannel) {
		this.brewChannel = brewChannel;
	}

	public Date getAddedTime() {
		return addedTime;
	}

	public void setAddedTime(Date addedTime) {
		this.addedTime = addedTime;
	}

	public Date getAccessedTime() {
		return accessedTime;
	}

	public void setAccessedTime(Date accessedTime) {
		this.accessedTime = accessedTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public Integer getSocialRank() {
		return socialRank;
	}

	public void setSocialRank(Integer socialRank) {
		this.socialRank = socialRank;
	}

	// Joins

	public BrandEntity getBrand() {
		return brand;
	}

	public void setBrand(BrandEntity brand) {
		this.brand = brand;
	}

	public Collection<ItemCodeEntity> getItemCodes() {
		return itemCodes;
	}

	public void setItemCodes(Collection<ItemCodeEntity> itemCodes) {
		this.itemCodes = itemCodes;
	}

	public Collection<RetailerEntity> getRetailers() {
		return retailers;
	}

	public void setRetailers(Collection<RetailerEntity> merchants) {
		this.retailers = merchants;
	}

	public Collection<ItemBuyingOptionsEntity> getBuyingOptions() {
		return buyingOptions;
	}

	public void setBuyingOptions(Collection<ItemBuyingOptionsEntity> crowdDeals) {
		this.buyingOptions = crowdDeals;
	}

	// Utility Methods

	public void addRetailer(RetailerEntity merchant) {
		if (this.retailers == null) this.retailers = new HashSet<RetailerEntity>();
		if (!this.retailers.contains(merchant)) this.retailers.add(merchant);
	}

	public void addItemCode(ItemCodeEntity itemCodeEntity) {
		if (this.itemCodes == null) this.itemCodes = new ArrayList<ItemCodeEntity>();
		this.itemCodes.add(itemCodeEntity);
	}

	public void addBuyingOption(ItemBuyingOptionsEntity buyingOption) {
		if (this.buyingOptions == null) this.buyingOptions = new ArrayList<ItemBuyingOptionsEntity>();
		this.buyingOptions.add(buyingOption);
	}

	public Boolean listedAtMerchant(Long merchantId) {
		if (this.retailers != null) {
			for (RetailerEntity merchantEntity : this.retailers) {
				if (merchantEntity.getSgid().equals(merchantId)) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	public Boolean hasCodeOfType(String codeType) {
		if (CollectionUtils.isNotEmpty(this.itemCodes)) {
			for (ItemCodeEntity itemCodeEntity : this.itemCodes) {
				if (ItemCodeType.SKU.equalsIgnoreCase(itemCodeEntity.getItemCodeType())) {
					return Boolean.TRUE;
				}
			}
		}
		return Boolean.FALSE;
	}

	// Overridden Methods

	@Override
	public String toString() {
		return name;
	}
}
