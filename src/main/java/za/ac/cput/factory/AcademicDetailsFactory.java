package za.ac.cput.factory;

import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Property;
import za.ac.cput.util.AcademicDetailsHelper;

public class AcademicDetailsFactory {
    public static AcademicDetails buildAcademicDetails(String academicDetailsID, String studentNo, String instituteName, String programOfStudy, int yearOfStudy) {
        {
            if (AcademicDetailsHelper.isNullOrEmpty(academicDetailsID) || AcademicDetailsHelper.isNullOrEmpty(studentNo) || AcademicDetailsHelper.isNullOrEmpty(instituteName) || AcademicDetailsHelper.isNullOrEmpty(programOfStudy) || yearOfStudy<=0){
                return  null;

            }

            return new AcademicDetails.Builder().setAcademicDetailsID(academicDetailsID)
                    .setInstituteName(instituteName)
                    .setStudentNo(studentNo)
                    .setProgramOfStudy(programOfStudy)
                    .setYearOfStudy(yearOfStudy)
                    .build();

        }
    }
}
