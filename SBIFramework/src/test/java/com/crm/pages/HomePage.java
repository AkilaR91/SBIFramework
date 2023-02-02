package com.crm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	public void selectDepositLayout(String role) throws Exception 
	{
		selectProfile(role);
		Thread.sleep(2000);
		selectLayout();
		CommonMethods.highLight("Deposits_XPATH");
		CommonMethods.Click("Deposits_XPATH");
		log.info("Deposit is selected successfully");
	}
	
	public void selectAgri_GoldLayout(String role) throws Exception {

		selectProfile(role);
		Thread.sleep(2000);
		selectLayout();
		CommonMethods.ExWait("AgriGolDLayout_XPATH");
		CommonMethods.highLight("AgriGolDLayout_XPATH");
		ScreenShot.takeSnapShot("Layout", "Pass");
		CommonMethods.Click("AgriGolDLayout_XPATH");
		log.info("Agri Gold Layout is selected successfully");
		
	}
		
	public void selectSMELayout(String role) throws Exception 
	{
		selectProfile(role);
		Thread.sleep(2000);
		selectLayout();
		CommonMethods.highLight("SME_XPATH");
		CommonMethods.Click("SME_XPATH");
		log.info("SME layout is selected successfully");
	}
	
	public void selectHomeLoanLayout(String role) throws Exception 
	{
		selectProfile(role);
		Thread.sleep(2000);
		selectLayout();
		CommonMethods.highLight("HomeLoans_XPATH");
		CommonMethods.Click("HomeLoans_XPATH");
		log.info("Home loan layout is selected successfully");
	}
	
}
