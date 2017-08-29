package weafung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weafung.dao.UserDAO;
import weafung.dto.UserLoginDTO;
import weafung.dto.UserRegisterDTO;
import weafung.exception.UserLoginException;
import weafung.exception.UserRegisterException;
import weafung.model.User;

import java.io.Serializable;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Serializable save(UserRegisterDTO userRegisterDTO) {
        if (userRegisterDTO.getUsername() == null || userRegisterDTO.getPassword() == null || userRegisterDTO.getPasswordAgain() == null){
            throw new UserRegisterException("Invaild data");
        } else if (userRegisterDTO.getUsername().equals("")) {
           throw new UserRegisterException("The username field is required.");
        } else if (userRegisterDTO.getPassword().equals("") || userRegisterDTO.getPasswordAgain().equals("") ) {
            throw new UserRegisterException("The password field is required.");
        } else if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getPasswordAgain())) {
            throw new UserRegisterException("The password field is incorrect.");
        }
        if (userDAO.findByUsername(userRegisterDTO.getUsername()) != null) {
            throw new UserRegisterException("Username has occupied.");
        }
        try {
            return userDAO.save(new User(userRegisterDTO.getUsername(), userRegisterDTO.getPassword()));
        } catch (Exception e) {
            throw new UserRegisterException(e.getMessage());
        }
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        if (userLoginDTO.getUsername() == null || userLoginDTO.getPassword() == null ){
            throw new UserRegisterException("Invaild data");
        }
        User user = userDAO.findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (user == null) {
            throw new UserLoginException("Username or password is incorrect.");
        }
        return user;
    }
}
