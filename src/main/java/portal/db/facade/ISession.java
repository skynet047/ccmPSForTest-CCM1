package portal.db.facade;

public interface ISession {
	public void openSession();
	public void closeSession();
	public void close();
	public void commitSession();
	public void rollbackSession();
}
