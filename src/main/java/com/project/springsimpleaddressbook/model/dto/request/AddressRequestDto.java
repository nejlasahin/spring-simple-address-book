package com.project.springsimpleaddressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequestDto {

    @Size(min = 3, max = 30, message = "City must be between 3 and 30 characters")
    @Pattern(regexp="(^[a-zA-Z]{3,30}$)", message = "City must be of characters")
    @NotBlank(message = "City is mandatory")
    public String city;

    @Size(min = 3, max = 30, message = "Country must be between 3 and 30 characters")
    @Pattern(regexp="(^[a-zA-Z]{3,30}$)", message = "Country must be of characters")
    @NotBlank(message = "Country is mandatory")
    public String country;
}
