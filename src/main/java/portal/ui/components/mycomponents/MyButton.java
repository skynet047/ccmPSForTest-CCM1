package portal.ui.components.mycomponents;

import portal.ui.components.mylisteners.MyButtonListener;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.NativeButton;

//you have two ways to handle actions:
	//- using MyButtonListener and actions commands
	//- or using Click Listeners in buttons containers


//MyButton class create button with actionCommand, which can be use like it is jse gwt.
//MyButtonListener will handle this actionCommand and work trough.

//


public class MyButton extends NativeButton{
	
	//TODO find and change prepareMyButton method
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String actionCommand = "";
	private float defaultHeight = 100;
	
	public MyButton(){
		super();
		setHtmlContentAllowed(true);
	}
	
	public MyButton(String actionCommand){
		super();
		prepareMyButton(actionCommand);
	}
	
	public MyButton(String actionCommand, MyButtonListener clickListener){
		super();
		prepareMyButton(actionCommand, defaultHeight);
		addListener(clickListener);
	}
	
	public MyButton(String actionCommand, MyButtonListener clickListener, float height){
		super();
		prepareMyButton(actionCommand, height);
		addListener(clickListener);
	}
	
	private void prepareMyButton(String actionCommand, float height){
		// TODO  setCaption below is used only for test, so have to delete it later
		setCaption(actionCommand);
		
		setActionCommand(actionCommand);
		setHeight(height, Sizeable.UNITS_PIXELS);
		setHtmlContentAllowed(true);
	}
	

	private void prepareMyButton(String actionCommand){
		// TODO  setCaption below is used only for test, so have to delete it later
		setCaption(actionCommand);	
		setActionCommand(actionCommand);
		setHtmlContentAllowed(true);
	}
	
	//TODO useless override, it can be deleted
	@Override
	public String toString(){
		return getActionCommand();
	}

	public String getActionCommand() {
		return actionCommand;
	}

	public void setActionCommand(String actionCommand) {
		this.actionCommand = actionCommand;
	}

	public float getDefaultHeight() {
		return defaultHeight;
	}

	public void setDefaultHeight(float defaultHeight) {
		this.defaultHeight = defaultHeight;
	}

}
