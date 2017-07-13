package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC_EditLead extends LeafTapsWrappers{
	
	@BeforeClass
	
	public void setData() {
		testCaseName="Edit Lead";
		testDescription="Edit Lead test case";
		browserName="chrome";
		dataSheetName="editlead";
		category="Smoke";
		authors="Alkaff";
	}
	
	@Test(dataProvider="fetchData")
	public void editLead(String userName,String password,String firstName,String editName) throws InterruptedException{
		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCrmSfaLink()
		.clickLeadsLink()
		.clickFindLeadLink()
		.enterFirstName(firstName)
		.clickFindLeadButton()
		.clickFirstResultName()
		.clickEditLink()
		.editCompanyName(editName)
		.clickUpdateButton()
		.verifyCompanyName(editName);
	}	

}
