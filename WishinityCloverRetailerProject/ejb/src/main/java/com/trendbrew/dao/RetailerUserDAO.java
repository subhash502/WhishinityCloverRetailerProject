package com.trendbrew.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import com.trendbrew.entity.RetailerEntity;
import com.trendbrew.exception.TbCloverException;

@Stateless @LocalBean @TransactionAttribute(TransactionAttributeType.REQUIRED)
public class RetailerUserDAO extends GenericWishinityScraperDAO<RetailerEntity, Long> {
	
	/**
	 * @param retailerId
	 * @return
	 * @throws TbCloverException
	 */
	public Boolean isRetrailerExist(String retailerId) throws TbCloverException {
		
		Boolean retailerFlag = false;
		/*Query query = getEntityManager().createQuery("SELECT e from retailer e where sgid=");
	    List<RetailerEntity> list = query.getResultList();
		Boolean retailerFlag = false;
		Long sgid = 0L;
	    if(list != null && list.size() >0) {
	    	sgid = list.get(0).getSgid();
	    	retailerFlag = true;
	    }*/
		RetailerEntity r = getEntityManager().find(RetailerEntity.class, retailerId);
		if(r != null && r.getSgid() != null){
			retailerFlag = true;
		}
	    	
		return retailerFlag;
	}
	
	/**
	 * Creates new Retailer in the retailer table
	 * @param retailerEntity
	 * @throws TbCloverException
	 */
	public void createRetailer(RetailerEntity retailerEntity) throws TbCloverException {
			
		// Create new Retailer
		getEntityManager().getTransaction().begin();
		getEntityManager().persist(retailerEntity);
		getEntityManager().getTransaction().commit();

		getEntityManager().close();
	}


}
