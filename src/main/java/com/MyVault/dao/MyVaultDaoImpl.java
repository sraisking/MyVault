package com.MyVault.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import com.MyVault.pojo.Password;

@Repository
public class MyVaultDaoImpl implements MyVaultDao{
	@Autowired
	private SessionFactory sessionFactory;
	

	public void addPass(Password employee) {
		// TODO Auto-generated method stub
		
	}

	public List<Password> getAllPasswords() {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createQuery("from Password")
	                .list();
	}

	public void deletePassword(String site) {
		// TODO Auto-generated method stub
		
	}

	public Password updatePassword(Password password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Password getPassword(String site) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
