package dao.db.impl;

import java.util.List;

import model.Consumer;
import model.exception.DaoException;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.db.ISqlDao;
import dao.db.SqlDao;
import dao.db.facade.ConsumerDao;

public class ConsumerDaoImpl extends SqlDao implements ISqlDao, ConsumerDao{

	protected Session session;
	
	public List<Consumer> loadAll() throws DaoException {
		Query query = session.createQuery("from Consumer");
		List<Consumer> list = query.list();
		return list;
	}

	public long addConsumer(Consumer consumer) throws DaoException {
		return 0;
	}
	
	public long loadMaxId() throws DaoException {
		return 0;
	}
	
	public void openSession() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public void close() {
		sessionFactory.close();
	}

	public void closeSession() {
		session.close();
	}
	public void commit() {
		session.getTransaction().commit();
	}

	public void rollback() {
		session.getTransaction().rollback();
	}
}
