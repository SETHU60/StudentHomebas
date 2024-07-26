package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;
import za.ac.cput.domain.Landlord;
import za.ac.cput.service.AddressService;
import za.ac.cput.service.landlordService.LandlordService;

import java.util.List;

@RestController
@RequestMapping("/landlord")
public class LandlordController {
    @Autowired
    private LandlordService landlordService;

    @PostMapping("/save")
    public Landlord save(@RequestBody Landlord landlord) {
        return landlordService.save(landlord);
    }

    @GetMapping("/read/{landlordId}")
    public Landlord read(@PathVariable Long landlordId) {
        return landlordService.read(landlordId);
    }

    @PostMapping("/update")
    public Landlord update(@RequestBody Landlord landlord) {
        return landlordService.save(landlord);
    }

    @DeleteMapping("/delete/{landlordId}")
    public boolean delete(@PathVariable Long landlordId) {
        return landlordService.deleteById(landlordId);
    }

    @GetMapping("/getall")
    public List<Landlord> getAll() {
        return landlordService.getall();
    }
}
