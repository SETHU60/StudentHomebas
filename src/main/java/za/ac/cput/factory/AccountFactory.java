//package za.ac.cput.factory;
//
//import za.ac.cput.domain.Account;
//import za.ac.cput.domain.User;
//
//import java.time.LocalDate;
//
//public class AccountFactory {
//
//    public static Account buildAccount(int accountId, String accountType, String paymentInfo, double balance,
//                                        LocalDate paymentDueDate, String paymentStatus, String accountStatus, User user) {
//        return new Account.AccountBuilder()
//                .setAccountId(accountId)
//                .setAccountType(accountType)
//                .setPaymentInfo(paymentInfo)
//                .setBalance(balance)
//                .setPaymentDueDate(paymentDueDate)
//                .setPaymentStatus(paymentStatus)
//                .setAccountStatus(accountStatus)
//                .setUser(user)
//                .build();
//    }
//}
