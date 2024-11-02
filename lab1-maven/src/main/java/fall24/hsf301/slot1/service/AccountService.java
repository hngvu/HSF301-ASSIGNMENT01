package fall24.hsf301.slot1.service;

import fall24.hsf301.slot1.pojo.Account;
import fall24.hsf301.slot1.repository.AccountRepository;
import fall24.hsf301.slot1.repository.IAccountRepository;

public class AccountService implements IAccountService {
	private IAccountRepository accountRepo;

	public AccountService(String fileConfig) {
		accountRepo = new AccountRepository(fileConfig);
	}

	@Override
	public Account findByUserName(String userName) {
		return accountRepo.findByUserName(userName);
	}
}
