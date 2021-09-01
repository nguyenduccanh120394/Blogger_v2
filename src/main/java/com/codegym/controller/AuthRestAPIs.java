package com.codegym.controller;

import com.codegym.message.request.SignInForm;
import com.codegym.message.request.SignUpForm;
import com.codegym.message.response.JwtResponse;
import com.codegym.message.response.ResponseMessage;
import com.codegym.model.Role;
import com.codegym.model.RoleName;
import com.codegym.security.jwt.JwtProvider;
import com.codegym.security.userprinciple.UserPrinciple;
import com.codegym.service.iplm.RoleServiceIplm;
import com.codegym.service.iplm.UserServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import com.codegym.model.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {
    @Autowired
    UserServiceIplm userService;
    @Autowired
    RoleServiceIplm roleService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("No User"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("No Email"), HttpStatus.BAD_REQUEST);
        }
        User user = new User(
                signUpForm.getUsername(),
                signUpForm.getFullname(),
                passwordEncoder.encode(signUpForm.getPassword()),
                signUpForm.getEmail(),
                signUpForm.getPhone(),
                signUpForm.getAddress()
        );


        Set<Role> roles = new HashSet<>();

        Role roleUser = new Role();
        roleUser.setId(1L);
        roleUser.setName(RoleName.USER);
        roles.add(roleUser);
        user.setRoles(roles);
        user.setAvatar();
        userService.save(user);
        return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        System.out.println(userPrinciple.getAuthorities());
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()));

    }

}
