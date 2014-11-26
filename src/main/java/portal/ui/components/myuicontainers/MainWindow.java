package portal.ui.components.myuicontainers;

import portal.ui.components.views.MainPanel;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class MainWindow extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7993420094610341018L;
	private BackgroundLayout backgroundLayout = null;
	private MainPanel mainPanel = null;

	public MainWindow(String title){
		super(title);
		setTheme("mytheme");
		getContent().setSizeFull();
		setResizable(true);
		backgroundLayout = new BackgroundLayout();
		addComponent(backgroundLayout);		
	}
	
	
	public BackgroundLayout getBacgroundLayout(){
		return backgroundLayout;
	}
	
	public void addMainPanel(MainPanel mainPanel){
		this.mainPanel = mainPanel;
		backgroundLayout.addComponent(mainPanel);
		backgroundLayout.setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
	}
	
	
	public void addToBackgroundLayout(Component c){
		backgroundLayout.addComponent(c);
	}
	
	public void addToMainPanel(Component c){
		mainPanel.addComponent(c);
	}
	
	
}
