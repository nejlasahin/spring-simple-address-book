package com.project.springsimpleaddressbook.service.impl;

import com.project.springsimpleaddressbook.converter.UserConverter;
import com.project.springsimpleaddressbook.model.dto.request.UserRequestDto;
import com.project.springsimpleaddressbook.exception.EmailIsAlreadyExistException;
import com.project.springsimpleaddressbook.exception.IdentityNumberIsAlreadyExistException;
import com.project.springsimpleaddressbook.exception.UserNotFoundException;
import com.project.springsimpleaddressbook.model.User;
import com.project.springsimpleaddressbook.model.dto.response.UserResponseDto;
import com.project.springsimpleaddressbook.repository.UserRepository;
import com.project.springsimpleaddressbook.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = userConverter.userRequestDtoToUser(userRequestDto);
        userRepository.findByEmail(user.getEmail())
                .ifPresent(resultUser -> { throw new EmailIsAlreadyExistException(String.format("Email with %s is already exist.", user.getEmail())); } );
        userRepository.findByIdentityNumber(user.getIdentityNumber())
                .ifPresent(resultUser -> { throw new IdentityNumberIsAlreadyExistException(String.format("Identity Number with %s is already exist.", user.getIdentityNumber())); } );
        return userConverter.userToUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(UserRequestDto userRequestDto, Long userId) {
        User requestUser = userConverter.userRequestDtoToUser(userRequestDto);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found.", userId)));
        if (userRepository.existsByEmail(requestUser.getEmail()) && !(user.getEmail().equals(requestUser.getEmail()))) {
            throw new EmailIsAlreadyExistException(String.format("Email with %s is already exist.", user.getEmail()));
        }
        if (userRepository.existsByIdentityNumber(requestUser.getIdentityNumber()) && !(user.getIdentityNumber().equals(requestUser.getIdentityNumber()))) {
            throw new IdentityNumberIsAlreadyExistException(String.format("Identity Number with %s is already exist.", user.getIdentityNumber()));
        }
        return userConverter.userToUserResponseDto(userRepository.save(user));
    }

    @Override
    public void delete(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found.", userId)));
        userRepository.deleteById(userId);
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userConverter.userListToUserResponseDtoList(userRepository.findAll());
    }
}
