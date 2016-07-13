package com.trendbrew.entity;

import com.koinplus.common.data.GenericKoinPlusDataEntity;
import com.trendbrew.vocab.BrewerType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * User: abhijit
 * Date: 4/1/13
 * Time: 11:33 PM
 */
@Entity @Table(name = "retailer_user")
public class RetailerUserEntity extends GenericKoinPlusDataEntity {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Column(name = "sgid", nullable = false) Long   sgid;
	private @Column(name = "trendbrew_id")           String trendbrewId;
	private @Column(name = "first_name")             String firstName;
	private @Column(name = "last_name")              String lastName;
	private @Column(name = "middle_name")            String middleName;
	private @Column(name = "salutation")             String salutation;
	private @Column(name = "suffix")                 String suffix;
	private @Column(name = "location")               String location;
	private @Column(name = "image_url")              String imageUrl;
	private @Column(name = "email")                  String loginEmail;
	private @Column(name = "password")               byte[] password;
	private @Column(name = "salt")                   byte[] salt;
	private @Column(name = "password_plain")         String passwordPlain;
	private @Column(name = "temp_password")          String tempPassword;
	private @Column(name = "brewer_type") @Enumerated BrewerType brewerType = BrewerType.BREWER;

	@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "retailer_id", referencedColumnName = "sgid", nullable = false)
	private RetailerEntity retailer;

	public Long getSgid() {
		return sgid;
	}

	public void setSgid(Long sgid) {
		this.sgid = sgid;
	}

	public String getTrendbrewId() {
		return trendbrewId;
	}

	public void setTrendbrewId(String koinplusId) {
		this.trendbrewId = koinplusId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return this.firstName + ' ' + this.lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getPasswordPlain() {
		return passwordPlain;
	}

	public void setPasswordPlain(String passwordPlain) {
		this.passwordPlain = passwordPlain;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public BrewerType getBrewerType() {
		return brewerType;
	}

	public void setBrewerType(BrewerType brewerType) {
		this.brewerType = brewerType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	// Joins

	public RetailerEntity getRetailer() {
		return retailer;
	}

	public void setRetailer(RetailerEntity retailer) {
		this.retailer = retailer;
	}

	// Supporting methods

	@Override public boolean equals(Object obj) {
		return obj instanceof RetailerUserEntity && ((RetailerUserEntity) obj).getSgid().equals(this.getSgid());
	}
}
