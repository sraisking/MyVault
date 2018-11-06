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
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPass(Password pass) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(pass);
		
	}

	public List<Password> getAllPasswords() {
		// TODO Auto-generated method stub
		 return sessionFactory.getCurrentSession().createQuery("from Password")
	                .list();
	}

	public void deletePassword(int site) {
		Password password = (Password) sessionFactory.getCurrentSession().load(
				Password.class, site);
        if (null != password) {
            this.sessionFactory.getCurrentSession().delete(password);
        }		
	}

	public Password updatePassword(Password password) {
		 sessionFactory.getCurrentSession().update(password);	
		 return password;
	}

	public Password getPassword(int site) {
		// TODO Auto-generated method stub
		return (Password) sessionFactory.getCurrentSession().get(Password.class, site);
	}
	
	

}
