package com.crm.pages.CRMLogin;

import java.time.Duration;
import java.util.logging.LogManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;

public class HomePage extends SetUp {

	public void selectProfile(String role) throws Exception {
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("ProfileBtn_XPATH");
		log.info("Successfully clicked on Profile Image");
		CommonMethods.highLight("Role_XPATH");
		CommonMethods.Click("Role_XPATH");
		CommonMethods.selectByText("Role_XPATH", role);
		log.info("Role" + role + " is selected");
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("ProfileBtn_XPATH");
	}

	public void selectLayout() throws Exception {
		CommonMethods.ExWait("Leads_XPATH");
		CommonMethods.highLight("Leads_XPATH");
		CommonMethods.Click("Leads_XPATH");
		log.info("Lead Object is selected successfully");
		CommonMethods.ExWait("NewBtn_XPATH");
		CommonMethods.highLight("NewBtn_XPATH");
		CommonMethods.mouseHover("NewBtn_XPATH");
		CommonMethods.ExWait("AgriGolDLayout_XPATH");
		CommonMethods.highLight("AgriGolDLayout_XPATH");
		ScreenShot.takeSnapShot("Layout", "Pass");
		CommonMethods.Click("AgriGolDLayout_XPATH");
		log.info("New Layout is selected successfully");
		
	}

}
