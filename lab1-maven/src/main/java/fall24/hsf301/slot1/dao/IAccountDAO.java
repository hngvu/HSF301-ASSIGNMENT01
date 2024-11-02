package fall24.hsf301.slot1.dao;

import fall24.hsf301.slot1.pojo.Account;

public interface IAccountDAO {
	Account findByUserName(String userName);
}
