package za.ac.cput.factory;

import za.ac.cput.domain.StudentFavouriteProperty;

public class StudentFavPropertyFactory {
    public static StudentFavouriteProperty buildStudentFavProperty(Long studentId, Long propertyId){
        if(studentId<=0 || propertyId<=0){
            return null;
        }
        return new StudentFavouriteProperty.StudentFavouritePropertyBuilder()
                .setStudentId(studentId)
                .setPropertyId(propertyId)
                .buildStudentFavouriteProperty();
    }
}
