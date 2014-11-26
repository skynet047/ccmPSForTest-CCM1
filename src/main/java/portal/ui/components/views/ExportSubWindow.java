package portal.ui.components.views;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.AbstractSelect.MultiSelectMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ChameleonTheme;

public class ExportSubWindow extends Window {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String exportCaption = "Export Contacts";
	
	private VerticalLayout mainLayout = null;	
	private HorizontalLayout selectPanels = null;
	private Table productsTable = null;
	private Table therapiesTable = null;
	private Table diseasesTable = null;
	private Table medicalSpecTable = null;
	private Button exportButton = null;
	
	private final short TABLE_WIDTH = 200;
	private final short TABLE_HEIGHT = 300;
	
	public ExportSubWindow(float witdh, float height) {
		setTheme("mytheme");
		setWidth(witdh, Sizeable.UNITS_PIXELS);
		setHeight(height, Sizeable.UNITS_PIXELS);
		getContent().setSizeFull();
		setResizable(true);
		mainLayout = new VerticalLayout();
		setContent(mainLayout);
		
		prepareExportChooseWindow();
		selectPanels = new HorizontalLayout();
		selectPanels.setSizeFull();
		addToMainLayout(selectPanels);
		addPanels();
		addExportButton();
	}

	public void prepareExportChooseWindow(){
		setCaption(exportCaption);
		Label test = new Label("Choose export criteries...");
		test.setStyleName("test");
		addToMainLayout(test);	
		
	}
	
	public void addToMainLayout(Component c){
		mainLayout.addComponent(c);
		mainLayout.setComponentAlignment(c, Alignment.MIDDLE_CENTER);
	}

	public VerticalLayout getMainLayout() {
		return mainLayout;
	}

	public void setMainLayout(VerticalLayout mainLayout) {
		this.mainLayout = mainLayout;
	}

	private void addToSelectPanels(Table table){
		selectPanels.addComponent(table);
		selectPanels.setComponentAlignment(table, Alignment.MIDDLE_CENTER);
	}
	
	public void addPanels(){
		createSelectThreapiesPanel();
		addToSelectPanels(therapiesTable);
	/*
		// Shows feedback from selection.
		final Label current = new Label("Selected: -");

		// Handle selection change.
		therapiesTable.addListener(new Property.ValueChangeListener() {
		    public void valueChange(ValueChangeEvent event) {
		        current.setValue("Selected: " + therapiesTable.getValue());
		    }
		});
		mainLayout.addComponent(current);
	*/
		
		createSelectProductsPanel();
		addToSelectPanels(productsTable);
		
		createSelectDiseasePanel();
		addToSelectPanels(diseasesTable);
		
		createSelectmedicalSpecPanel();
		addToSelectPanels(medicalSpecTable);
	}
	
	private void createSelectThreapiesPanel() {
		therapiesTable = new Table("Wybierz terapie");
		adjustTable(therapiesTable, TABLE_WIDTH, TABLE_HEIGHT);
		therapiesTable.addContainerProperty("Terapie", String.class, null);
		addTherapiesValues();
	}
	
	public void addTherapiesValues() {
		// TODO Auto-generated method stub
		therapiesTable.addItem(new Object[]{"zapobieganie nadzisnienia"}, new Integer(1));
		therapiesTable.addItem(new Object[]{"leczenie nadcisnienia"}, new Integer(2));
		therapiesTable.addItem(new Object[]{"wzmocnienie odporności"}, new Integer(3));
		therapiesTable.addItem(new Object[]{"leczenie grypy i przeziębienia"}, new Integer(4));
	}
	
	private void createSelectProductsPanel(){
		productsTable = new Table("Wybierz produkty");
		adjustTable(productsTable, 140, TABLE_HEIGHT);
		productsTable.addContainerProperty("Produkty", String.class, null);
		addProductsValues();
	}
	
	public void addProductsValues(){
		//TODO
		productsTable.addItem(new Object[]{"Nospa"}, new Integer(1));
		productsTable.addItem(new Object[]{"Modafen"}, new Integer(2));
		productsTable.addItem(new Object[]{"Clexane"}, new Integer(3));
		productsTable.addItem(new Object[]{"Iwostin"}, new Integer(4));
	}

	//add table to select panels
	private void createSelectDiseasePanel() {
		diseasesTable = new Table("Wybierz schorzenia");
		adjustTable(diseasesTable, 140, TABLE_HEIGHT);
		diseasesTable.addContainerProperty("Schorzenia", String.class, null);
		addDiseasesValue();
	}

	public void addDiseasesValue() {
		// TODO Auto-generated method stub
		
	}

	private void createSelectmedicalSpecPanel() {
		medicalSpecTable = new Table("Wybierz specjalizacje");
		adjustTable(medicalSpecTable, TABLE_WIDTH, TABLE_HEIGHT);
		medicalSpecTable.addContainerProperty("Specjalizacje", String.class, null);
		addMedicalSpecValues();
	}

	public void addMedicalSpecValues() {
		// TODO Auto-generated method stub
		
	}
	
	//universal method that can be use to adjust table
	private void adjustTable(Table table, float width, float height){
		table.setImmediate(true);
		table.setSelectable(true);
		table.setMultiSelect(true);
		table.setMultiSelectMode(MultiSelectMode.SIMPLE);
		table.setWidth(width, Sizeable.UNITS_PIXELS);
		table.setHeight(height, Sizeable.UNITS_PIXELS);
	}

	private void addExportButton(){
		exportButton = new Button("Export Contacts");
		exportButton.setStyleName(ChameleonTheme.BUTTON_WIDE);
		exportButton.addStyleName("testbutton");
		exportButton.setHtmlContentAllowed(true);
		mainLayout.addComponent(exportButton);
		mainLayout.setComponentAlignment(exportButton, Alignment.MIDDLE_RIGHT);
	}
	
	public void addButtonListener(Button.ClickListener buttonClickListener){
		exportButton.addListener(buttonClickListener);
	}

	public Button getExportButton() {
		return exportButton;
	}

	public void setExportButton(Button exportButton) {
		this.exportButton = exportButton;
	}
}
