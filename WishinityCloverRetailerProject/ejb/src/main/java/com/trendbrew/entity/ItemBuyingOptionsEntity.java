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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Abhijit Patil
 */

@Entity @Table(name = "item_buying_options")
public class ItemBuyingOptionsEntity extends GenericKoinPlusDataEntity<ItemBuyingOptionsEntity> {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "buying_options_sgid") private Long buyingOptionsSgid;

	private @Column(name = "deal_start_dt") @Temporal(TemporalType.TIMESTAMP) Date       dealStartDate;
	private @Column(name = "deal_end_dt") @Temporal(TemporalType.TIMESTAMP)   Date       dealEndDate;
	private @Column(name = "record_date") @Temporal(TemporalType.TIMESTAMP)   Date       recordDate;
	private @Column(name = "deal_duration")                                   Long       dealDurationInDays;
	private @Column(name = "offer_price")                                     BigDecimal offerPrice;
	private @Column(name = "list_price")                                      BigDecimal listPrice;
	private @Column(name = "reward_amount")                                   BigDecimal rewardAmount;
	private @Column(name = "buying_option_type")                              String     buyingOptionType;
	private @Column(name = "seller_name")                                     String     sellerName;
	private @Column(name = "purchase_url")                                    String     purchaseUrl;
	private @Column(name = "affiliate_purchase_url")                          String     affiliatePurchaseUrl;
	private @Column(name = "coupon_code")                                     String     couponCode;
	private @Column(name = "deal_source")                                     String     dealSource;
	private @Column(name = "linked_credit_card")                              String     linkedCard;
	private @Column(name = "clo_discount")                                    Double     cloDiscount;

	@JoinColumn(name = "item_sgid") @ManyToOne(fetch = FetchType.LAZY)
	private ItemEntity item;

	@JoinColumn(name = "retailer_sgid") @ManyToOne(fetch = FetchType.LAZY)
	private RetailerEntity retailer;

	public Long getBuyingOptionsSgid() {
		return buyingOptionsSgid;
	}

	public void setBuyingOptionsSgid(Long crowdDealId) {
		this.buyingOptionsSgid = crowdDealId;
	}

	public Date getDealStartDate() {
		return dealStartDate;
	}

	public void setDealStartDate(Date dealStartDate) {
		this.dealStartDate = dealStartDate;
	}

	public Date getDealEndDate() {
		return dealEndDate;
	}

	public void setDealEndDate(Date dealEndDate) {
		this.dealEndDate = dealEndDate;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Long getDealDurationInDays() {
		return dealDurationInDays;
	}

	public void setDealDurationInDays(Long dealDurationInDays) {
		this.dealDurationInDays = dealDurationInDays;
	}

	public BigDecimal getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(BigDecimal dealPrice) {
		this.offerPrice = dealPrice;
	}

	public BigDecimal getListPrice() {
		return listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public BigDecimal getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(BigDecimal rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public String getBuyingOptionType() {
		return buyingOptionType;
	}

	public void setBuyingOptionType(String buyingOptionType) {
		this.buyingOptionType = buyingOptionType;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getPurchaseUrl() {
		return purchaseUrl;
	}

	public void setPurchaseUrl(String purchaseUrl) {
		this.purchaseUrl = purchaseUrl;
	}

	public String getAffiliatePurchaseUrl() {
		return affiliatePurchaseUrl;
	}

	public void setAffiliatePurchaseUrl(String affiliatePurchaseUrl) {
		this.affiliatePurchaseUrl = affiliatePurchaseUrl;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getDealSource() {
		return dealSource;
	}

	public void setDealSource(String dealSource) {
		this.dealSource = dealSource;
	}

	public String getLinkedCard() {
		return linkedCard;
	}

	public void setLinkedCard(String linkedCard) {
		this.linkedCard = linkedCard;
	}

	public Double getCloDiscount() {
		return cloDiscount;
	}

	public void setCloDiscount(Double cloDiscount) {
		this.cloDiscount = cloDiscount;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public RetailerEntity getRetailer() {
		return retailer;
	}

	public void setRetailer(RetailerEntity retailer) {
		this.retailer = retailer;
	}

	@Override public int compareTo(ItemBuyingOptionsEntity o) {

		int comparison = this.getRetailer().compareTo(o.getRetailer());

		if (comparison != 0) return comparison;
		comparison = o.getRecordDate().compareTo(this.getRecordDate());
		if (comparison != 0) return comparison;

		BigDecimal price2 = this.getOfferPrice();
		if (price2 == null) price2 = this.getListPrice();
		BigDecimal price1 = o.getOfferPrice();
		if (price1 == null) price1 = o.getListPrice();

		comparison = price2.compareTo(price1);
		return comparison;
	}
}
