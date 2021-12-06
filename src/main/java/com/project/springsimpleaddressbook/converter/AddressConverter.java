package com.project.springsimpleaddressbook.converter;


import com.project.springsimpleaddressbook.dto.AddressRequestDto;
import com.project.springsimpleaddressbook.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter {

    public Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto) {
        return Address.builder()
                .city(addressRequestDto.getCity())
                .country(addressRequestDto.getCountry())
                .build();
    }
}
