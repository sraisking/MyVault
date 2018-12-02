package com.MyVault.model;

public class UpdatePasswordResponseVO extends GenericResponseVO {
	private Password site;

	public Password getSite() {
		return site;
	}

	public void setSite(Password site) {
		this.site = site;
	}

}
