package portal.ui.components.container;

import java.util.List;

import model.Consumer;

import com.vaadin.data.util.BeanItemContainer;

public class ConsumerModel {

	private BeanItemContainer<Consumer> container;
	
	public ConsumerModel(List<Consumer> consumerList){
		container = new BeanItemContainer<Consumer>(Consumer.class);
		container.addAll(consumerList);
	}
	
	public BeanItemContainer<Consumer> getContainer(){
		return container;
	}
}
