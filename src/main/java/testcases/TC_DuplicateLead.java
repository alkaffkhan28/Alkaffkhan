package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC_DuplicateLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData(){
		testCaseName="Duplicate Lead";
		testDescription="Duplicate Lead test case";
		browserName="chrome";
		dataSheetName="duplicatelead";
		category="Smoke";
		authors="Alkaff";
	}
	
	@Test(dataProvider="fetchData")
	public void duplicateLead(String userName, String password, String email) throws InterruptedException{
		FindLeadsPage obj=new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCrmSfaLink()
		.clickLeadsLink()
		.clickFindLeadLink()
		.clickEmailLink()
		.enterEmail(email)
		.clickFindLeadButton();
		String text=obj.getFirstResultText();
		obj.clickFirstResultName()
		.clickDuplicateLink()
		.clickCreateButton()
		.verifyFirstName(text);
		
		
	}

}
