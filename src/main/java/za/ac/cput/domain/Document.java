package za.ac.cput.domain;

import java.io.File;
import java.util.Objects;

/**
 * Mpumzi Mbula
 * 219053324
 * Document.java
 * 23/04/2024
 */
public class Document {
    private String documentId;
    private String documentName;
    private File fileContents;

    private Document(Builder builder){
        this.documentId=builder.documentId;
        this.documentName=builder.documentName;
        this.fileContents=builder.fileContents;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public File getFileContents() {
        return fileContents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(documentId, document.documentId) && Objects.equals(documentName, document.documentName) && Objects.equals(fileContents, document.fileContents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, documentName, fileContents);
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", documentName='" + documentName + '\'' +
                ", fileContents=" + fileContents +
                '}';
    }
    public class  Builder{
        private String documentId;
        private String documentName;
        private File fileContents;

        public Builder(){

        }
        public Builder copy(Document document){
            this.documentId=document.documentId;
            this.documentName=document.documentName;
            this.fileContents=document.fileContents;
            return this;
        }

        public Builder setDocumentId(String documentId) {
            this.documentId = documentId;
            return this;
        }

        public Builder setDocumentName(String documentName) {
            this.documentName = documentName;
            return this;
        }

        public Builder setFileContents(File fileContents) {
            this.fileContents = fileContents;
            return this;
        }
        public Document build(){
            return new Document(this);
        }
    }
}
