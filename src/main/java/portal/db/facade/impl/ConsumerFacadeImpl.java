package portal.db.facade.impl;

import java.util.List;

import model.Consumer;
import model.exception.DaoException;
import portal.db.facade.ConsumerFacade;
import dao.db.impl.ConsumerDaoImpl;

public class ConsumerFacadeImpl implements ConsumerFacade{

	private static ConsumerDaoImpl dao;
	
	static{
		dao = new ConsumerDaoImpl();
	}

	public List<Consumer> loadAll() throws DaoException {
		return dao.loadAll();
	}

	public long addConsumer(Consumer consumer) throws DaoException {
		return dao.addConsumer(consumer);
	}

	public long loadMaxId() throws DaoException {
		return 0;
	}
	
	public void openSession() {
		dao.openSession();
	}

	public void closeSession() {
		dao.closeSession();
	}
	
	public void close() {
		dao.close();
	}
	public void commitSession() {
		dao.commit();
	}

	public void rollbackSession() {
		dao.rollback();
	}
}
