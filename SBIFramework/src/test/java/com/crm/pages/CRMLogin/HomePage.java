package com.crm.pages.CRMLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
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
		//CommonMethods.Click("Role_XPATH");
		CommonMethods.selectByValue("Role_XPATH", role);
		log.info("Role" + role +" is  selected");
		
		CommonMethods.highLight("ProfileBtn_XPATH");
		CommonMethods.Click("ProfileBtn_XPATH");
	}
	
	public void selectLayout() throws Exception 
	{
		CommonMethods.highLight("Leads_XPATH");
		CommonMethods.Click("Leads_XPATH");
		log.info("Lead Object is selected successfully");
		
		CommonMethods.highLight("Newlayout_XPATH");
		CommonMethods.Click("Newlayout_XPATH");
		log.info("New Layout is selected successfully");
	}
	
	public void selectDeposit(String role) throws Exception 
	{
		selectProfile(role);
		Thread.sleep(2000);
		selectLayout();
		CommonMethods.highLight("Deposits_XPATH");
		CommonMethods.Click("Deposits_XPATH");
		log.info("Deposit is selected successfully");
	}
	
}
