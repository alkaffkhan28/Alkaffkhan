package pages;

import java.util.Set;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadMergePage extends LeafTapsWrappers{
	
	public FindLeadMergePage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		
		if(!verifyTitle("Find Leads")){
			reportStep("This is not Find Lead Page", "FAIL");
		}

	}
	public FindLeadMergePage enterLeadId(String name){
		enterByXpath(prop.getProperty("FindLeads.LeadId.Xpath"), name);
		return this;
	}
	
	public FindLeadMergePage clickFindLeadButton(){
		clickByXpath(prop.getProperty("FindLeads.FindLeadButton.Xpath"));
		return this;
	}
	
	public MergeLeadPage switchToMergeLeadWindow() {
		try {
			Set<String> winHandles = driver.getWindowHandles();
			for (String wHandle : winHandles) {
				driver.switchTo().window(wHandle);
			}
		} catch (Exception e) {
			reportStep("The window could not be switched to the last window.", "FAIL");
		}
	return new MergeLeadPage(driver, test);
	}
	
	public FindLeadMergePage clickFirstResultIdforMerge() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpathNoSnap(prop.getProperty("FindLeads.FirstResultId.Xpath"));
		return this;
	}
	
}
