package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	private WebDriver driver;
	private OrangeHRMPageObject orangeHRMPageObject;
	private UsersPageObject userPageObject;
	private JobPageObject jobPageObject;
	private Guru99PageObject guru99PageObject;
	private FileUploadPageObject fileUploadPageObject;
	private FrameHandlePageObject frameHandlePageObject;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public OrangeHRMPageObject getOrangeHRMPage() {
		return (orangeHRMPageObject == null) ? orangeHRMPageObject = new OrangeHRMPageObject(driver) : orangeHRMPageObject;
	}
	
	public UsersPageObject getUserPageObject() {
		return (userPageObject == null) ? userPageObject = new UsersPageObject(driver) : userPageObject ;
	}
	
	public JobPageObject getJobPageObject() {
		return (jobPageObject == null) ? jobPageObject = new JobPageObject(driver) : jobPageObject ;
	}
	
	public Guru99PageObject getGuru99PageObject() {
		return (guru99PageObject == null) ? guru99PageObject = new Guru99PageObject(driver) : guru99PageObject;
	}
	
	public FileUploadPageObject getFileUploadPageObject() {
		return (fileUploadPageObject == null) ? fileUploadPageObject = new FileUploadPageObject(driver) : fileUploadPageObject ;
	}
	
	public FrameHandlePageObject getFrameHandlePageObject() {
		return (frameHandlePageObject == null) ? frameHandlePageObject = new FrameHandlePageObject(driver) : frameHandlePageObject;
	}
}
