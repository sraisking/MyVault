package com.MyVault.model;

import java.util.ArrayList;
import java.util.List;

public class GetPasswordResponseVO extends GenericResponseVO {
	private List<Password> sites;

	public List<Password> getSites() {
		if (sites == null) {
			sites = new ArrayList<Password>();
		}
		return sites;
	}

	public void setSites(List<Password> sites) {
		this.sites = sites;
	}
}
