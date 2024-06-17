package jagarcia.mobile_app_ws.service.impl;

import jagarcia.mobile_app_ws.exception.EmailAlreadyExistsException;
import jagarcia.mobile_app_ws.exception.ResourceNotFoundException;
import jagarcia.mobile_app_ws.dto.UserDto;
import jagarcia.mobile_app_ws.entity.User;
import jagarcia.mobile_app_ws.mapper.AutoUserMapper;
import jagarcia.mobile_app_ws.repository.IUserRepository;
import jagarcia.mobile_app_ws.service.IUserService;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {


    private IUserRepository iUserRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        //convert UserDto into User JPA entity using static methods
        //User user = UserMapper.mapToUser(userDto);

        //usando dependencia ModelMaper
        //User user = modelMapper.map(userDto, User.class);

        //Usando Mapstruct

        Optional<User> optionalUser = iUserRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists For User");
        }
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);

        User savedUser = iUserRepository.save(user);
        //Convert User JPA entity to UserDto sing static methods
        //UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);

        //usando dependencia ModelMaper
        //UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        //usando Masptrcut
        UserDto savedUserDto = AutoUserMapper.MAPPER.mapToUserDto(savedUser);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        //Optional<User> optionalUser = iUserRepository.findById(userId);
        //User user =  optionalUser.get();
        //usando excepciones personalizadas
        User user = iUserRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );


        //Usando Metodo estatico
        //return UserMapper.mapToUserDto(user);
        //Usando ModelMapper
        //return modelMapper.map(user, UserDto.class);

        //usando Mapstruct
        //return AutoUserMapper.MAPPER.mapToUserDto(optionalUser.get());
        return AutoUserMapper.MAPPER.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = iUserRepository.findAll();
        /*
        Usando Metodos estaticos de manera manual
        return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        Usando ModelMapper
        return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        Usando MapStruct
        */
        return users.stream().map((user) -> AutoUserMapper.MAPPER.mapToUserDto(user)).
                collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        //User existingUser = iUserRepository.findById(userDto.getId()).get();
        //excepcion personalizada
        User existingUser = iUserRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userDto.getId())
        );
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updateUser = iUserRepository.save(existingUser);

        //Usando ModelMapper
        //return UserMapper.mapToUserDto(updateUser);

        //Usando MapStruct
        return AutoUserMapper.MAPPER.mapToUserDto(updateUser);
    }

    @Override
    public void deleteUser(Long userId) {
        //excepcion personalizada
        User existingUser = iUserRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        iUserRepository.deleteById(userId);
    }
}
