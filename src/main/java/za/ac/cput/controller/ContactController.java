package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Contact;
import za.ac.cput.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/save")
    public Contact save(@RequestBody Contact contact) {

        return contactService.save(contact);
    }

    @GetMapping("/read/{contactId}")
    public Contact read(@PathVariable("contactId")String contactId){
        return contactService.read(contactId);
    }

    @PostMapping("/update")
    public Contact update(@RequestBody Contact contact) {

        return contactService.update(contact);
    }

    @DeleteMapping("/delete/{contactId}")
    public boolean delete(@PathVariable String contactId){
        return false;
    }

    @GetMapping("/getall")
    public List<Contact> getall(){
        return contactService.getAll();
    }
}
