package portal.ui.components.controllers;

import static java.lang.System.out;

import java.io.Serializable;

import portal.ui.components.mycomponents.Picture;
import portal.ui.components.myuicontainers.MainWindow;
import portal.ui.components.views.ExportSubWindow;
import portal.ui.components.views.ImportPanel;
import portal.ui.components.views.MainPanel;

import com.vaadin.Application;
import com.vaadin.ui.Window;

public class MainController implements Serializable {
	
	/**
	 * 
	 */
	//this is main controller
	private static final long serialVersionUID = 1L;

	private final String TITLE = "Clients Contacts Manager";
	private final float PANEL_WITDH = 600;
	private final float PANEL_HEIGHT = 400;
	
	private String myTheme = "mytheme";
	
	private Picture title = null;
	private Picture logo = null;
	
	private Application app = null;
	private MainWindow mainWindow = null;
	
	private MainPanel mainPanel = null;
	private MainPanelController mainPanelController = null;
	
	private ExportSubWindow exportSubWindow = null;
	private ExportWindowController exportSubWindowController = null;
	
	private Window importWindow = null;
	
	{
		title = new Picture("text.png");
		logo = new Picture("SanofiLogo.png");
	}
	
	public MainController(Application application, String applicationTitle, String theme){
		setApp(application);
		createMainWindow(applicationTitle);
		createMainPanel();
		createGUI(theme);
	}
	
	private void createMainWindow(String applicationTitle) {
		mainWindow = new MainWindow(applicationTitle);
	}

	private void createMainPanel() {
		mainPanel = new MainPanel();
		mainPanelController = new MainPanelController(this, mainPanel);
		mainPanel.prepareMainPanel();
	}

	private void createGUI(String theme) {
		app.setTheme(myTheme);
		app.setMainWindow(mainWindow);
		mainWindow.addMainPanel(mainPanel);
	}


	public void openExportWindow() {
		// TODO Auto-generated method stub
		out.println("openning modal Window export");
		exportSubWindow = new ExportSubWindow(1000, 500);
		exportSubWindow.setModal(true);
		exportSubWindowController = new ExportWindowController(exportSubWindow, null);
		
		mainWindow.addWindow(exportSubWindow);
	}


	public void openImportWindow() {
		// TODO Auto-generated method stub
		importWindow = new Window();
		importWindow.removeAllComponents();
    	importWindow.setCaption("Import");
    	importWindow.setWidth("500px");
    	importWindow.setHeight("550px");
    	importWindow.center();
    	importWindow.setResizable(false);
    	importWindow.setModal(true);
    	getMainWindow().addWindow(importWindow);
    	importWindow.addComponent(new ImportPanel());
	}

	public void openBrowseWindow() {
		// TODO Auto-generated method stub
		out.println("openning modal browse Window");
	}


	public void openCustomizeWindow() {
		// TODO Auto-generated method stub
		out.println("openning modal customize Window");
	}


	public void openAdvancedSettingsWindow() {
		// TODO Auto-generated method stub
		out.println("openning modal advanced settings Window");
	}
	
	
	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public MainWindow getMainWindow() {
		return mainWindow;
	}

	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public String getMyTheme() {
		return myTheme;
	}
	
	public void setMyTheme(String myTheme) {
		this.myTheme = myTheme;
	}


	public String getTITLE() {
		return TITLE;
	}

}
