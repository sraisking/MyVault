package com.MyVault.controller;

import static com.MyVault.common.VaultConstants.NO_PASSWORDS;
import static com.MyVault.common.VaultConstants.SUCCESS;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MyVault.model.GenericRequestVO;
import com.MyVault.model.GenericResponseVO;
import com.MyVault.model.GetPasswordResponseVO;
import com.MyVault.model.Password;
import com.MyVault.model.UpdatePasswordResponseVO;
import com.MyVault.service.MyVaultService;

@RestController
public class MyVaultRestController {
	private static final Logger logger = Logger.getLogger(MyVaultRestController.class);

	public MyVaultRestController() {
		System.out.println("Inside Password Controller");
	}

	@Autowired
	private MyVaultService myVaultService;

	@RequestMapping(value = "/pass/delete", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenericResponseVO> deletePassword(@RequestBody GenericRequestVO site) {
		System.out.println("Deleting site ");

		GenericResponseVO response = new GenericResponseVO();
		response.setMessage(SUCCESS);
		myVaultService.deletePassword(site.getId());

		return new ResponseEntity<GenericResponseVO>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/passByName", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetPasswordResponseVO> getPasswordBySiteName(@RequestBody GenericRequestVO site) {
		System.out.println("Fetching Password with site " + site.getSite());
		List<Password> pass = myVaultService.getPasswordBySiteName(site.getSite());
		GetPasswordResponseVO response = new GetPasswordResponseVO();
		response.setMessage(SUCCESS);
		if (pass.isEmpty()) {
			response.setMessage(NO_PASSWORDS);
			return new ResponseEntity<GetPasswordResponseVO>(response, NOT_FOUND);
		}
		response.setSites(pass);
		return new ResponseEntity<GetPasswordResponseVO>(response, OK);
	}

	@RequestMapping(value = "/pass/update", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UpdatePasswordResponseVO> updatePassword(@RequestBody GenericRequestVO pass) {
		System.out.println("Updating site " + pass.getSite());
		Password password = myVaultService.updatePassword(pass);
		UpdatePasswordResponseVO response = new UpdatePasswordResponseVO();
		response.setMessage(SUCCESS);
		response.setSite(password);
		return new ResponseEntity<UpdatePasswordResponseVO>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/pass", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetPasswordResponseVO> getAllPasswords() {
		List<Password> users = myVaultService.getAllPasswords();
		GetPasswordResponseVO response = new GetPasswordResponseVO();
		response.setMessage(SUCCESS);
		if (users.isEmpty()) {
			response.setMessage(NO_PASSWORDS);
			return new ResponseEntity<GetPasswordResponseVO>(response, NOT_FOUND);
		}
		response.setSites(users);
		return new ResponseEntity<GetPasswordResponseVO>(response, OK);
	}

	@RequestMapping(value = "/pass", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GetPasswordResponseVO> getPassword(@RequestBody GenericRequestVO site) {

		System.out.println("Fetching Password with site " + site);
		Password pass = myVaultService.getPassword(site.getId());
		GetPasswordResponseVO response = new GetPasswordResponseVO();
		response.setMessage(SUCCESS);
		if (pass == null) {
			System.out.println("Password for Site " + site + " not found");
			response.setMessage(NO_PASSWORDS);
			return new ResponseEntity<GetPasswordResponseVO>(NOT_FOUND);
		}
		response.getSites().add(pass);
		return new ResponseEntity<GetPasswordResponseVO>(response, OK);
	}

	@RequestMapping(value = "/pass/newSite", method = RequestMethod.POST)
	public ResponseEntity<Void> addPass(@RequestBody GenericRequestVO pass, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating site " + pass.getSite());

		myVaultService.addPass(pass);
		return new ResponseEntity<Void>(CREATED);
	}

}
