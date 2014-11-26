package portal.ui.components.views;

import portal.ui.components.mycomponents.MyButton;
import portal.ui.components.mycomponents.Picture;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class MainPanel extends Panel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VerticalLayout panelVerticalLayout = null;
	
	private HorizontalLayout topButtonsLine = null;
	private HorizontalLayout bottomButtonsLine = null;
	
	private Button.ClickListener ButtonClickListener = null;
	
	private float width = 500;
	private float height = 400;
	
	private float buttoLineHeight = 80;
	
	
	//top buttons
	private MyButton exportButton = null;
	private MyButton importButton = null;
	private MyButton browseButton = null;
	
	private String exportButtonCaption = "<html>Export<br />contacts</html>";
	private String exportButtonDescription = "<html>Export contacts from database</html>";
	
	private String importButtonCaption = "<html>Import<br />contacts</html>";
	private String importButtonDescrioption = "<html>Add new contacts to database</html>";
	
	private String browseButtonCaption = "<html>Browse<br />contacts</html>";
	private String browseButtonDescription = "<html>Browse contacts,<br />delete, modify selected contacts</html>";
	
	//bottom buttons
	private MyButton customizeButton = null;
	private MyButton advancedSettingsButton = null;
	
	private String customizeButtonCaption = "<html>Customize<br />database relations</html>";
	private String customizeButtonDescrition = "<html>Custemize relations:<br />therapies - producs - diseases<br /> - medical specialization</html>";
	
	private String advancedSettingsButtonCaption = "<html>Advanced<br />settings</html>";
	private String advancedSettingsButtonDescription = "<html>Advanced settings:<br />add or remove user</html>";
	
	
	private Picture title = null;
	private Picture logo = null;
	
	
	{
		title = new Picture("text.png");
		logo = new Picture("LOGO.png");
	}
	
	public MainPanel(){
		super();
	}
	
	public MainPanel(float w, float h){
		setWidth(w);
		setHeight(h);
	}
	
	public void setButtonClickListener(
			Button.ClickListener buttonClickListener) {
		this.ButtonClickListener = buttonClickListener;
	}
	
	public void prepareMainPanel(){
		setWidth(width, UNITS_PIXELS);
		setHeight(height, UNITS_PIXELS);
		createPanelVerticalLayout();
		setContent(panelVerticalLayout);
		
		createAllButtons();
		
		//adding top buttons
		preapareTopButtonsLine();
		addComponent(topButtonsLine);
		
		
		//aplication title 
		addComponent(title);
		panelVerticalLayout.setComponentAlignment(title, Alignment.MIDDLE_CENTER);
		 
		//logo
		addComponent(logo);
		panelVerticalLayout.setComponentAlignment(logo, Alignment.MIDDLE_CENTER);
		
		//bottonButtons
		preapareBottomButtonsLine();
		addComponent(bottomButtonsLine);
	}
	
	private void adjustWidth(float parentWidth, HorizontalLayout buttonsLine){
		buttonsLine.setWidth((float) (parentWidth*0.8), Sizeable.UNITS_PIXELS);
	}
	
	private void preapareTopButtonsLine(){
		topButtonsLine = new HorizontalLayout();
		topButtonsLine.setHeight(buttoLineHeight, Sizeable.UNITS_PIXELS);
		adjustWidth(width, topButtonsLine);
		addTopButtonsLine();
	}
	
	private void preapareBottomButtonsLine(){
		bottomButtonsLine = new HorizontalLayout();
		bottomButtonsLine.setHeight(buttoLineHeight, Sizeable.UNITS_PIXELS);
		adjustWidth(width, bottomButtonsLine);
		addToBottomButtonsLine();
	}
	
	private void createPanelVerticalLayout(){
		panelVerticalLayout = new VerticalLayout();
	}
	
	//Override addComponet method, so you can add to main vertical layout only.
	@Override
	public void addComponent(Component c){
		panelVerticalLayout.addComponent(c);
		panelVerticalLayout.setComponentAlignment(c, Alignment.MIDDLE_CENTER);
	}

	private void addTopButtonsLine() {
		addMyButton(exportButton, topButtonsLine);
		addMyButton(importButton, topButtonsLine);
		addMyButton(browseButton, topButtonsLine);
	}
	
	private void addToBottomButtonsLine() {
		addMyButton(customizeButton, bottomButtonsLine);
		addMyButton(advancedSettingsButton, bottomButtonsLine);	
	}
	
	private MyButton createMyButton(){
		MyButton button = new MyButton();
		button.addListener(ButtonClickListener);
		return button;
	}
	
	private void addMyButton(MyButton myButton, HorizontalLayout buttonsLine){
		buttonsLine.addComponent(myButton);
		buttonsLine.setComponentAlignment(myButton, Alignment.MIDDLE_CENTER);
	}

	private void createAllButtons(){
		exportButton = createMyButton();
		exportButton.setCaption(exportButtonCaption);
		exportButton.setDescription(exportButtonDescription);
		
		importButton = createMyButton();
		importButton.setCaption(importButtonCaption);
		importButton.setDescription(importButtonDescrioption);
		
		browseButton = createMyButton();
		browseButton.setCaption(browseButtonCaption);
		browseButton.setDescription(browseButtonDescription);
		
		customizeButton = createMyButton();
		customizeButton.setCaption(customizeButtonCaption);
		customizeButton.setDescription(customizeButtonDescrition);
		
		advancedSettingsButton = createMyButton();
		advancedSettingsButton.setCaption(advancedSettingsButtonCaption);
		advancedSettingsButton.setDescription(advancedSettingsButtonDescription);
	}
	
	
	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}
	

	
	// public methods to get each button
	public MyButton getExportButton() {
		return exportButton;
	}

	public MyButton getImportButton() {
		return importButton;
	}

	public MyButton getBrowseButton() {
		return browseButton;
	}
}
