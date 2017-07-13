package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers{
	
	public CreateLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not CreateLead Page", "FAIL");
		}
	}
	
	public CreateLeadPage enterCompanyName(String companyName){
		enterById(prop.getProperty("CreateLead.CompanyName.Id"), companyName);
		return this;
	}
	
	public CreateLeadPage enterFirstName(String FirstName){
		enterById(prop.getProperty("CreateLead.FirstName.Id"), FirstName);
		return this;
	}
	
	public CreateLeadPage enterlastName(String lastName){
		enterById(prop.getProperty("CreateLead.LastName.Id"), lastName);
		return this;
	}
	
	public CreateLeadPage enterPhoneNumber(String phone){
		enterById(prop.getProperty("CreateLead.PhoneNumber.Id"), phone);
		return this;
	}
	
	public CreateLeadPage enterEmail(String email){
		enterById(prop.getProperty("CreateLead.Email.Id"), email);
		return this;
	}
	
	public ViewLeadPage clickCreateLeadButton(){
		clickByClassName(prop.getProperty("CreateLead.CreateLeadButton.Id"));
		return new ViewLeadPage(driver,test);
	}

}
