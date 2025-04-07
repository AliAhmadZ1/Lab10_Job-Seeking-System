package com.example.lab10_jobseekingsystem.Service;

import com.example.lab10_jobseekingsystem.ApiResponse.ApiResponse;
import com.example.lab10_jobseekingsystem.Model.User;
import com.example.lab10_jobseekingsystem.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Boolean addUser(User user){
        try{
            for (User u: getAllUsers()){
                if (u.getEmail().equals(user.getEmail()))
                    throw new Exception();
            }
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean updateUser(Integer id,User user){
        for (User u:getAllUsers()) {
//            User oldUser = userRepository.getById(id);
//
//            if (oldUser == null)
//                return false;
            if (u.getId()==id) {
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                u.setPassword(user.getPassword());
                u.setAge(user.getAge());
                u.setRole(user.getRole());
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteUser(Integer id){
        for (User u:getAllUsers()) {
//            User user = userRepository.getById(id);
//
//            if (user == null)
//                return false;
            if (u.getId()==id) {
                userRepository.delete(u);
                return true;
            }
        }
        return false;
    }

}
