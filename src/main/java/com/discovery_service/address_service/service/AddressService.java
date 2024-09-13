package com.discovery_service.address_service.service;

import com.discovery_service.address_service.entity.Address;
import com.discovery_service.address_service.repository.AddressRepository;
import com.discovery_service.address_service.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        Optional<Address> addressByEmployeeId = addressRepository.findByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(addressByEmployeeId,AddressResponse.class);
        return addressResponse;
    }
}
