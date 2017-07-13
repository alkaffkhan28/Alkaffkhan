package testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ViewLeadPage;
import wrappers.LeafTapsWrappers;

public class TC_MergeLead extends LeafTapsWrappers{
	
	List<String> leadId = new ArrayList<String>();

	@BeforeClass
	public void setData() {
		testCaseName="Merge Lead";
		testDescription="Merge Lead test case";
		browserName="chrome";
		dataSheetName="mergelead";
		category="Smoke";
		authors="Alkaff";
	}
	
	
	@Test(invocationCount=2, dataProvider="fetchData")
	public void createLead(String username,String password,String companyName, String firtName, String lastName, String phone, String email){
		ViewLeadPage obj=new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmSfaLink()
		.clickLeadsLink()
		.clickCreateLead()
		.enterCompanyName(companyName)
		.enterFirstName(firtName)
		.enterlastName(lastName)
		.enterPhoneNumber(phone)
		.enterEmail(email)
		.clickCreateLeadButton()
		.verifyCompanyName(companyName);
		String id=obj.returnLeadID(prop.getProperty("ViewLead.VerifyCompanyName.Id"));
		leadId.add(id);
		System.out.println("Lead id is "+leadId);
	}
	
	@Test(dataProvider="fetchData",dependsOnMethods="createLead")
	
	public void mergeLead(String username,String password,String companyName, String firtName, String lastName, String phone, String email) throws InterruptedException{
		new LoginPage(driver, test)
		.enterUserName(username)
		.enterPassword(password)
		.clickLogin()
		.clickCrmSfaLink()
		.clickLeadsLink()
		.clickMergeLeadLink()
		.clickFromLeadImage()
		.switchToFindLeadMergeWindow()
		.enterLeadId(leadId.get(0))
		.clickFindLeadButton()
		.clickFirstResultIdforMerge()
		.switchToMergeLeadWindow()
		.clickToLeadImage()
		.switchToFindLeadMergeWindow()
		.enterLeadId(leadId.get(1))
		.clickFindLeadButton()
		.clickFirstResultIdforMerge()
		.switchToMergeLeadWindow()
		.clickMergeLeadButton()
		.acceptMergeAlert()
		.clickFindLeadLink()
		.enterLeadId(leadId.get(0))
		.clickFindLeadButton()
		.verifyMessageText("No records to display");
	}
}
