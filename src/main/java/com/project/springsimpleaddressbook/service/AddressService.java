package com.project.springsimpleaddressbook.service;

import com.project.springsimpleaddressbook.model.dto.request.AddressRequestDto;
import com.project.springsimpleaddressbook.model.dto.response.AddressResponseDto;

import java.util.List;

public interface AddressService {
    AddressResponseDto save(AddressRequestDto addressRequestDto, Long userId);
    AddressResponseDto update(AddressRequestDto addressRequestDto, Long addressId);
    void delete(Long addressId);
    List<AddressResponseDto> getAll();
}
