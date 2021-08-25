package hu.ulyssys.java.course.maven.service.impl;

import hu.ulyssys.java.course.maven.dao.UserDAO;
import hu.ulyssys.java.course.maven.entity.User;
import hu.ulyssys.java.course.maven.service.UserService;

import javax.ejb.Stateless;

@Stateless
public class UserServiceImpl extends AbstractCoreServiceImpl<User> implements UserService {
    @Override
    public User findByUsername(String username) {
        return ((UserDAO) dao).findByUsername(username);
    }
}
