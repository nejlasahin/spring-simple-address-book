package com.project.springsimpleaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    @Pattern(regexp="(^[a-zA-Z]{3,50}$)", message = "Name must be of characters")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Size(min = 3, max = 50, message = "Surname must be between 3 and 50 characters")
    @Pattern(regexp="(^[a-zA-Z]{3,50}$)", message = "Surname must be of characters")
    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @Email(message = "Email is not valid")
    private String email;

    @Pattern(regexp = "^[1-9]{1}[0-9]{9}[02468]{1}$", message = "Identity Number must be 11 characters")
    private String identityNumber;

    @Pattern(regexp = "^MALE$|^FEMALE$|^OTHER$", message = "Gender must be MALE or FEMALE or OTHER")
    private String gender;
}
