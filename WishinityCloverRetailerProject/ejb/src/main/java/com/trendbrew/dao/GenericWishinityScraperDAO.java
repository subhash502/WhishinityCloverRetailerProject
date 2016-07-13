package com.trendbrew.dao;

import com.koinplus.common.data.AbstractKoinPlusDAO;
import com.koinplus.common.data.GenericKoinPlusDataEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author Abhijit Patil
 */

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GenericWishinityScraperDAO<T extends GenericKoinPlusDataEntity, ID extends Serializable> extends AbstractKoinPlusDAO<T, ID> {

	@PersistenceContext(unitName = "wishinityPersistence")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
