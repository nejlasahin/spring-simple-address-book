package com.project.springsimpleaddressbook.service;

import com.project.springsimpleaddressbook.dto.UserRequestDto;
import com.project.springsimpleaddressbook.model.User;

import java.util.List;

public interface UserService {
    User save(UserRequestDto userRequestDto);
    User update(UserRequestDto userRequestDto, Long userId);
    void delete(Long userId);
    List<User> getAll();
}
