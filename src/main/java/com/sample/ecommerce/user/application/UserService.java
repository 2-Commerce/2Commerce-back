package com.sample.ecommerce.user.application;

import com.sample.ecommerce.user.domain.User;
import com.sample.ecommerce.user.domain.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;

    public User getUser(String userId){
        return userRepository.findByUserId(userId).orElseThrow();
    }
}
