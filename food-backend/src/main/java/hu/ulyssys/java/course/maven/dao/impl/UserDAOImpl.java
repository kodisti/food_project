package hu.ulyssys.java.course.maven.dao.impl;

import hu.ulyssys.java.course.maven.dao.UserDAO;
import hu.ulyssys.java.course.maven.entity.User;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class UserDAOImpl extends AbstractCoreDAOImpl<User> implements UserDAO {

    @Override
    public User findByUsername(String username) {
        List<User> userList = entityManager.createQuery("select u from User u where u.username=:username", User.class).setParameter("username", username).getResultList();
        if (userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }

    @Override
    protected Class<User> getManagedClass() {
        return User.class;
    }
}
