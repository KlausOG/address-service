package com.discovery_service.address_service.repository;

import com.discovery_service.address_service.entity.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
    @Query(nativeQuery = true,
        value = "SELECT ea.id, ea.city, ea.state from "+
                " microservices.address ea join microservices.employee e"+
                " on e.id = ea.employee_id where ea.employee_id=:employeeId")
    Optional<Address> findByEmployeeId(@Param("employeeId") int employeeId);

}
