package com.fenast.ibextube.controller;

import com.fenast.ibextube.model.User;
import com.fenast.ibextube.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UserDetailController {

/*    @Autowired
    private UserDetailsServiceImpl userDetailsService;*/

    @RequestMapping(value = "/authenticate", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String userDetails() {
/*        User user = (User) userDetailsService.loadUserByUsername("john");
        return user.getUsername();*/
return null;
    }
}
