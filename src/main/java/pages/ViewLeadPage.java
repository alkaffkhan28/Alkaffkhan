package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers{
	
	public ViewLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not ViewLead Page", "FAIL");
		}
		
	}
	
	public ViewLeadPage verifyCompanyName(String companyName){
		verifyTextContainsById(prop.getProperty("ViewLead.VerifyCompanyName.Id"), companyName);
		return this;
	}
	
	public EditLeadPage clickEditLink(){
		clickByLink(prop.getProperty("ViewLead.EdidLink.Link"));
		return new EditLeadPage(driver,test);
	}
	
	public DuplicateLeadPage clickDuplicateLink(){
		clickByLink(prop.getProperty("ViewLead.DuplicateLink.Link"));
		return new DuplicateLeadPage(driver, test);
	}
	
	public ViewLeadPage verifyFirstName(String firstName){
		verifyTextById(prop.getProperty("ViewLead.VerifyFirstName.Id"), firstName);
		return this;
	}
	
	public MyLeadsPage clickDeleteLink(){
		clickByLink(prop.getProperty("ViewLead.DeleteLeadLink.link"));
		return new MyLeadsPage(driver, test);
	}
	
	public FindLeadsPage clickFindLeadLink(){
		clickByLink(prop.getProperty("ViewLead.FindLeadLink.link"));
		return new FindLeadsPage(driver, test);
	}
	
	public String returnLeadID(String id)
	{
		String leadID=null;
		try {
			
			String text = driver.findElementById(id).getText();
			Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(text);
			while(m.find()) {
				leadID = m.group(1);    
			}
			
		} catch (NoSuchElementException e) {
			System.err.println("Focus is not in the last window using ");
			throw new RuntimeException("The element with "+id+" is not presentt");
		} catch (WebDriverException e) {
			System.err.println("Unfortunately browser is closed");
			throw new RuntimeException("Stop the script because the browser is closed");
		}finally {
			takeSnap();
		}
		return leadID;
	}

}
