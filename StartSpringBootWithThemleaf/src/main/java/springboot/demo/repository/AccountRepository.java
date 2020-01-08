package springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
	Account findAccountByAccountName(String accountName);
	Account findAccountByAccountNameAndAccountPass(String accountName, String accountPass);
	
}
