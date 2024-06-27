package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class AcademicDetails {
   @Id
   private String academicDetailsID;
   private String instituteName;
   private  String programOfStudy;
   private  int yearOfStudy;
   
   @OneToOne
   private Student student;

   protected AcademicDetails() {
   }



   private AcademicDetails(Builder builder){
     this.academicDetailsID = builder.academicDetailsID;
      this.student = builder.student;
      this.instituteName = builder.instituteName;
      this.programOfStudy = builder.programOfStudy;
      this.yearOfStudy = builder.yearOfStudy;
   }

   public String getAcademicDetailsID() {
      return academicDetailsID;
   }

   public Student getstudent() {
      return student;
   }

   public String getInstituteName() {
      return instituteName;
   }

   public String getProgramOfStudy() {
      return programOfStudy;
   }

   public int getYearOfStudy() {
      return yearOfStudy;
   }

   @Override
   public String toString() {
      return "AcademicDetails{" +
              "academicDetailsID='" + academicDetailsID + '\'' +
              ", student='" + student + '\'' +
              ", instituteName='" + instituteName + '\'' +
              ", programOfStudy='" + programOfStudy + '\'' +
              ", yearOfStudy=" + yearOfStudy +
              '}';
   }

   public static class Builder{
      private String academicDetailsID;
      private Student student;
      private String instituteName;
      private  String programOfStudy;
      private  int yearOfStudy;

      public Builder setAcademicDetailsID(String academicDetailsID){
         this.academicDetailsID = academicDetailsID;
         return this;
      }
      public Builder setStudent(Student student){
            this.student = student;
            return this;
      }
      public Builder setInstituteName(String instituteName){
         this.instituteName = instituteName;
         return this;
      }
      public Builder setProgramOfStudy(String programOfStudy){
         this.programOfStudy = programOfStudy;
         return this;
      }
      public Builder setYearOfStudy(int yearOfStudy){
         this.yearOfStudy = yearOfStudy;
         return this;
      }
      private Builder copy(AcademicDetails academicDetails){
         this.academicDetailsID = academicDetails.academicDetailsID;
         this.student = academicDetails.student;
         this.instituteName = academicDetails.instituteName;
         this.programOfStudy = academicDetails.programOfStudy;
         this.yearOfStudy = academicDetails.yearOfStudy;

         return this;
      }
      public AcademicDetails build(){
         return new AcademicDetails(this);
      }

   }
}
