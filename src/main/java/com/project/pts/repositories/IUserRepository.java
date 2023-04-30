package com.project.pts.repositories;

import com.project.pts.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    @Query("SELECT u FROM UserEntity u where u.emailAddress = :emailAddress and u.password = :password")
    UserEntity login(@Param("emailAddress") String emailAddress,
                     @Param("password") String password);

    @Query("select u from UserEntity u")
    List<UserEntity> getAll();

    @Query("SELECT following " +
            "FROM UserEntity main " +
            "JOIN FollowerEntity f ON main.id = f.followerId " +
            "JOIN UserEntity following ON f.userId = following.id " +
            "WHERE main.id = :id")
    List<UserEntity> getAllFollowing(@Param("id") Long id);

    @Query("SELECT followers " +
            "FROM UserEntity main " +
            "JOIN FollowerEntity f ON main.id = f.userId " +
            "JOIN UserEntity followers ON f.followerId = followers.id " +
            "WHERE main.id = :id")
    List<UserEntity> getAllFollowers(@Param("id") Long id);

    @Query("select u from UserEntity u " +
            "where u.username = coalesce(:username, u.username)" +
            "and u.firstName = coalesce(:firstName, u.firstName) " +
            "and u.lastName = coalesce(:lastName, u.lastName) " +
            "and u.emailAddress = coalesce(:emailAddress, u.emailAddress) ")
    List<UserEntity> getUserByParams(@Param("username") String username,
                               @Param("firstName") String firstName,
                               @Param("lastName") String lastName,
                               @Param("emailAddress") String emailAddress);
}
