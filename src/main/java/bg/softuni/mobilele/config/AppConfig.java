package bg.softuni.mobilele.config;

import bg.softuni.mobilele.model.User;
import bg.softuni.mobilele.model.UserRegisterDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        Converter<String, String> passwordConverter = context -> passwordEncoder().encode(context.getSource());

        modelMapper
                .typeMap(UserRegisterDTO.class, User.class)
                .addMappings(mapping -> mapping.using(passwordConverter)
                        .map(UserRegisterDTO::getPassword, User::setPassword));

        return modelMapper;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
