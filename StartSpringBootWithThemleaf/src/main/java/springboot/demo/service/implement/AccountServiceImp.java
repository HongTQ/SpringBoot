package springboot.demo.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.demo.common.exception.NotFoundException;
import springboot.demo.entity.Account;
import springboot.demo.repository.AccountRepository;
import springboot.demo.service.AccountService;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Optional<Account> findById(int id) {
		return accountRepository.findById(id);
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);

	}

	@Override
	public void deleteAccount(int id) {
		Optional<Account> del_account = accountRepository.findById(id);
		if (!del_account.isPresent()) {
			throw new NotFoundException("Not found id = " + id + " ");
		}
		accountRepository.deleteById(id);
	}

	@Override
	public Account loadAccountByName(String accountName) {
		return accountRepository.findAccountByAccountName(accountName);
	}

	@Override
	public Account updateAccount(int id, Account account) {
		Optional<Account> updateAccount = accountRepository.findById(id);
		if (!updateAccount.isPresent()) {
			throw new NotFoundException("Not found this account");
		}
		Account editAccount = updateAccount.get();
		editAccount.setAccountPass(account.getAccountPass());
		return accountRepository.save(editAccount);
	}

	@Override
	public Boolean checkLogin(Account account) {
		Account accountLogin = accountRepository.findAccountByAccountNameAndAccountPass(account.getAccountName(),
				account.getAccountPass());
		if (accountLogin != null) {
			return true;
		} else {
			return false;
		}
	}
}
