package com.MyVault.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MyVault.dao.MyVaultDao;
import com.MyVault.pojo.Password;

@Service
public class MyVaultServiceImpl implements MyVaultService {
	@Autowired
	private MyVaultDao myVaultDao;

	public void addPass(Password employee) {
		// TODO Auto-generated method stub
		
	}



	public void deletePassword(String employeeId) {
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



	@Transactional
	public List<Password> getAllPasswords() {
		// TODO Auto-generated method stub
		return myVaultDao.getAllPasswords();
	}
	

}
