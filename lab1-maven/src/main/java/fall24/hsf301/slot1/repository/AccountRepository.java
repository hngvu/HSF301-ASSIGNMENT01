package fall24.hsf301.slot1.repository;

import fall24.hsf301.slot1.dao.AccountDAO;
import fall24.hsf301.slot1.dao.IAccountDAO;
import fall24.hsf301.slot1.pojo.Account;

public class AccountRepository implements IAccountRepository {
	private IAccountDAO accountDAO;
	
	public AccountRepository(String fileConfig) {
		accountDAO = new AccountDAO(fileConfig);
	}
	@Override
	public Account findByUserName(String userName) {
		return accountDAO.findByUserName(userName);
	}
	
}
