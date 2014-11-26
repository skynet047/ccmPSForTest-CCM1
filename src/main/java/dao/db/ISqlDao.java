package dao.db;

public interface ISqlDao {
	public void openSession();
	public void closeSession();
	public void close();
	public void commit();
	public void rollback();
}
