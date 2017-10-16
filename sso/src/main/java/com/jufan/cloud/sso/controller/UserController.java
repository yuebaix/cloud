package com.jufan.cloud.sso.controller;

import com.jufan.cloud.sso.domain.SysUser;
import com.jufan.cloud.sso.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private SysUserRepository sysUserRepository;
    @GetMapping("/user")
    public Principal user(Principal user){
        return user;
    }
    //fortest
    @GetMapping("/detail")
    public SysUser getUserDetails(){
        SysUser sysUser = sysUserRepository.findOne(1l);
        return sysUser;
    }
}
