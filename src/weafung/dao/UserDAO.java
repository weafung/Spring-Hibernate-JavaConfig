package weafung.dao;

import weafung.model.User;

import java.io.Serializable;

public interface UserDAO {
    Serializable save(User user);
    void remove(User user);
    void update(User user);
    void count(User user);
    User findById(Integer id);
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

}
