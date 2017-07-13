package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class Tc_CreateLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setData() {
		testCaseName="Create Lead";
		testDescription="Create Lead test case";
		browserName="chrome";
		dataSheetName="createlead";
		category="Smoke";
		authors="Alkaff";
	}
	
	
	@Test(dataProvider="fetchData")
	public void createLead(String username,String password,String companyName, String firtName, String lastName, String phone, String email){
		new LoginPage(driver, test)
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
	}
	
	

}
