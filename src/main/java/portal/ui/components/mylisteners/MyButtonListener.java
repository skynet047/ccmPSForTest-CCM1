package portal.ui.components.mylisteners;

import portal.ui.components.mycomponents.MyButton;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;


//this is listener for all buttons, old TODO delete this class


public class MyButtonListener implements Button.ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void buttonClick(ClickEvent event) {
		String actionCommand = getActionCommand(event);

		//TODO
//		System.out.println(actionCommand);
		
		doButtonCommands(actionCommand);

	}

	public String getActionCommand(ClickEvent event){
		return ((MyButton) event.getComponent()).getActionCommand();
	}
	
	private void doButtonCommands(String actionCommand){
/*		
		switch (actionCommand){
		
		//TODO 
		default: System.out.println("nie wiem co zrobic");
		}
*/
	}
}
