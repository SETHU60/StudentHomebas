package za.ac.cput.factory;

import za.ac.cput.domain.AcademicDetails;
import za.ac.cput.domain.Property;
import za.ac.cput.domain.Student;
import za.ac.cput.util.AcademicDetailsHelper;
import za.ac.cput.util.Helper;

public class AcademicDetailsFactory {
    public static AcademicDetails buildAcademicDetails(String academicDetailsID, String instituteName, String programOfStudy,
                                                       int yearOfStudy) {
        {
            if (AcademicDetailsHelper.isNullOrEmpty(academicDetailsID) ||
                    AcademicDetailsHelper.isNullOrEmpty(instituteName) ||
                    AcademicDetailsHelper.isNullOrEmpty(programOfStudy) ||
                    yearOfStudy<=0
            ){
                return  null;
            }

            return new AcademicDetails.Builder().setAcademicDetailsID(academicDetailsID)
                    .setInstituteName(instituteName)
                    .setProgramOfStudy(programOfStudy)
                    .setYearOfStudy(yearOfStudy)

                    .build();

        }
    }
}
