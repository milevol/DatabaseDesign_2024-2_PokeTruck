package com.PokeTruck.Backend.Controller;

import com.PokeTruck.Backend.Entity.User;
import com.PokeTruck.Backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 생성
    @PostMapping("/create")
    public User createUser(@RequestParam String nickname, @RequestParam String password) {
        return userService.createUser(nickname, password);
    }

    // 사용자 소지금 조회
    @GetMapping("/{userId}/money")
    public Integer getUserMoney(@PathVariable Integer userId) {
        return userService.getUserMoney(userId);
    }

    // 사용자 소지금 업데이트
    @PutMapping("/{userId}/money")
    public User updateUserMoney(@PathVariable Integer userId, @RequestParam Integer amount) {
        return userService.updateUserMoney(userId, amount);
    }

    // 사용자 목록 조회
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return "사용자가 삭제되었습니다.";
    }
}
