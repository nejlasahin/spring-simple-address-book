package com.project.springsimpleaddressbook.service;

import com.project.springsimpleaddressbook.dto.AddressRequestDto;
import com.project.springsimpleaddressbook.model.Address;

import java.util.List;

public interface AddressService {
    Address save(AddressRequestDto addressRequestDto, Long userId);
    Address update(AddressRequestDto addressRequestDto, Long addressId);
    void delete(Long addressId);
    List<Address> getAll();
}
