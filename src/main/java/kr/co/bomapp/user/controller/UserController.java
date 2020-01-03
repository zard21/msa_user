package kr.co.bomapp.user.controller;

import kr.co.bomapp.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUserInfo(id));
    }
}
