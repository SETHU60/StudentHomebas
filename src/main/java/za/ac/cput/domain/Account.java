package za.ac.cput.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Account {
    private int AccountID;
    private String AccountType;
    private String PaymentInfo;
    private double Balance;
    private LocalDate paymentDueDate;
    private  String paymentStatus;
    private String AccountStatus;

    public Account(){}

    public int getAccountID() {
        return AccountID;
    }

    public String getAccountType() {
        return AccountType;
    }

    public String getPaymentInfo() {
        return PaymentInfo;
    }

    public double getBalance() {
        return Balance;
    }

    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getAccountStatus() {
        return AccountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountID=" + AccountID +
                ", AccountType='" + AccountType + '\'' +
                ", PaymentInfo='" + PaymentInfo + '\'' +
                ", Balance=" + Balance +
                ", paymentDueDate=" + paymentDueDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", AccountStatus='" + AccountStatus + '\'' +
                '}';
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if(o == null || getClass() !=o.getClass()) return false;
        Account account = (Account) o;
        return AccountID == account.AccountID && Objects.equals(AccountID, account.AccountID) && Objects.equals(AccountType, account.AccountType) && Objects.equals(PaymentInfo, account.PaymentInfo) && Objects.equals(Balance, account.Balance) && Objects.equals(paymentDueDate, account.paymentDueDate) && Objects.equals(paymentStatus, account.paymentStatus) && Objects.equals(AccountStatus, account.AccountStatus);
    }
    public int hashCode(){
        return Objects.hash(AccountID,AccountType,PaymentInfo,Balance,paymentDueDate,paymentStatus,AccountStatus);
    }
}
