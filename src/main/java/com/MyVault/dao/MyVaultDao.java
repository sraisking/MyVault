package com.MyVault.dao;

import java.util.List;

import com.MyVault.pojo.Password;

public interface MyVaultDao {
	public void addPass(Password pass);
	 
    public List<Password> getAllPasswords();
 
    public void deletePassword(int site);
 
    public Password updatePassword(Password password);
 
    public Password getPassword(int site);

}
