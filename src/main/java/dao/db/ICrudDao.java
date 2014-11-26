package dao.db;

import java.util.List;

import model.exception.DaoException;

public interface ICrudDao {
	public List<?> loadAll() throws DaoException;
	public long loadMaxId() throws DaoException;
}
