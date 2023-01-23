package com.crm.pages.CRMLogin;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Deposits.Object.NewLead;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class HomePage extends TestListeners
{
	public static Logger log =LogManager.getLogger(HomePage.class.getName());
	
	
	public void selectProfile(String role) throws Exception
	{
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("ProfileBtn_XPATH");
		log.info("Successfully clicked on Profile Image");
		CommonMethods.highLight("Role_XPATH");
		CommonMethods.Click("Role_XPATH");
		CommonMethods.selectByText("Role_XPATH", role);
		log.info("Role" + role +" is selected");
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("ProfileBtn_XPATH");
	}
	
	public void selectLayout() throws Exception {
		CommonMethods.highLight("Leads_XPATH");
		CommonMethods.Click("Leads_XPATH");
		log.info("Lead Object is selected successfully");
		CommonMethods.highLight("Newlayout_XPATH");
		CommonMethods.Click("Newlayout_XPATH");
		log.info("New Layout is selected successfully");
	}
	
	public void selectDeposit() throws Exception {
		CommonMethods.highLight("Deposits_XPATH");
		CommonMethods.Click("Deposits_XPATH");
		log.info("Deposit is selected successfully");
	}
	
	
	/******************LOGOUT*************************/
	
		
	public void Logout() throws Exception
	{
			CommonMethods.highLight("ProfileBtn_XPATH");
			CommonMethods.Click("ProfileBtn_XPATH");
			CommonMethods.highLight("LogoutBtn_XPATH");
			CommonMethods.Click("LogoutBtn_XPATH");
			log.info("Sucessfully logout..");
	}
	
	
	
	
}
