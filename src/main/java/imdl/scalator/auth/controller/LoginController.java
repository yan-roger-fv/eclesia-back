package imdl.scalator.auth.controller;

import imdl.scalator.auth.configuration.AuthManager;
import imdl.scalator.auth.configuration.JwtUtil;
import imdl.scalator.auth.controller.input.LoginRequest;
import imdl.scalator.auth.controller.output.LoginOutput;
import imdl.scalator.auth.dto.UserDTO;
import imdl.scalator.auth.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/auth")
@Tag(name = "v1/Login", description = "Login de usuário")
public class LoginController {

    private final AuthManager authenticationManager;
    private final UserService userService;

    public LoginController(AuthManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginOutput login(@RequestBody LoginRequest loginRequest){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        UserDTO user = userService.findByUsername(loginRequest.getUsername());

        return new LoginOutput(JwtUtil.generateToken(loginRequest.getUsername()), user.getUsername(), user.getRole().getRole()
//                SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().toList().get(0).getAuthority()
        );
    }
}
