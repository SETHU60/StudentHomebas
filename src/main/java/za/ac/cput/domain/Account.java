package za.ac.cput.domain;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;
    private String accountType;
    private String paymentInfo;
    private double balance;
    private LocalDate paymentDueDate;
    private String paymentStatus;
    private String accountStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Account() {
    }

    private Account(AccountBuilder builder) {
        this.accountId = builder.accountId;
        this.accountType = builder.accountType;
        this.paymentInfo = builder.paymentInfo;
        this.balance = builder.balance;
        this.paymentDueDate = builder.paymentDueDate;
        this.paymentStatus = builder.paymentStatus;
        this.accountStatus = builder.accountStatus;
        this.user = builder.user;
    }

    public int getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPaymentInfo() {
        return paymentInfo;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDate getPaymentDueDate() {
        return paymentDueDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public User getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                Double.compare(account.balance, balance) == 0 &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(paymentInfo, account.paymentInfo) &&
                Objects.equals(paymentDueDate, account.paymentDueDate) &&
                Objects.equals(paymentStatus, account.paymentStatus) &&
                Objects.equals(accountStatus, account.accountStatus) &&
                Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, accountType, paymentInfo, balance, paymentDueDate, paymentStatus, accountStatus, user);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType='" + accountType + '\'' +
                ", paymentInfo='" + paymentInfo + '\'' +
                ", balance=" + balance +
                ", paymentDueDate=" + paymentDueDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", accountStatus='" + accountStatus + '\'' +
                ", user=" + user +
                '}';
    }

    public static class AccountBuilder {
        private int accountId;
        private String accountType;
        private String paymentInfo;
        private double balance;
        private LocalDate paymentDueDate;
        private String paymentStatus;
        private String accountStatus;
        private User user;

        public AccountBuilder setAccountId(int accountId) {
            this.accountId = accountId;
            return this;
        }

        public AccountBuilder setAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public AccountBuilder setPaymentInfo(String paymentInfo) {
            this.paymentInfo = paymentInfo;
            return this;
        }

        public AccountBuilder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public AccountBuilder setPaymentDueDate(LocalDate paymentDueDate) {
            this.paymentDueDate = paymentDueDate;
            return this;
        }

        public AccountBuilder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public AccountBuilder setAccountStatus(String accountStatus) {
            this.accountStatus = accountStatus;
            return this;
        }

        public AccountBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
