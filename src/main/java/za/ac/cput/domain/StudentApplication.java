package za.ac.cput.domain;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 22 April 2024
 * */

import java.util.Date;
import java.util.Objects;

public class StudentApplication extends Application {

    private String studentID;
    private String propertyID;
    private double price;

    public StudentApplication(){}

    public StudentApplication(Builder builder){
        this.appNo = builder.appNo;
        this.date = builder.date;
        this.status = builder.status;
        this.studentID = builder.studentID;
        this.propertyID = builder.propertyID;
        this.price = builder.price;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentApplication that = (StudentApplication) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(studentID, that.studentID) && Objects.equals(propertyID, that.propertyID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), studentID, propertyID, price);
    }

    @Override
    public String toString() {
        return "StudentApplication{" +
                "studentID='" + studentID + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", price=" + price +
                ", appNo='" + appNo + '\'' +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private String appNo;
        private Date date;
        private Status status;

        private String studentID;
        private String propertyID;
        private double price;

        public Builder setAppNo(String appNo) {
            this.appNo = appNo;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setPropertyID(String propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public StudentApplication.Builder copy (StudentApplication studentApp){
            this.appNo = studentApp.appNo;
            this.date = studentApp.date;
            this.status = studentApp.status;
            this.studentID = studentApp.studentID;
            this.propertyID = studentApp.propertyID;
            this.price = studentApp.price;
            return this;
        }

        public StudentApplication build(){
            return new StudentApplication(this);
        }
    }
}
