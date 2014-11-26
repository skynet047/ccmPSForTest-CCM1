package portal.db.facade;

import java.util.List;

import model.Consumer;
import model.exception.DaoException;

public interface ConsumerFacade extends ISession{
	public List<Consumer> loadAll() throws DaoException;
	public long addConsumer(Consumer consumer) throws DaoException;
	public long loadMaxId() throws DaoException;
}
