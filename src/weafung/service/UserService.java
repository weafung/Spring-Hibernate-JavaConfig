package weafung.service;

import weafung.dto.UserLoginDTO;
import weafung.dto.UserRegisterDTO;
import weafung.model.User;

import java.io.Serializable;

public interface UserService {
    Serializable save(UserRegisterDTO user);
    User login(UserLoginDTO user);

}
