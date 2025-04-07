package com.example.lab10_jobseekingsystem.Controller;

import com.example.lab10_jobseekingsystem.ApiResponse.ApiResponse;
import com.example.lab10_jobseekingsystem.Model.User;
import com.example.lab10_jobseekingsystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        if (userService.getAllUsers().isEmpty())
            return ResponseEntity.status(400).body(new ApiResponse("there are no users"));
        return ResponseEntity.status(200).body(userService.getAllUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean isAdded = userService.addUser(user);
        if (isAdded)
            return ResponseEntity.status(200).body(new ApiResponse("new user added"));
        return ResponseEntity.status(400).body(new ApiResponse("this email is already exist!"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors())
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        boolean isUpdated = userService.updateUser(id, user);
        if (isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("user is updated"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("user is deleted"));
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

}
