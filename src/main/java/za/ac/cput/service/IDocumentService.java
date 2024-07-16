package za.ac.cput.service;

import za.ac.cput.domain.Document;

import java.util.List;

public interface IDocumentService extends IService<Document,Long>{
    List<Document>getall();
}
