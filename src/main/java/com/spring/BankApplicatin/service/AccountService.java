package com.spring.BankApplicatin.service;

import com.spring.BankApplicatin.constants.ACTION;
import com.spring.BankApplicatin.dao.AccountDao;
import com.spring.BankApplicatin.dto.DepositInput;
import com.spring.BankApplicatin.dto.WithdrawInput;
import com.spring.BankApplicatin.dto.accountRequest;
import com.spring.BankApplicatin.entity.Account;
import com.spring.BankApplicatin.entity.User;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import java.util.List;
import java.util.Optional;

import static com.spring.BankApplicatin.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountDao accountDao;
    private final UserService userService;
    private final EntityManager entityManager;

    public Account createAccount(String accName, long balance,long userId) throws Exception {
        User user = userService.findById(userId);
        Account account = new Account();
        account.setAccName(accName);
        account.setBalance(balance);
        account.setUsers((List<User>) user);
//        Account accounts = accountDao.save(account);
        return accountDao.save(account);
    }

  //  get accounts by name using of  custom query
    public List<Account> getAccounts(String accName) {
        List<Account> account= accountDao.findAll(new Specification<Account>(){
           @Override
            public  Predicate toPredicate(Root<Account> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                Predicate p=cb.conjunction();
                   p=cb.and(p,cb.like(root.get("accName"),"%" + accName +"%" ));
                   return p;
                //This is not using of custom method
                // p=cb.and(p,root.get("accName"));
            }
        });
        return account;
    }

//    public List<Account> getAccounts(String accName) {
//         Account account= (Account) accountDao.findAll();
//
//        }
//    }

    public Optional<Account> checkAccountById(long id) {
        return  accountDao.findById(id);
    }


    public Account getAccount(long id) {
        Optional<Account> account = accountDao
                .findById(id);
        // accountDao.save(account);
        return account.orElse(null);
    }

    public void updateAccountBalance(Account account, double amount, ACTION action) {
        if (action == ACTION.WITHDRAW) {
            account.setBalance((long) (account.getBalance() - amount));
        } else if (action == ACTION.DEPOSIT) {
            account.setBalance((long) (account.getBalance() + amount));
        }
        accountDao.save(account);
    }


    public ResponseEntity<?> withDraw(WithdrawInput withdrawInput) {
//        if (account.isAmountValid(String.valueOf(withdrawInput))) {
        Account account = getAccount(withdrawInput.getId());
        if (account == null) {
             return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        } else {
            if (account.isAmountAvailable(withdrawInput.getAmount(), account.getBalance())) {
                updateAccountBalance(account, withdrawInput.getAmount(), ACTION.WITHDRAW);
                return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(INSUFFICIENT_ACCOUNT_BALANCE, HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<?> deposit(DepositInput depositInput){
        Account account = getAccount(depositInput.getId());
        if (account == null) {
            return new ResponseEntity<>(NO_ACCOUNT_FOUND, HttpStatus.OK);
        } else {
            updateAccountBalance(account, depositInput.getAmount(), ACTION.DEPOSIT);
            return new ResponseEntity<>(SUCCESS, HttpStatus.OK);
        }
    }

    public Page<Account> findAccountWithPagination(int offset , int pageSize){
       Page<Account> accounts= accountDao.findAll(PageRequest.of(offset,pageSize));
       return accounts;
    }

    public Account findById(long id) {
        return null;
    }
}









//This is use for custom method with AccountDao query
//        return accountDao.findByAccName(keyword);
//Waste of code
//  Query query= entityManager.createQuery("SELECT keyword from Account WHERE keyword=?1 ");
// return query.getResultList();