package za.ac.cput.util;

import za.ac.cput.domain.Document;
import za.ac.cput.domain.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentDocumentHelper {
    public static boolean isStudentNull(Student student) {
        if (student == null) {
            return true;
        }
        return false;

    }

    public static boolean isDocumentNull(Document document) {
        if (document == null) {
            return true;
        }
        return false;
    }     public static boolean isValidDate(LocalDateTime localDateTime){
        String dateFormat = "yyyy/MM/dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
        String formattedDate = localDateTime.format(formatter);
        return formattedDate.equals(dateFormat);
    }

}
