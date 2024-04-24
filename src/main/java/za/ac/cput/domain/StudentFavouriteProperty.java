package za.ac.cput.domain;

import java.util.Objects;

public class StudentFavouriteProperty {
    private String studentId;
    private String propertyId;

    protected StudentFavouriteProperty(){}

    private StudentFavouriteProperty(StudentFavouritePropertyBuilder builder){
        this.propertyId = builder.propertyId;
        this.studentId = builder.studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPropertyId() {
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
        private String studentId;
        private String propertyId;

        public StudentFavouritePropertyBuilder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }

        public StudentFavouritePropertyBuilder setPropertyId(String propertyId) {
            this.propertyId = propertyId;
            return this;
        }
        public StudentFavouriteProperty buildStudentFavouriteProperty(){return new StudentFavouriteProperty(this);}
    }

}
