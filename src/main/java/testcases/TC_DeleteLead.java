package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC_DeleteLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData(){
		testCaseName="Delete Lead";
		testDescription="Delete Lead test case";
		browserName="chrome";
		dataSheetName="deletelead";
		category="Smoke";
		authors="Alkaff";
	}
	
	@Test(dataProvider="fetchData")
	public void deleteLead(String userName,String password,String phone,String message) throws InterruptedException{
		System.out.println(phone);
		FindLeadsPage obj=new LoginPage(driver, test)
				.enterUserName(userName)
				.enterPassword(password)
				.clickLogin()
				.clickCrmSfaLink()
				.clickLeadsLink()
				.clickFindLeadLink()
				.clickPhoneLink()
				.enterPhoneNumber(phone)
				.clickFindLeadButton();
			String leadId=obj.getFirstResultId();
			obj.clickFirstResultName()
			.clickDeleteLink()
			.clickFindLeadLink()
			.enterLeadId(leadId)
			.clickFindLeadButton()
			.verifyMessageText(message);
		
	}
	

}
