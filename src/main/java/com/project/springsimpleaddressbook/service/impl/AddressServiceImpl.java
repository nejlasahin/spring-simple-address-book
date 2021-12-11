package com.project.springsimpleaddressbook.service.impl;

import com.project.springsimpleaddressbook.converter.AddressConverter;
import com.project.springsimpleaddressbook.model.dto.request.AddressRequestDto;
import com.project.springsimpleaddressbook.exception.AddressNotFoundException;
import com.project.springsimpleaddressbook.exception.UserNotFoundException;
import com.project.springsimpleaddressbook.model.Address;
import com.project.springsimpleaddressbook.model.User;
import com.project.springsimpleaddressbook.model.dto.response.AddressResponseDto;
import com.project.springsimpleaddressbook.repository.AddressRepository;
import com.project.springsimpleaddressbook.repository.UserRepository;
import com.project.springsimpleaddressbook.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressConverter addressConverter;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressServiceImpl(AddressConverter addressConverter, AddressRepository addressRepository, UserRepository userRepository) {
        this.addressConverter = addressConverter;
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressResponseDto save(AddressRequestDto addressRequestDto, Long userId) {
        Address address = addressConverter.addressRequestDtoToAddress(addressRequestDto);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found.", userId)));
        address.setUser(user);
        return addressConverter.addressToAddressResponseDto(addressRepository.save(address));
    }

    @Override
    public AddressResponseDto update(AddressRequestDto addressRequestDto,Long addressId) {
        Address address = addressConverter.addressRequestDtoToAddress(addressRequestDto);
        addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(String.format("Address with id %d not found.", addressId)));
        return addressConverter.addressToAddressResponseDto(addressRepository.save(address));
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(String.format("Address with id %d not found.", addressId)));
        addressRepository.deleteById(addressId);
    }

    @Override
    public List<AddressResponseDto> getAll() {
        List<Address> addressList = addressRepository.findAll();
        return addressConverter.addressListToAddressResponseDtoList(addressList);
    }
}
