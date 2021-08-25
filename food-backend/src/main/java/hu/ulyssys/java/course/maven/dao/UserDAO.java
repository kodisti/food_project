package hu.ulyssys.java.course.maven.dao;

import hu.ulyssys.java.course.maven.entity.User;

public interface UserDAO extends CoreDAO<User>{

    User findByUsername(String username);
}
