package com.feign.client.controller;

import com.feign.client.util.IUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1")
public class FeignController {

    @Autowired
    private IUtil util;

    @GetMapping(value = "/get-employee")
    public String getEmployee(){
        return util.getAllUsers();
    }
}
