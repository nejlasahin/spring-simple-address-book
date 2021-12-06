package com.project.springsimpleaddressbook.controller;

import com.project.springsimpleaddressbook.dto.AddressRequestDto;
import com.project.springsimpleaddressbook.model.Address;
import com.project.springsimpleaddressbook.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Address> save(@Valid @RequestBody AddressRequestDto addressRequestDto, @PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.save(addressRequestDto, userId));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<String> delete(@PathVariable Long addressId){
        addressService.delete(addressId);
        return ResponseEntity.status(HttpStatus.OK).body("Address is deleted.");
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> update(@RequestBody AddressRequestDto addressRequestDto,@PathVariable Long addressId){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(addressRequestDto, addressId));
    }
}
