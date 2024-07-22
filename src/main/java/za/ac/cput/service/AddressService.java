package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;

import java.util.List;
@Service
public class AddressService implements IAddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address read(Object o) {
        return addressRepository.findById(o).orElse(null);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public boolean deleteById(Object o) {
        addressRepository.deleteById(o);
        return !addressRepository.existsById(o);
    }
    @Override
    public List<Address> getall() {
        return addressRepository.findAll();
    }
}
