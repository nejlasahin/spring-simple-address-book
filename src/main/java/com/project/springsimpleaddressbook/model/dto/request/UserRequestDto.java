package com.project.springsimpleaddressbook.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    @Email(message = "Email is not valid")
    private String email;

    @NotBlank(message = "Identity number is mandatory")
    private String identityNumber;

    @NotBlank(message = "Gender is mandatory")
    private String gender;


}
