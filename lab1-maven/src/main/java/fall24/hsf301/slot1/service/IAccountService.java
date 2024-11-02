package fall24.hsf301.slot1.service;

import fall24.hsf301.slot1.pojo.Account;

public interface IAccountService {
	Account findByUserName(String userName);
}
