package portal.ui.components.mycomponents;

import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Embedded;

public class Picture extends Embedded{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path = "img/";
	private String imgName = "";
	private ThemeResource resource = null;
	
	public Picture(String imgName){
		super();
		createThemeResource(imgName);
		setSource(resource);
		setType(TYPE_IMAGE);
		setStyleName("picture");
	}

	private void createThemeResource(String imgName){
		setImgName(imgName);
		setResource(new ThemeResource(path + this.imgName));
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public ThemeResource getResource() {
		return resource;
	}

	public void setResource(ThemeResource resource) {
		this.resource = resource;
	}
}
