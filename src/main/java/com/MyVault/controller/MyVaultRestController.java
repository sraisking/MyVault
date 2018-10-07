package com.MyVault.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    
    @RequestMapping(value = "/pass/", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Password>> getAllPasswords() {
        List<Password> users = myVaultService.getAllPasswords();
        if(users.isEmpty()){
            return new ResponseEntity<List<Password>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Password>>(users, HttpStatus.OK);
    }

}
