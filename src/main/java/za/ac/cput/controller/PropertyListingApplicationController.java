package za.ac.cput.controller;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 April 2024
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.PropertyListingApplication;
import za.ac.cput.service.propertyListingApplication.PropertyListingApplicationService;

import java.util.List;

@RestController
@RequestMapping("/PropertyListingApplication")
public class PropertyListingApplicationController {

    PropertyListingApplicationService service;

    @Autowired
    public PropertyListingApplicationController(PropertyListingApplicationService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public PropertyListingApplication save(@RequestBody PropertyListingApplication propertyListingApp) {
        return service.save(propertyListingApp);
    }

    @GetMapping("/read/{appNo}")
    public PropertyListingApplication read(@PathVariable Long appNo) {
        return service.read(appNo);
    }

    @PostMapping("/update")
    public PropertyListingApplication update(@RequestBody PropertyListingApplication propertyListingApp) {
        return service.update(propertyListingApp);
    }

    @DeleteMapping("/delete/{appNo}")
    public boolean deleteById(@PathVariable Long appNo) {
        return service.deleteById(appNo);
    }

    @GetMapping("/getAll")
    public List<PropertyListingApplication> getAll() {
        return service.getAll();
    }
}
