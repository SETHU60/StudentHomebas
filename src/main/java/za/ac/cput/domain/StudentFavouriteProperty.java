package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class StudentFavouriteProperty {
    @Id
    private Long studentId;
    private Long propertyId;

    protected StudentFavouriteProperty(){}

    private StudentFavouriteProperty(StudentFavouritePropertyBuilder builder){
        this.propertyId = builder.propertyId;
        this.studentId = builder.studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    @Override
    public String toString() {
        return "StudentFavouriteProperty{" +
                "studentId='" + studentId + '\'' +
                ", propertyId='" + propertyId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentFavouriteProperty that = (StudentFavouriteProperty) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, propertyId);
    }
    public static class  StudentFavouritePropertyBuilder{
        private Long studentId;
        private Long propertyId;

        public StudentFavouritePropertyBuilder setStudentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentFavouritePropertyBuilder setPropertyId(Long propertyId) {
            this.propertyId = propertyId;
            return this;
        }
        public StudentFavouriteProperty buildStudentFavouriteProperty(){return new StudentFavouriteProperty(this);}
    }

}
