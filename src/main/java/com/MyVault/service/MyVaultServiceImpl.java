package com.MyVault.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MyVault.dao.MyVaultDao;
import com.MyVault.pojo.Password;

@Service("myVaultService")
public class MyVaultServiceImpl implements MyVaultService {
	@Autowired
	private MyVaultDao myVaultDao;

	public MyVaultDao getMyVaultDao() {
		return myVaultDao;
	}



	public void setMyVaultDao(MyVaultDao myVaultDao) {
		this.myVaultDao = myVaultDao;
	}



	@Transactional
	public void addPass(Password pass) {
		// TODO Auto-generated method stub
		myVaultDao.addPass(pass);
	}


	@Transactional
	public void deletePassword(int site) {
		myVaultDao.deletePassword(site);
	}

	public Password updatePassword(Password password) {
		// TODO Auto-generated method stub
		return myVaultDao.updatePassword(password);
	}

	@Transactional
	public Password getPassword(int site) {
		// TODO Auto-generated method stub
		return myVaultDao.getPassword(site);
	}



	@Transactional
	public List<Password> getAllPasswords() {
		// TODO Auto-generated method stub
		return myVaultDao.getAllPasswords();
	}
	

}
