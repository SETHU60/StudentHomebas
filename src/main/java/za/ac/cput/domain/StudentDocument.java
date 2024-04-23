package za.ac.cput.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Mpumzi Mbula
 * 219053324
 * StudentDocument.java
 * 23/04/2024
 */
public class StudentDocument {
    private Student student;
    private Document document;
    private LocalDateTime dateTime;

    public StudentDocument(Builder builder) {
        this.student = builder.student;
        this.document = builder.document;
        this.dateTime = builder.dateTime;
    }

    public Student getStudent() {
        return student;
    }

    public Document getDocument() {
        return document;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentDocument that = (StudentDocument) o;
        return Objects.equals(student, that.student) && Objects.equals(document, that.document) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, document, dateTime);
    }

    @Override
    public String toString() {
        return "StudentDocument{" +
                "student=" + student +
                ", document=" + document +
                ", dateTime=" + dateTime +
                '}';
    }

    public class Builder {

        private Student student;
        private Document document;

        private LocalDateTime dateTime;

        public Builder (){

        }
        public Builder copy(StudentDocument studentDocument){
            this.document=studentDocument.document;
            this.student=studentDocument.student;
            this.dateTime=studentDocument.dateTime;
            return this;
        }

        public Builder setStudent(Student student) {
            this.student = student;
            return this;
        }

        public Builder setDocument(Document document) {
            this.document = document;
            return this;
        }

        public Builder setLocalDateTime(LocalDateTime localDateTime) {
            this.dateTime = localDateTime;
            return this;
        }
    }
}
