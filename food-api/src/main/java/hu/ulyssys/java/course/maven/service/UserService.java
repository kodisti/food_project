package hu.ulyssys.java.course.maven.service;

import hu.ulyssys.java.course.maven.entity.User;

public interface UserService extends CoreService<User> {
    User findByUsername(String username);
}
