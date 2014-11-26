package dao.db.facade;

import model.Consumer;
import model.exception.DaoException;
import dao.db.ICrudDao;

public interface ConsumerDao extends ICrudDao{

	public long addConsumer(Consumer consumer) throws DaoException;
}
