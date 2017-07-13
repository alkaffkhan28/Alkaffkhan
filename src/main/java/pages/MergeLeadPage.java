package pages;

import java.util.Set;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeLeadPage extends LeafTapsWrappers{

	public MergeLeadPage(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;

		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Merge Lead Page", "FAIL");
		}
	}

	public MergeLeadPage clickFromLeadImage(){
		clickByXpath(prop.getProperty("MergeLead.FromLeadImage.Xpath"));
		return this;
	}

	public MergeLeadPage clickToLeadImage(){
		clickByXpath(prop.getProperty("MergeLead.ToLeadImage.Xpath"));
		return this;
	}

	public MergeLeadPage clickMergeLeadButton(){
		clickByLinkNoSnap(prop.getProperty("MergeLead.MergeLeadButton.Link"));
		return this;
	}

	public FindLeadMergePage switchToFindLeadMergeWindow() {
		switchToLastWindow();
		return new FindLeadMergePage(driver, test);
	}

	public ViewLeadPage acceptMergeAlert() {
		acceptAlert();
		return new ViewLeadPage(driver, test);
	}
}
