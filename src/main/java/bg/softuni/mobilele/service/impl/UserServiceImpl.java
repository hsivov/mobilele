package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.UserLoginDTO;
import bg.softuni.mobilele.model.entity.User;
import bg.softuni.mobilele.model.UserRegisterDTO;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        User user = modelMapper.map(userRegisterDTO,User.class);

        userRepository.save(user);
    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {

    }
}
