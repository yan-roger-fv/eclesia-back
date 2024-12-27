package imdl.scalator.auth.configuration;

import imdl.scalator.auth.dto.RoleDTO;
import imdl.scalator.auth.dto.UserDTO;
import imdl.scalator.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;

public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDTO(UUID.randomUUID(), new RoleDTO(UUID.randomUUID(), "ADMIN"), "noita", "noita", null);
//        return UserDTO.toDTO(userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}