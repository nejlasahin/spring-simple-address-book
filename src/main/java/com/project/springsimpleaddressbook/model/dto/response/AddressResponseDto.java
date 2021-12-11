package com.project.springsimpleaddressbook.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDto {
    private String city;
    private String country;
    private UserResponseDto userResponseDto;
}
