package weafung.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weafung.model.User;

import java.io.Serializable;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String SELECT_USER_BY_USERNAME = "FROM User AS user WHERE user.username = ?";
    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "FROM User AS user WHERE user.username = :username AND user.password = :password";

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Serializable save(User user) {
        return currentSession().save(user);
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void count(User user) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return (User) currentSession().createQuery(SELECT_USER_BY_USERNAME).setParameter(0, username).uniqueResult();

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = (User) currentSession().createQuery(SELECT_USER_BY_USERNAME_AND_PASSWORD)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();
        return user;
    }
}
