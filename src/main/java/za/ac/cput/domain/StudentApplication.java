package za.ac.cput.domain;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 22 April 2024
 * */

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class StudentApplication extends Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long appNo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student studentID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id", referencedColumnName = "id")
    private Property propertyID;

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

    public Student getStudentID() {
        return studentID;
    }

    public Property getPropertyID() {
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
        return Double.compare(price, that.price) == 0 &&
                Objects.equals(studentID, that.studentID) &&
                Objects.equals(propertyID, that.propertyID);
    }

    @Override
    public int hashCode() {
        return
                Objects.hash(super.hashCode(), studentID, propertyID, price);
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
        private long appNo;
        private LocalDate date;
        private Status status;

        private Student studentID;
        private Property propertyID;
        private double price;

        public Builder setAppNo(long appNo) {
            this.appNo = appNo;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setStudentID(Student studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setPropertyID(Property propertyID) {
            this.propertyID = propertyID;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy (StudentApplication studentApp){
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
