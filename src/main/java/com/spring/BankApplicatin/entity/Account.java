package com.spring.BankApplicatin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static com.spring.BankApplicatin.constants.Constants.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account" )
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @NotEmpty
    @Size(min=3,max=10)
    private String accName;
    //@Size(min=3)
    private long balance;

    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }



//    public static boolean isAmountValid(String amount) {
//
//        return Constants.AMOUNT_PATTERN.matcher(amount).find();
//    }

//     public long withDraw (long amount){
//         amount = .nextLine();
//         if (!amount.matcher("[0-9]+")) {
//             System.out.println("Invalid number");
//         }
//
//        return balance;
//     }
//    public ResponseEntity<?> withDraw(WithdrawInput withdrawInput) {
//        Account account = accountService.getAccount(withdrawInput.getId());
//        if (account == null) {
//            return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
//        } else {
//            if (account.isAmountAvailable(withdrawInput.getAmount(), account.getBalance())) {
//                accountService.updateAccountBalance(account, withdrawInput.getAmount(), ACTION.WITHDRAW);
//                return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(INSUFFICIENT_ACCOUNT_BALANCE, HttpStatus.OK);
//            }
//        }
//    }


}
