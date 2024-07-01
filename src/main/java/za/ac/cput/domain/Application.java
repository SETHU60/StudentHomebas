package za.ac.cput.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.time.LocalDate;
import java.util.Objects;

/*
 * Author : Sabelo Kama (219149364)
 * Date : 22 April 2024
 * */

@Inheritance(strategy = InheritanceType.JOINED)
public class Application {
    public enum Status{
        Pending, Accepted, Rejected;
    }

    protected LocalDate date;
    protected Status status;

    public Application(){}

    public LocalDate getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Application{" +
                ", date=" + date +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Application that = (Application) o;
        return Objects.equals(date, that.date) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, status);
    }
}
