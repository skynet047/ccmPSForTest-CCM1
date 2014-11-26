package dao;

import model.exception.DaoException;
import portal.db.facade.impl.ConsumerFacadeImpl;
import portal.ui.components.container.ConsumerModel;



public class TestMapper {

	
	public static void main(String[] args){

		
		ConsumerFacadeImpl consumerFacade = new ConsumerFacadeImpl();
		consumerFacade.openSession();
		try {
			ConsumerModel model = new ConsumerModel(consumerFacade.loadAll());
			System.out.println(model.getContainer());
		} catch (DaoException e) {
			e.printStackTrace();
		}finally{
			consumerFacade.close();
		}	
	}
	
}
