package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Document;
import za.ac.cput.repository.DocumentRepository;

import java.util.List;

@Service
public class DocumentService implements IDocumentService {
    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document read(Long documentId) {
        return documentRepository.findById(documentId).orElse(null);
    }

    @Override
    public Document update(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public boolean deleteById(Long documentId) {

        documentRepository.deleteById(documentId);
        return !documentRepository.existsById(documentId);
    }

    @Override
    public List<Document> getall() {
        return documentRepository.findAll();
    }

}
