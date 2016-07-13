package com.trendbrew.dam;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Column;

import com.koinplus.common.annotations.DataAccessManager;
import com.koinplus.common.data.GenericKoinPlusDataAccessManager;
import com.koinplus.common.util.KoinPlusEncryptionUtil;
import com.trendbrew.dao.RetailerUserDAO;
import com.trendbrew.dto.Retailer;
import com.trendbrew.entity.RetailerEntity;

@Stateless @DataAccessManager
public class RetailerUserDataAccessManager extends GenericKoinPlusDataAccessManager {

	@EJB private RetailerUserDAO         retailUserDAO;
	@EJB private KoinPlusEncryptionUtil encryptionUtil;
	
public void retailerSignUp(Retailer signUp){
		RetailerEntity entity = new RetailerEntity();
		entity.setName(signUp.getName());
		entity.setCountry(signUp.getCountry());
		entity.setDisplayName(signUp.getDisplayName());
		entity.setAbbreviation(signUp.getAbbreviation());
		entity.setImageUrl(signUp.getImageUrl());
		entity.setSocialRank(signUp.getSocialRank());
		entity.setHasBrewtique(signUp.getHasBrewtique());
		entity.setAlternateCode(signUp.getAlternateCode());
		
		retailUserDAO.insert(entity);
	}

}
