package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Document;
import za.ac.cput.service.DocumentService;

import java.util.List;
//
@RestController
@RequestMapping("/document")

public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/save")
    public Document save(@RequestBody Document document){
        return documentService.save(document);
    }
    @GetMapping("/read/{documentId}")
    public Document read(@PathVariable("documentId")Long documentId){
        return documentService.read(documentId);
    }
    @PostMapping("/update")
    public Document update(@RequestBody Document document){
        return documentService.save(document);
    }
    @DeleteMapping("/delete/{documentId}")
    public boolean delete(@PathVariable Long documentId){
        return documentService.deleteById(documentId);
    }
    @GetMapping("/getall")
    public List<Document>getall(){
        return documentService.getall();
    }

}
