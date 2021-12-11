package com.project.springsimpleaddressbook.converter;

import com.project.springsimpleaddressbook.model.Address;
import com.project.springsimpleaddressbook.model.dto.request.AddressRequestDto;
import com.project.springsimpleaddressbook.model.dto.response.AddressResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    public static Address addressRequestDtoToAddress(AddressRequestDto addressRequestDto) {
        return Address.builder()
                .city(addressRequestDto.getCity())
                .country(addressRequestDto.getCountry())
                .build();
    }

    public static AddressResponseDto addressToAddressResponseDto(Address address) {
        return AddressResponseDto.builder()
                .city(address.getCity())
                .country(address.getCountry())
                .userResponseDto(UserConverter.userToUserResponseDto(address.getUser()))
                .build();
    }

    public static List<AddressResponseDto> addressListToAddressResponseDtoList(List<Address> addressList) {
        return addressList.stream().map(AddressConverter::addressToAddressResponseDto).collect(Collectors.toList());
    }

}
