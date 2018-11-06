package com.MyVault.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.MyVault.pojo.Password;
import com.MyVault.service.MyVaultService;

@RestController
public class MyVaultRestController {
    private static final Logger logger = Logger
            .getLogger(MyVaultRestController.class);
 
    public MyVaultRestController() {
        System.out.println("Inside Password Controller");
    }
    
    @Autowired
    private MyVaultService myVaultService;
    @RequestMapping(value = "/pass/delete/{site}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePassword(@PathVariable("site") int site) {
System.out.println("Deleting site ");
 
        
        myVaultService.deletePassword(site);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pass/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Password>> getAllPasswords() {
        List<Password> users = myVaultService.getAllPasswords();
        if(users.isEmpty()){
            return new ResponseEntity<List<Password>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Password>>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/pass/{site}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Password> getPassword(@PathVariable("site") int site) {
        System.out.println("Fetching Password with site " + site);
        Password pass = myVaultService.getPassword(site);
        if (pass == null) {
            System.out.println("PAssword for Site " + site + " not found");
            return new ResponseEntity<Password>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Password>(pass, HttpStatus.OK);
    }
    @RequestMapping(value = "/pass/newSite", method = RequestMethod.POST)
    public ResponseEntity<Void> addPass(@RequestBody Password pass,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating site " + pass.getSite());
 
        
        myVaultService.addPass(pass);
 
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    @RequestMapping(value = "/pass/update", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Password> updatePassword(@RequestBody Password pass) {
    	 System.out.println("Updating site " + pass.getSite());
        Password password = myVaultService.updatePassword(pass);
        if (pass == null) {
            System.out.println("PAssword for Site " + pass.getSite() + " not found");
            return new ResponseEntity<Password>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Password>(pass, HttpStatus.OK);
    }
 
 

}
