package com.MyVault.service;

import java.util.List;

import com.MyVault.pojo.Password;

public interface MyVaultService {
	public void addPass(Password employee);
	 
    public List<Password> getAllPasswords();
 
    public void deletePassword(int site);
 
    public Password updatePassword(Password password);
 
    public Password getPassword(int site);


}
