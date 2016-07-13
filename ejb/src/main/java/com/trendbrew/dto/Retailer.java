package com.trendbrew.dto;

import javax.persistence.Column;

import com.koinplus.common.data.GenericKoinPlusDataTransferObject;

/**
 * @author Abhijit Patil
 */

public class Retailer extends GenericKoinPlusDataTransferObject<Retailer> {
	
	private String name;
	private String  country;
	private String  displayName;
	private String  abbreviation;
	private String  imageUrl;
	private Integer socialRank;
	private Boolean hasBrewtique = Boolean.FALSE;
	private String  alternateCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getSocialRank() {
		return socialRank;
	}
	public void setSocialRank(Integer socialRank) {
		this.socialRank = socialRank;
	}
	public Boolean getHasBrewtique() {
		return hasBrewtique;
	}
	public void setHasBrewtique(Boolean hasBrewtique) {
		this.hasBrewtique = hasBrewtique;
	}
	public String getAlternateCode() {
		return alternateCode;
	}
	public void setAlternateCode(String alternateCode) {
		this.alternateCode = alternateCode;
	}
	@Override
	public String toString() {
		return "RetailerSignUp [name=" + name + ", country=" + country + ", displayName=" + displayName
				+ ", abbreviation=" + abbreviation + ", imageUrl=" + imageUrl + ", socialRank=" + socialRank
				+ ", hasBrewtique=" + hasBrewtique + ", alternateCode=" + alternateCode + "]";
	}

}
