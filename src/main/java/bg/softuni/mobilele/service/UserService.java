package bg.softuni.mobilele.service;

import bg.softuni.mobilele.model.UserLoginDTO;
import bg.softuni.mobilele.model.UserRegisterDTO;

public interface UserService {
    void registerUser(UserRegisterDTO userRegisterDTO);

    void login(UserLoginDTO userLoginDTO);
}
