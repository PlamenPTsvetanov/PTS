package com.project.pts.controller;

import com.project.pts.services.ITaskService;
import com.project.pts.services.IUserService;
import com.project.pts.views.in.UserInView;
import com.project.pts.views.out.TaskOutView;
import com.project.pts.views.out.UserOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController("UserController")
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ITaskService taskService;
    private static UserOutView loggedInUser;

    @RequestMapping(path = "login", method = RequestMethod.GET)
    public ResponseEntity<String> login(@RequestParam("email") String email,
                                        @RequestParam("password") String password) {
        loggedInUser = userService.login(email, password);
        if (loggedInUser == null) {
            return ResponseEntity.badRequest().body("Login unsuccessful!");
        }

        return ResponseEntity.ok().body("Login successful!");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAll() {
        List<UserOutView> userOutViews = userService.listAllUsers();
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to see users!", HttpStatus.BAD_REQUEST);
        }
        if (userOutViews == null) {
            return new ResponseEntity<>("No users!", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok().body(userOutViews);
    }


    @RequestMapping(path = "/followers", method = RequestMethod.GET)
    public ResponseEntity<Object> getFollowers() {
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to see followers!", HttpStatus.BAD_REQUEST);
        }

        List<UserOutView> userOutViews = userService.listAllFollowers(loggedInUser.getId());

        if (userOutViews == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(userOutViews);
    }

    @RequestMapping(path = "/following", method = RequestMethod.GET)
    public ResponseEntity<Object> getFollowing() {
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to see following!", HttpStatus.BAD_REQUEST);
        }

        List<UserOutView> userOutViews = userService.listAllFollowing(loggedInUser.getId());

        if (userOutViews == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(userOutViews);
    }

    @RequestMapping(path = "/follow", method = RequestMethod.POST)
    public ResponseEntity<Object> followUser(@RequestParam("userId") Long userId) {
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to follow!", HttpStatus.BAD_REQUEST);
        }

        String message = userService.followUser(loggedInUser.getId(), userId);

        return ResponseEntity.ok().body(message);
    }


    @RequestMapping(path = "/feed", method = RequestMethod.GET)
    public ResponseEntity<Object> feed() {
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to see feed!", HttpStatus.BAD_REQUEST);
        }

        List<UserOutView> userOutViews = userService.listAllFollowing(loggedInUser.getId());
        List<TaskOutView> taskOutViews = new ArrayList<>();
        for (UserOutView userOutView : userOutViews) {
            taskOutViews.addAll(taskService.getNewestActivityByUser(userOutView.getId()));
        }
        taskOutViews.sort((f,s)-> s.getStart().compareTo(f.getStart()));
        return ResponseEntity.ok().body(taskOutViews);
    }

    @RequestMapping(path = "/find", method = RequestMethod.GET)
    public ResponseEntity<Object> find(@RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "lastName", required = false) String lastName,
                                       @RequestParam(value = "username", required = false) String username,
                                       @RequestParam(value = "email", required = false) String email) {
        if (loggedInUser == null) {
            return new ResponseEntity<>("Must log in to search for user!", HttpStatus.BAD_REQUEST);
        }
        UserInView inView = new UserInView(firstName, lastName, username, email);

        return ResponseEntity.ok().body(userService.findUser(inView));
    }

    public static Long getLoggedId() {
        return loggedInUser == null ? null : loggedInUser.getId();
    }
}
