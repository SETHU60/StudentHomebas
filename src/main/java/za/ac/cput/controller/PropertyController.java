package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Property;
import za.ac.cput.service.PropertyService.PropertyService;

import java.util.List;
@RestController
@RequestMapping("/Property")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @PostMapping("/create")
    public Property create(@RequestBody Property property) {
        return propertyService.create(property);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity read(@PathVariable String id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Property property = propertyService.read(id);

        if (property == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @PostMapping("/update")
    public  Property update(@RequestBody Property property) {
        return propertyService.update(property);
    }

    @PostMapping("/delete/{id}")
    public Boolean delete(@PathVariable String id) {
        return propertyService.delete(id);
    }

    @GetMapping("/getAll")
    public List<Property> getAll() {
        return propertyService.getAll();
    }

}
