package com.project.pts.controller;

import com.project.pts.services.IUserService;
import com.project.pts.views.out.UserOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("UserController")
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserOutView>> getAll(){
        List<UserOutView> userOutViews = userService.listAllUsers();

        if (userOutViews == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(userOutViews);
    }
}
