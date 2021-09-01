package com.fundamenosplatzi.springboot.fundamentos.Service;

import com.fundamenosplatzi.springboot.fundamentos.Repository.UserRepository;
import com.fundamenosplatzi.springboot.fundamentos.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTransactional(List<User> users){
        users.stream()
                .peek(user -> LOG.info("Usuario Insertado" + user))
                .forEach(user -> userRepository.save(user));

    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
