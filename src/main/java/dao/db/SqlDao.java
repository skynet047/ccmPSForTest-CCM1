package dao.db;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

@SuppressWarnings("deprecation")
public class SqlDao {

	protected static SessionFactory sessionFactory;
	protected static Logger log = Logger.getLogger(SqlDao.class);
	
	static{
		log.info("Loading configuration");
		init();
	}
	
	private static void init(){
		log.info("Loading resources");
		try{
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}catch(Exception e){
			log.error("Błąd przy ustanawianiu połączenia z bazą danych");
			System.exit(1);
		}
	}
}
