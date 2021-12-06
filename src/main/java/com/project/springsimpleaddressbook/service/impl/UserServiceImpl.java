package com.project.springsimpleaddressbook.service.impl;

import com.project.springsimpleaddressbook.converter.UserConverter;
import com.project.springsimpleaddressbook.dto.UserRequestDto;
import com.project.springsimpleaddressbook.exception.EmailIsAlreadyExistException;
import com.project.springsimpleaddressbook.exception.IdentityNumberIsAlreadyExistException;
import com.project.springsimpleaddressbook.exception.UserNotFoundException;
import com.project.springsimpleaddressbook.model.User;
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
    public User save(UserRequestDto userRequestDto) {
        User user = userConverter.userRequestDtoToUser(userRequestDto);
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailIsAlreadyExistException(String.format("Email with %s is already exist.", user.getEmail()));
        }
        if (userRepository.existsByIdentityNumber(user.getIdentityNumber())) {
            throw new IdentityNumberIsAlreadyExistException(String.format("Identity Number with %s is already exist.", user.getIdentityNumber()));
        }
        return userRepository.save(user);
    }

    @Override
    public User update(UserRequestDto userRequestDto, Long userId) {
        User requestUser = userConverter.userRequestDtoToUser(userRequestDto);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found.", userId)));

        if (userRepository.existsByEmail(requestUser.getEmail()) && !(user.getEmail().equals(requestUser.getEmail()))) {
            throw new EmailIsAlreadyExistException(String.format("Email with %s is already exist.", user.getEmail()));
        }
        if (userRepository.existsByIdentityNumber(requestUser.getIdentityNumber()) && !(user.getIdentityNumber().equals(requestUser.getIdentityNumber()))) {
            throw new IdentityNumberIsAlreadyExistException(String.format("Identity Number with %s is already exist.", user.getIdentityNumber()));
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(String.format("User with id %d not found.", userId));
        }
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
