package com.project.springsimpleaddressbook.converter;

import com.project.springsimpleaddressbook.model.Gender;
import com.project.springsimpleaddressbook.model.User;
import com.project.springsimpleaddressbook.model.dto.request.UserRequestDto;
import com.project.springsimpleaddressbook.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    public static User userRequestDtoToUser (UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .surname(userRequestDto.getSurname())
                .email(userRequestDto.getEmail())
                .identityNumber(userRequestDto.getIdentityNumber())
                .gender(Gender.valueOf(userRequestDto.getGender()))
                .build();
    }

    public static UserResponseDto userToUserResponseDto (User user) {
        return UserResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .gender(String.valueOf(user.getGender()))
                .build();
    }

    public static List<UserResponseDto> userListToUserResponseDtoList(List<User> userList) {
        return userList.stream().map(UserConverter::userToUserResponseDto).collect(Collectors.toList());
    }

}
