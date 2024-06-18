package jagarcia.mobile_app_ws.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jagarcia.mobile_app_ws.dto.UserDto;
import jagarcia.mobile_app_ws.service.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private IUserService iUserService;

    //documentar endpoints
    @Operation(
            summary = "Create User REST API",
            description = "Create User Rest API is used to save user in database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )

    //build create user REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody  UserDto userDto) {
        UserDto savedUser = iUserService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User by ID Rest API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    //build get user by id
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = iUserService.getUserById(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users  Rest API is used to get all users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    //build get all users
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> usersDto = iUserService.getAllUsers();
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User  Rest API is used to update a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //Build Update User
    // http://localhost:8080/api/users
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                              @RequestBody @Valid UserDto userDto) {
        userDto.setId(userId);
        UserDto updatedUser = iUserService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User  Rest API is used to DELETE a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )

    //Build Delete User
    // http://localhost:8080/api/users/2
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
        iUserService.deleteUser(userId);
        return new ResponseEntity<>("User succesfully deleted!", HttpStatus.OK);
    }

    /*excepcion en el controlador
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
