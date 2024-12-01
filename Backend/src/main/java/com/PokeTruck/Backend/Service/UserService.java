package com.PokeTruck.Backend.Service;

import com.PokeTruck.Backend.Entity.User;
import com.PokeTruck.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 사용자 생성
    public User createUser(String nickname, String password) {
        User newUser = User.builder()
                .nickname(nickname)
                .password(password)
                .money(0) // 초기 소지금 0
                .dayCount(1) // 초기 운영일 1
                .build();
        return userRepository.save(newUser);
    }

    // 사용자 소지금 조회
    public Integer getUserMoney(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        return user.getMoney();
    }

    // 사용자 소지금 업데이트
    public User updateUserMoney(Integer userId, Integer amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        user.setMoney(user.getMoney() + amount);
        return userRepository.save(user);
    }

    // 사용자 목록 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 사용자 삭제
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
