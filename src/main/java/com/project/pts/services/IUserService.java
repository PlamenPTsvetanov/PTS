package com.project.pts.services;

import com.project.pts.views.in.UserInView;
import com.project.pts.views.out.UserOutView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<UserOutView> listAllUsers();

    UserOutView login(String email, String password);

    List<UserOutView> listAllFollowing(Long userId);

    List<UserOutView> listAllFollowers(Long userId);

    String followUser(Long thisId, Long userId);

    List<UserOutView> findUser(UserInView inView);
}
