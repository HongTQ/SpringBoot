package springboot.demo.service;

import java.util.List;
import java.util.Optional;

import springboot.demo.entity.Account;


public interface AccountService {
	public List<Account> findAll();
	Optional<Account> findById(int id);
	Account addAccount(Account account);
	void deleteAccount(int id);
	Account loadAccountByName(String accountName);
	Boolean checkLogin(Account account);
	Account updateAccount(int id, Account account);
}
