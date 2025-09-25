package com.ashar.profileManager.service;

import com.ashar.profileManager.entity.User;
import com.ashar.profileManager.exception.ResourceAlreadyExists;
import com.ashar.profileManager.exception.ResourceNotFoundException;
import com.ashar.profileManager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final Response response;
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository,Response response){
        this.userRepository = userRepository;
        this.response = response;
    }

    public ResponseEntity<Response<User>> addUser(User user) throws ResourceAlreadyExists{

        Optional<User> u = userRepository.findById(user.getId());
        if(u.isPresent()) throw new ResourceAlreadyExists("user already exists for id : "+user.getId());

        User savedUser = userRepository.save(user);
        log.info("user created in database : {}",savedUser);
        response.setResponse("created");
        response.setMessage("user created successfully");
        response.setObject(savedUser);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<Response<List<User>>> getAllUsers(){
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) throw new ResourceNotFoundException("No users in database");

        log.info("fetched all users from database");
        response.setResponse("fetched");
        response.setMessage("All users fetched successfully");
        response.setObject(users);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Response<User>> getUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new ResourceNotFoundException("user not found for id : "+id);

        log.info("user fetched from database : {}",user.get());
        response.setResponse("fetched");
        response.setMessage("user fetched successfully");
        response.setObject(user.get());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Response<User>> getUserByName(String name) {
        Optional<User> user = userRepository.findByName(name);
        if(user.isEmpty()) throw new ResourceNotFoundException("user not found for username : "+name);

        log.info("user fetched from database : {}",user.get());
        response.setResponse("fetched");
        response.setMessage("user fetched successfully");
        response.setObject(user.get());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Response<User>> updateUserById(int id, User newUser){
        Optional<User> u = userRepository.findById(id);
        if(u.isEmpty()) throw new ResourceNotFoundException("user not found for id : "+id);
        User oldUser = u.get();

        if(newUser.getName() != null && !newUser.getName().isEmpty() && !newUser.getName().equals(oldUser.getName())){
            oldUser.setName(newUser.getName());
        }
        if(newUser.getDateOfBirth() != null && !newUser.getDateOfBirth().equals(oldUser.getDateOfBirth())){
            oldUser.setDateOfBirth(newUser.getDateOfBirth());
        }
        if(newUser.getAddress() != null && !newUser.getAddress().isEmpty() && !newUser.getAddress().equals(oldUser.getAddress())){
            oldUser.setAddress(newUser.getAddress());
        }

        User savedUser = userRepository.save(oldUser);
        log.info("User updated in database : {}",oldUser);
        response.setResponse("updated");
        response.setMessage("user updated successfully");
        response.setObject(oldUser);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Response<User>> deleteUserById(int id){
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new ResourceNotFoundException("user not found for id : "+id);

        userRepository.deleteById(id);
        log.info("user deleted from database : {}",user.get());
        response.setResponse("deleted");
        response.setMessage("user deleted successfully");
        response.setObject(user.get());

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    public ResponseEntity<Response<List<User>>> addAllUsers(List<User> users)
    {
        List<User> saved = userRepository.saveAll(users);
        response.setResponse("created");
        response.setMessage("all users created successfully");
        response.setObject(saved);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }



}
