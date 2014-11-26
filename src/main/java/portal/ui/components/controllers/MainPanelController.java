package portal.ui.components.controllers;

import static java.lang.System.out;

import java.io.Serializable;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

import portal.ui.components.mycomponents.MyButton;
import portal.ui.components.views.MainPanel;

public class MainPanelController implements Serializable {
	
	 /**
	 * 
	 */
	//MainWindow Controller
	private static final long serialVersionUID = 1L;

	MainController guiManager = null;
	MainPanel mainPanel = null;
	
	public MainPanelController(MainController guiManager, MainPanel mainPanel) {
		setGuiManager(guiManager);
		setMainPanel(mainPanel);
		mainPanel.setButtonClickListener(new MainWindowButtonListener());
	}


	public void setGuiManager(MainController guiManager) {
		this.guiManager = guiManager;
	}
	
	public void setMainPanel(MainPanel mainPanel){
		this.mainPanel = mainPanel;
	}

	public void mainWindowExportButton() {
		// TODO Auto-generated method stub
		out.println("exportButtonClicked");
		guiManager.openExportWindow();
	}
	
	public void mainWindowImportButton() {
		//TODO
		out.println("import button clicked");
		guiManager.openImportWindow();
	}

	public void mainWindowBrowseButton() {
		// TODO Auto-generated method stub
		out.println("browseButtonClicked");
		guiManager.openBrowseWindow();
	}

	public void mainWindowCustomizeButton() {
		// TODO Auto-generated method stub
		out.println("customize buuton clicked");
		guiManager.openCustomizeWindow();
	}


	public void mainWindowAdvancedSettingsButton() {
		// TODO Auto-generated method stub
		out.println("advancedSettings button clicked");
		guiManager.openAdvancedSettingsWindow();
	}
	
	class MainWindowButtonListener implements Button.ClickListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			MyButton clickedButton = (MyButton) event.getButton();
			if (clickedButton == mainPanel.getExportButton()){
				mainWindowExportButton();
			}
			else if (clickedButton == mainPanel.getImportButton()){
				mainWindowImportButton();
			}
			else if (clickedButton == mainPanel.getBrowseButton()){
				mainWindowBrowseButton();
			}
		}
		
	}
}
