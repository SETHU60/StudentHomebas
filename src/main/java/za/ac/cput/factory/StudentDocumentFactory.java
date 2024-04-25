package za.ac.cput.factory;

import za.ac.cput.domain.Document;
import za.ac.cput.domain.Student;
import za.ac.cput.domain.StudentDocument;
import za.ac.cput.util.StudentDocumentHelper;
import za.ac.cput.util.StudentHelper;

import java.time.LocalDateTime;

public class StudentDocumentFactory {
    public StudentDocument buildStudentDocument(Student student, Document document, LocalDateTime dateTimeUploaded){
        if(StudentDocumentHelper.isStudentNull(student)||StudentDocumentHelper.isDocumentNull(document)||StudentDocumentHelper.isValidDate(dateTimeUploaded)){
        return null;
        }
        return new StudentDocument.Builder().
                setDocument(document).
                setStudent(student).
                setLocalDateTime(dateTimeUploaded).build();

    }
}
