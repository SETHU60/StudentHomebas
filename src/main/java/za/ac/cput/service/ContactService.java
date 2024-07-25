package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Contact;
import za.ac.cput.repository.ContactRepository;

import java.util.List;
@Service
public class ContactService implements IContactService{
    @Autowired
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact read(String contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public boolean deleteById(String contactId) {
        contactRepository.deleteById(contactId);
        return !contactRepository.existsById(contactId);
    }
    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
