package jagarcia.mobile_app_ws.service;

import jagarcia.mobile_app_ws.dto.UserDto;


import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto user);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(UserDto user);
    void deleteUser(Long userId);

}
