package jagarcia.mobile_app_ws.controller;

import jagarcia.mobile_app_ws.Exception.ErrorDetails;
import jagarcia.mobile_app_ws.Exception.ResourceNotFoundException;
import jagarcia.mobile_app_ws.dto.UserDto;
import jagarcia.mobile_app_ws.entity.User;
import jagarcia.mobile_app_ws.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private IUserService iUserService;

    //build create user REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody  UserDto userDto) {
        UserDto savedUser = iUserService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    //build get user by id
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = iUserService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }
    //build get all users
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersDto = iUserService.getAllUsers();
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    //Build Update User
    // http://localhost:8080/api/users
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        userDto.setId(userId);
        UserDto updatedUser = iUserService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Build Delete User
    // http://localhost:8080/api/users/2
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        iUserService.deleteUser(userId);
        return new ResponseEntity<>("User succesfully deleted!", HttpStatus.OK);
    }

    /*excepcion
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                        WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    */
}
