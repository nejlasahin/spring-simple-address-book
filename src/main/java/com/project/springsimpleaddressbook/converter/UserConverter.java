package com.project.springsimpleaddressbook.converter;


import com.project.springsimpleaddressbook.dto.UserRequestDto;
import com.project.springsimpleaddressbook.model.Gender;
import com.project.springsimpleaddressbook.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User userRequestDtoToUser (UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .surname(userRequestDto.getSurname())
                .email(userRequestDto.getEmail())
                .identityNumber(userRequestDto.getIdentityNumber())
                .gender(Gender.valueOf(userRequestDto.getGender()))
                .build();
    }
}
