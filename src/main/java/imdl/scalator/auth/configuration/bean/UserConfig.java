package imdl.scalator.auth.configuration.bean;

import imdl.scalator.auth.repository.RoleRepository;
import imdl.scalator.auth.repository.UserRepository;
import imdl.scalator.auth.service.UserService;
import imdl.scalator.service.LevitaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UserService userService(LevitaService levitaService, UserRepository userRepository, RoleRepository roleRepository){
        return new UserService(levitaService, userRepository, roleRepository);
    }
}
