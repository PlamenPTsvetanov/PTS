package com.project.pts.controller;

import com.project.pts.services.IUserService;
import com.project.pts.views.out.UserOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("UserController")
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private IUserService userService;

    private UserOutView loggedInUser;

    @RequestMapping(path = "login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("password") String password){
        loggedInUser = userService.login(email, password);
        if (loggedInUser == null){
            return ResponseEntity.badRequest().body("Login unsuccessful!");
        }

        return ResponseEntity.ok().body("Login successful!");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll(){
        List<UserOutView> userOutViews = userService.listAllUsers();

        if (userOutViews == null){
            return new ResponseEntity<>("No users!", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(userOutViews);
    }


    @RequestMapping(path ="/followers", method = RequestMethod.GET)
    public ResponseEntity<Object> getFollowers(){
        if (loggedInUser == null){
            return new ResponseEntity<>("Must log in to see followers", HttpStatus.BAD_REQUEST);
        }

        List<UserOutView> userOutViews = userService.listAllFollowers(loggedInUser.getId());

        if (userOutViews == null){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(userOutViews);
    }
}
