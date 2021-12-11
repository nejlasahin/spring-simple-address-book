package com.project.springsimpleaddressbook.service;

import com.project.springsimpleaddressbook.model.dto.request.UserRequestDto;
import com.project.springsimpleaddressbook.model.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(UserRequestDto userRequestDto);
    UserResponseDto update(UserRequestDto userRequestDto, Long userId);
    void delete(Long userId);
    List<UserResponseDto> getAll();
}
