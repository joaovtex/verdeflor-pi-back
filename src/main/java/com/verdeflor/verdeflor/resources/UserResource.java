package com.verdeflor.verdeflor.resources;

import com.verdeflor.verdeflor.dtos.LoginDTO;
import com.verdeflor.verdeflor.entities.User;
import com.verdeflor.verdeflor.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping(value = "/usuario")

public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginDTO loginDTO) {
        boolean authenticated = userService.authenticate(loginDTO.getEmail(), loginDTO.getSenha());
        return ResponseEntity.ok().body(authenticated);
    }
}
