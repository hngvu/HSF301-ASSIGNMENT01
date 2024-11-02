package fall24.hsf301.slot1.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import fall24.hsf301.slot1.pojo.Account;

public class AccountDAO implements IAccountDAO {
	private SessionFactory sessionFactory = null;
	private Configuration cfg = null;

	public AccountDAO(String hibernateConfig) {
		cfg = new Configuration().configure(hibernateConfig);
		sessionFactory = cfg.buildSessionFactory();
	}

	@Override
	public Account findByUserName(String userName) {
		Session session = sessionFactory.openSession();
		try {
			return session.find(Account.class, userName);
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
}
