package com.MyVault.dao;

import java.util.List;

import com.MyVault.pojo.Password;

public interface MyVaultDao {
	public void addPass(Password employee);
	 
    public List<Password> getAllPasswords();
 
    public void deletePassword(String site);
 
    public Password updatePassword(Password password);
 
    public Password getPassword(String site);

}
