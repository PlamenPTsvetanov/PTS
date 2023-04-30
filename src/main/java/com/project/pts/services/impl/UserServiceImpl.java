package com.project.pts.services.impl;

import com.project.pts.entities.FollowerEntity;
import com.project.pts.entities.UserEntity;
import com.project.pts.repositories.IFollowerRepository;
import com.project.pts.repositories.IUserRepository;
import com.project.pts.services.IUserService;
import com.project.pts.views.in.UserInView;
import com.project.pts.views.out.UserOutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IFollowerRepository followerRepository;

    @Override
    public List<UserOutView> listAllUsers() {
        return map(userRepository.getAll());
    }

    @Override
    public List<UserOutView> listAllFollowing(Long userId) {
        return map(userRepository.getAllFollowing(userId));
    }

    @Override
    public List<UserOutView> listAllFollowers(Long userId) {
        return map(userRepository.getAllFollowers(userId));
    }

    @Override
    public String followUser(Long userId, Long followId) {
        UserEntity referenceById = userRepository.getReferenceById(followId);
        if (followerRepository.getByUserIdAndFollowerId(userId, followId) != null){
            return String.format("You already follow %s!", referenceById.getUsername());
        }

        FollowerEntity entity = new FollowerEntity();
        entity.setUserId(userId);
        entity.setFollowerId(followId);

        followerRepository.save(entity);
        return String.format("You followed %s!", referenceById.getUsername());
    }

    @Override
    public List<UserOutView> findUser(UserInView inView) {
        List<UserEntity> byParams = userRepository.getUserByParams(inView.getUsername(),
                inView.getFirstName(),
                inView.getLastName(),
                inView.getEmailAddress());
        return map(byParams);
    }

    private List<UserOutView> map(List<UserEntity> all){
        return all
                .stream()
                .map(u -> new UserOutView(u.getInsertedAt(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getUsername(),
                        u.getEmailAddress()))
                .collect(Collectors.toList());
    }
}
