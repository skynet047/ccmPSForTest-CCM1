package portal.ui.components.controllers;

import portal.ui.components.views.ExportSubWindow;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class ExportWindowController {
	
	ExportSubWindow exportView = null;
	Object model = null;

	public ExportWindowController(ExportSubWindow exportView, Object model) {
		this.exportView = exportView;
		this.model = model;
		this.exportView.addButtonListener(new ExportButtonListener());
	}
	
	class ExportButtonListener implements Button.ClickListener{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			Button button = event.getButton();
			if (button == exportView.getExportButton()){
				openExportDiallog();
				System.out.println("Openning export diallog");
			}
			
		}

		private void openExportDiallog() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
