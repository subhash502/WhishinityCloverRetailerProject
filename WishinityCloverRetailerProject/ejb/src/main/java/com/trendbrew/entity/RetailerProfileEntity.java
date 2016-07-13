package com.trendbrew.entity;

import com.koinplus.common.data.GenericKoinPlusDataEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Abhijit Patil
 */

@Entity @Table(name = "retailer_profile")
public class RetailerProfileEntity extends GenericKoinPlusDataEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sgid") private        Long   sgid;
	@Column(name = "street") private      String street;
	@Column(name = "city") private        String city;
	@Column(name = "state") private       String state;
	@Column(name = "zip") private         String zip;
	@Column(name = "website") private     String website;
	@Column(name = "email") private       String email;
	@Column(name = "image") private       String image;
	@Column(name = "facebook") private    String facebookId;
	@Column(name = "twitter") private     String twitterId;
	@Column(name = "instagram") private   String instagramId;
	@Column(name = "pinterest") private   String pinterestId;
	@Column(name = "google_plus") private String googlePlusId;


	@OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "retailer_id", referencedColumnName = "merchant_sgid")
	private RetailerEntity retailer;

	public Long getSgid() {
		return sgid;
	}

	public void setSgid(Long sgid) {
		this.sgid = sgid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String address) {
		this.street = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getFacebookId() {
		return facebookId;
	}

	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}

	public String getTwitterId() {
		return twitterId;
	}

	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}

	public String getInstagramId() {
		return instagramId;
	}

	public void setInstagramId(String instagramId) {
		this.instagramId = instagramId;
	}

	public String getPinterestId() {
		return pinterestId;
	}

	public void setPinterestId(String pinterestId) {
		this.pinterestId = pinterestId;
	}

	public String getGooglePlusId() {
		return googlePlusId;
	}

	public void setGooglePlusId(String googlePlustId) {
		this.googlePlusId = googlePlustId;
	}

	public RetailerEntity getRetailer() {
		return retailer;
	}

	public void setRetailer(RetailerEntity retailer) {
		this.retailer = retailer;
	}
}
