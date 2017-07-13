package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadsPage extends LeafTapsWrappers{

	public FindLeadsPage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;

		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is not Find Lead Page", "FAIL");
		}

	}

	public FindLeadsPage enterFirstName(String name){
		enterByXpath(prop.getProperty("FindLeads.FirstName.Xpath"), name);
		return this;

	}

	public FindLeadsPage enterLeadId(String name){
		enterByXpath(prop.getProperty("FindLeads.LeadId.Xpath"), name);
		return this;
	}

	public FindLeadsPage clickFindLeadButton(){
		clickByXpath(prop.getProperty("FindLeads.FindLeadButton.Xpath"));
		return this;
	}

	public ViewLeadPage clickFirstResultName() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath(prop.getProperty("FindLeads.FirstResultName.Xpath"));
		return new ViewLeadPage(driver,test);
	}

	public String getFirstResultText() throws InterruptedException{
		Thread.sleep(2000);
		return getTextByXpath(prop.getProperty("FindLeads.FirstResultName.Xpath"));
	}

	public String getFirstResultId() throws InterruptedException{
		Thread.sleep(2000);
		return getTextByXpath(prop.getProperty("FindLeads.FirstResultName.Xpath"));
	}

	public FindLeadsPage clickEmailLink(){
		clickByLink(prop.getProperty("FindLeads.EmailLink.Link"));
		return this;
	}

	public FindLeadsPage enterEmail(String email){
		enterByName(prop.getProperty("FindLeads.Email.Name"), email);
		return this;
	}

	public FindLeadsPage clickPhoneLink(){
		clickByXpath(prop.getProperty("FindLeads.PhoneLink.Xpath"));
		return this;
	}

	public FindLeadsPage enterPhoneNumber(String phone){
		enterByXpath(prop.getProperty("FindLeads.PhoneNumber.Xpath"), phone);
		return this;
	}

	public FindLeadsPage verifyMessageText(String message){
		verifyTextByXpath(prop.getProperty("FindLeads.TextMessage.Xpath"), message);
		return this;

	}






}
