package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.AddressId;
import za.ac.cput.domain.Landlord;
import za.ac.cput.domain.Student;
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

    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<String> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        if (email == null || email.isEmpty()) {
            return new ResponseEntity<>("Email is null or empty", HttpStatus.BAD_REQUEST);
        }
        if (password == null || password.isEmpty()) {
            return new ResponseEntity<>("Password is null or empty", HttpStatus.BAD_REQUEST);
        }

        Landlord authenticatedLandlord = landlordService.authenticationByEmail(email, password);
        if (authenticatedLandlord != null) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

}
