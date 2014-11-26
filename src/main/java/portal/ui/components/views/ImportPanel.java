package portal.ui.components.views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Consumer;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedListener;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.StartedListener;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

public class ImportPanel extends Panel implements  ValueChangeListener,
		Receiver, SucceededListener, FailedListener, StartedListener {

	private BufferedReader br = null;
	private VerticalLayout verticalLayout, middleLayout;
	private HorizontalLayout topLayout;
	private Upload upload;
	private File file = null;
	private Map<String,Integer> map;
	private ComboBox nameCombo, surnameCombo, mailCombo, sexCombo,
						companyCombo, typeCombo, phoneCombo, commentCombo;
	private List<ComboBox> listCombo;
	private List<String> columnNames;
	private Button loadButton;
	
	public ImportPanel() {
		verticalLayout = new VerticalLayout();
		setContent(verticalLayout);
		setSizeFull();
		verticalLayout.setSizeFull();
		
		topLayout = new HorizontalLayout();
		topLayout.setWidth("100%");
		prepareContent();
		upload = new Upload();
		upload.setButtonCaption("Mapuj");
		upload.addListener((Upload.SucceededListener) this);
		upload.addListener((Upload.FailedListener) this);
		upload.addListener((Upload.StartedListener) this);
		upload.setReceiver(this);
		upload.setSizeFull();
		topLayout.addComponent(upload);
	
		verticalLayout.addComponent(topLayout);
		verticalLayout.addComponent(middleLayout);
	}

	public OutputStream receiveUpload(String filename, String MIMEType) {
		System.out.println("________________ RECEIVED UPLOAD");
		FileOutputStream fos = null;
		file = new File(filename);
		try {
			fos = new FileOutputStream(file);
		} catch (final java.io.FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return fos;
	}

	public void uploadSucceeded(Upload.SucceededEvent event) {
		System.out.println("________________ UPLOAD SUCCEEDED");
		formatData();
	}

	public void uploadFailed(Upload.FailedEvent event) {
		System.out.println("________________ UPLOAD FAILED");
	}

	public void uploadStarted(StartedEvent event) {
		System.out.println("________________ UPLOAD STARTET");
	}

	private void formatData() {
		columnNames = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			line = br.readLine();
			List<String> tmp = Arrays.asList(line.split(";"));
			for(int i = 0; i < tmp.size(); i++){
				if(!tmp.get(i).equals("")){
					columnNames.add(tmp.get(i));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ComboBox comboBox = null;
		for(int i = 0; i < listCombo.size(); i++){
			comboBox = listCombo.get(i);
			comboBox.removeListener(this);
			comboBox.setEnabled(true);
			comboBox.removeAllItems();
			comboBox.addItem("");
			for(int j = 0; j < columnNames.size(); j++){
				comboBox.addItem(columnNames.get(j));
			}
			if(i >= columnNames.size()){
				comboBox.select("");
			}else if(listCombo.size() < i){
				continue;
			}else{
				comboBox.select(columnNames.get(i));
			}
			comboBox.addListener(this);
		}
	}
	private void checkComboList(String caption, String value){
		for(ComboBox comboBox:listCombo){
			if(comboBox.getValue().equals(value) && !comboBox.getCaption().equals(caption)){
				comboBox.select("");
			}
		}
	}
	private void loadData(){
		BufferedReader br = null;
		String[] columnValues;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			Consumer consumer;
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				columnValues = line.split(";");
				consumer = prepareConsumer(columnValues);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Consumer prepareConsumer(String[] columnValues){
		Consumer consumer = new Consumer();
//		consumer.setFirstName(columnValues[map.get(ImportUtil.NAME)]);
//		consumer.setLastName(columnValues[map.get(ImportUtil.SURNAME)]);
//		consumer.setMail(columnValues[map.get(ImportUtil.MAIL)]);
//		consumer.setSex(columnValues[map.get(ImportUtil.SEX)]);
//		//consumer.setCompany(columnValues[map.get(ImportUtil.COMPANY)]);
//		consumer.setUserType(columnValues[map.get(ImportUtil.TYPE)]);
//		consumer.setPhoneNumber(columnValues[map.get(ImportUtil.PHONE)]);
//		consumer.setComment(columnValues[map.get(ImportUtil.COMMENT)]);
		return consumer;
	}
	
	private void modifyMap(){
		//wartość z comboboxa
		int k = map.get("IMIE");
		map.remove("IMIE");
		map.put(nameCombo.getCaption(), k);
	}
	
	private void prepareContent(){
		
		listCombo = new ArrayList<ComboBox>();
		
		nameCombo = new ComboBox("Imie");
		nameCombo.setEnabled(false);
		nameCombo.setImmediate(true);
		nameCombo.setNullSelectionAllowed(false);
		nameCombo.setTextInputAllowed(false);
		
		surnameCombo = new ComboBox("Nazwisko");
		surnameCombo.setEnabled(false);
		surnameCombo.setImmediate(true);
		surnameCombo.setNullSelectionAllowed(false);
		
		sexCombo = new ComboBox("Płeć");
		sexCombo.setEnabled(false);
		sexCombo.setImmediate(true);
		sexCombo.setNullSelectionAllowed(false);
		
		mailCombo = new ComboBox("Mail");
		mailCombo.setEnabled(false);
		mailCombo.setImmediate(true);
		mailCombo.setNullSelectionAllowed(false);
		
		typeCombo = new ComboBox("Typ");
		typeCombo.setEnabled(false);
		typeCombo.setImmediate(true);
		typeCombo.setNullSelectionAllowed(false);
		
		phoneCombo = new ComboBox("Telefon");
		phoneCombo.setEnabled(false);
		phoneCombo.setImmediate(true);
		phoneCombo.setNullSelectionAllowed(false);
		
		commentCombo = new ComboBox("Komentarz");
		commentCombo.setEnabled(false);
		commentCombo.setImmediate(true);
		commentCombo.setNullSelectionAllowed(false);
		
		listCombo.add(nameCombo);
		listCombo.add(surnameCombo);
		listCombo.add(sexCombo);
		listCombo.add(mailCombo);
		//listCombo.add(companyCombo = new ComboBox("Firma"));
		listCombo.add(typeCombo);
		listCombo.add(phoneCombo);
		listCombo.add(commentCombo);
	
		FormLayout fl = new FormLayout();
		fl.addComponent(nameCombo);
		fl.addComponent(surnameCombo);
		fl.addComponent(mailCombo);
		fl.addComponent(sexCombo);
		fl.addComponent(typeCombo);
		fl.addComponent(phoneCombo);
		fl.addComponent(commentCombo);
		
		loadButton = new Button("Ładunek");
		loadButton.addStyleName("loadButton");
		
		middleLayout = new VerticalLayout();
		middleLayout.setSizeFull();
		
		HorizontalLayout s = new HorizontalLayout();
		s.setSizeFull();
		s.addComponent(loadButton);
		s.setComponentAlignment(loadButton, Alignment.MIDDLE_RIGHT);
		
		middleLayout.addComponent(fl);	
		middleLayout.addComponent(s);
	}
	public void valueChange(ValueChangeEvent event) {
		checkComboList(((ComboBox)event.getProperty()).getCaption(),
		(String) event.getProperty().getValue());
	}
	
}
