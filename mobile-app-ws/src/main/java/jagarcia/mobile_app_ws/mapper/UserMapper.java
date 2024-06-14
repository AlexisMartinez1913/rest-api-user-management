package jagarcia.mobile_app_ws.mapper;

import jagarcia.mobile_app_ws.dto.UserDto;
import jagarcia.mobile_app_ws.entity.User;

public class UserMapper {
    //Convert User JPA Entity into UserDto
    public static UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
        return userDto;
    }
   //Convert UserDto JPA Entity into User
    public static User mapToUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
        return user;
    }
}
