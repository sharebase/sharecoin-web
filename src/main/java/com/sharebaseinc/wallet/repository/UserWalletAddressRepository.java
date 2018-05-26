package com.sharebaseinc.wallet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sharebaseinc.wallet.repository.entity.UserWalletAddressEntity;

@Repository
@Transactional
public class UserWalletAddressRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<UserWalletAddressEntity> find(String userId) {
		
		
		String sqlString ="select * from industryMiddle order by sicCode";
	
		Query query = entityManager.createNativeQuery("select * from userWalletAddressEntity where userId = ?",UserWalletAddressEntity.class);

		query.setParameter(1, userId);
		@SuppressWarnings("unchecked")
		List<UserWalletAddressEntity> list = query.getResultList();
	
	
		return list;
	}
	

}
