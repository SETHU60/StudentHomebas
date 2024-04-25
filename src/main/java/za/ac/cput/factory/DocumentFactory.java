package za.ac.cput.factory;

import za.ac.cput.domain.Document;
import za.ac.cput.util.DocumentHelper;

import java.io.File;

public class DocumentFactory {
    public Document buildDocument( String documentName, File file){
        if(DocumentHelper.isNullOrEmpty(documentName)||
                DocumentHelper.isFileNull(file)){
            return null;
        }
        return new Document.Builder().setDocumentId(DocumentHelper.generateId()).
                setDocumentName(documentName).
                setFileContents(file).build();
    }
}
