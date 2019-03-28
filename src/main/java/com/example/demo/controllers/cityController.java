/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controllers;
import com.example.demo.Services.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author 2112076
 */
@RestController
@RequestMapping("/city")
public class cityController {
    @Autowired
    HttpConnection con;
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,path = "/{city}")
    public ResponseEntity<?> getCity(@PathVariable String city){
        try{
            return new ResponseEntity<>(con.getInfo(city), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
