package com.trendbrew.entity;

import com.koinplus.common.data.GenericKoinPlusDataEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author Abhijit Patil
 */
@Entity @Table(name = "brand")
public class BrandEntity extends GenericKoinPlusDataEntity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "sgid")         Long   sgid;
	private @Column(name = "code")         String code;
	private @Column(name = "name")         String name;
	private @Column(name = "display_name") String displayName;
	private @Column(name = "website")      String website;
	private @Column(name = "image_url")    String imageUrl;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	private Collection<ItemEntity> products;

	// Getter Setters

	public Long getSgid() {
		return sgid;
	}

	public void setSgid(Long brandSgid) {
		this.sgid = brandSgid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		this.displayName = name.replaceAll("\\.com", "").replaceAll("\\.net", "").replaceAll("www\\.", "");
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Collection<ItemEntity> getProducts() {
		return products;
	}

	public void setProducts(Collection<ItemEntity> products) {
		this.products = products;
	}
}
