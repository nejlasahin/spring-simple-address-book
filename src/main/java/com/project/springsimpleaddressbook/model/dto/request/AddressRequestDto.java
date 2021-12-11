package com.project.springsimpleaddressbook.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequestDto {

    @NotBlank(message = "City is mandatory")
    public String city;

    @NotBlank(message = "Country is mandatory")
    public String country;

}
