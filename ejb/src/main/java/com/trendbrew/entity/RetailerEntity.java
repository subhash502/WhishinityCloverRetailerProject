package com.trendbrew.entity;

import com.koinplus.common.data.GenericKoinPlusDataEntity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Abhijit Patil
 */
@Entity @Table(name = "retailer")
public class RetailerEntity extends GenericKoinPlusDataEntity<RetailerEntity> {

	// Variables

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "sgid")              Long    sgid;
	private @Column(name = "name")              String  name;
	private @Column(name = "country")           String  country;
	private @Column(name = "display_name")      String  displayName;
	private @Column(name = "abbreviation")      String  abbreviation;
	private @Column(name = "image_url")         String  imageUrl;
	private @Column(name = "social_rank")       Integer socialRank;
	private @Column(name = "has_brewtique") Boolean hasBrewtique = Boolean.FALSE;
	private @Column(name = "alternate_code")      String  alternateCode;

	@ElementCollection(fetch = FetchType.EAGER) @CollectionTable(name = "retailer_websites", joinColumns = @JoinColumn(name = "retailer_sgid"))
	private @Column(name = "website") List<String> websites;

	// Joins

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "retailers")
	private Collection<ItemEntity> items;

	public RetailerEntity(String name) {
		this.name = name;
		this.displayName = name.replaceAll("\\.com", "").replaceAll("\\.net", "").replaceAll("www\\.", "");
	}

	public RetailerEntity() {}

	// Getter Setters

	public Long getSgid() {
		return this.sgid;
	}

	public void setSgid(Long retailerSgid) {
		this.sgid = retailerSgid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayname) {
		this.displayName = displayname;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSocialRank() {
		return socialRank;
	}

	public void setSocialRank(Integer socialRank) {
		this.socialRank = socialRank;
	}

	public Collection<ItemEntity> getItems() {
		return items;
	}

	public void setItems(Collection<ItemEntity> items) {
		this.items = items;
	}

	public List<String> getWebsites() {
		return websites;
	}

	public void setWebsites(List<String> websites) {
		this.websites = websites;
	}

	public Boolean getHasBrewtique() {
		return hasBrewtique;
	}

	public void setHasBrewtique(Boolean hasBrewtique) {
		this.hasBrewtique = hasBrewtique;
	}

	// Utility Methods

	public void addItem(ItemEntity prod) {
		if (this.items == null) this.items = new ArrayList<ItemEntity>();
		this.items.add(prod);
	}

	public void addWebsite(String website) {
		if (this.websites == null) this.websites = new ArrayList<String>();
		this.websites.add(website);
	}

	@Override public String toString() {
		return this.name + " " + this.sgid;
	}

	@Override public int compareTo(RetailerEntity o) {
		return this.getSgid().compareTo(o.getSgid());
	}

	@Override public int hashCode() {
		return this.toString().hashCode();
	}

	@Override public boolean equals(Object obj) {
		return obj instanceof RetailerEntity && this.toString().equals(obj.toString());
	}

	public String getAlternateCode() {
		return alternateCode;
	}

	public void setAlternateCode(String alternateCode) {
		this.alternateCode = alternateCode;
	}
}
