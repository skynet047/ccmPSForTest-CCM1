package portal.ui.components;

import portal.ui.components.controllers.MainController;

import com.vaadin.Application;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Window;

public class CcmMain extends Application {

	
	
	/**
	 * application main class
	 */
	private static final long serialVersionUID = 1L;
	//HEADER TITLE
	private final String TITLE = "Clients Contacts Manager";
	private final String MYTHEME ="mytheme";
	private MainController guiManager = null;
	
	@Override
	public void init() {
	
		createAndStartGUI();
//		String absolutePath = getContext().getBaseDirectory().getAbsolutePath();
//		System.out.println(absolutePath); 
//		
	}


	private void createAndStartGUI() {
		setTheme(MYTHEME);
		setGuiManager(new MainController(this, TITLE, MYTHEME));
	}


	public void setGuiManager(MainController guiManager) {
		this.guiManager = guiManager;
	}

}
