package com.crm.pages;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class PSegPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(PSegPage.class.getName());
	public LoginPage login = new LoginPage();
	public LeadsPage lead = new LeadsPage();
	String LeadID = null;
	String text = null;
		
	public void createLead(String sheetName, String leadType, String productCategory,
			String product, String leadSource, String fname, String lname, String gender, 
			String mobile,	int rowNum)
	{
		try {
			
			CommonMethods.highLight("PreBranch_XPATH");
			CommonMethods.ClickWithJavaScript("PreBranch_XPATH");
			CommonMethods.ClickWithJavaScript("PSegment_Location_XPATH");
			CommonMethods.selectByValue("PSegment_Location_XPATH", "-1");
			
			CommonMethods.highLight("PSeg_Location1_XPATH");
			CommonMethods.Click("PSeg_Location1_XPATH");
			
			CommonMethods.highLight("LeadType_XPATH");
			CommonMethods.Click("LeadType_XPATH");
			CommonMethods.selectByValue("LeadType_XPATH", leadType);
			
			CommonMethods.highLight("ProductCategory_XPATH");
			CommonMethods.Click("ProductCategory_XPATH");
			CommonMethods.selectByValue("ProductCategory_XPATH", productCategory);
			
			CommonMethods.highLight("Product_XPATH");
			CommonMethods.Click("Product_XPATH");
			CommonMethods.selectByValue("Product_XPATH", product);
			
			CommonMethods.highLight("ExtCust_XPATH");
			CommonMethods.Click("ExtCust_XPATH");
			CommonMethods.selectByValue("ExtCust_XPATH", "2");

			CommonMethods.highLight("LeadSource_XPATH");
			CommonMethods.Click("LeadSource_XPATH");
			CommonMethods.selectByValue("LeadSource_XPATH", leadSource);
			
			CommonMethods.highLight("FirstName_XPATH");
			CommonMethods.input("FirstName_XPATH", fname);

			CommonMethods.highLight("LastName_XPATH");
			CommonMethods.input("LastName_XPATH", lname);
			
			
			CommonMethods.ClickWithJavaScript("Salutation_XPATH");
			CommonMethods.selectByValue("Salutation_XPATH", "15");
			
			CommonMethods.highLight("Gender_XPATH");
			CommonMethods.ClickWithJavaScript("Gender_XPATH");
			CommonMethods.selectByValue("Gender_XPATH", gender);
		
			String Sex = CommonMethods.getElementValue("Gender_XPATH");
			String Title = CommonMethods.getElementValue("Salutation_XPATH");

			if (Sex.equals("2") && (Title.equals("4") || Title.equals("15") || Title.equals("14") || Title.equals("19")
					|| Title.equals("17"))) {
				System.out.println("Gender is Mismatched");
			} else if (Sex.equals("1") && (Title.equals("1"))) {
				System.out.println("Gender is Mismatched");
			} else {
				System.out.println("Gender is Matched");
			}
			
			CommonMethods.highLight("PSeg_Calender_XPATH");
			CommonMethods.Click("PSeg_Calender_XPATH");
			
			CommonMethods.highLight("PSeg_DOB_XPATH");
			CommonMethods.Click("PSeg_DOB_XPATH");
			
			CommonMethods.highLight("SearchLoanPurpose_XPATH");
			CommonMethods.ClickWithJavaScript("SearchLoanPurpose_XPATH");
			
			
			CommonMethods.highLight("LeadRating_XPATH");
			CommonMethods.ClickWithJavaScript("LeadRating_XPATH");
			CommonMethods.selectByValue("LeadRating_XPATH", "1");
			
			CommonMethods.highLight("Mobile_XPATH");
			CommonMethods.input("Mobile_XPATH", mobile);
						
			SavenPro();
			
			CommonMethods.highLight("IgnoreAndCreateBtn_XPATH");
			CommonMethods.Click("IgnoreAndCreateBtn_XPATH");
			log.info("Lead is duplicate ");
			
			DStatus();
			
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();	
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
			

	}
	
	public void SavenPro()
	{
		try {
			CommonMethods.highLight("SavenPro_XPATH");
			CommonMethods.Click("SavenPro_XPATH");
		} catch (Exception e){
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	public void DStatus() {
		try {
			CommonMethods.highLight("DSTATUS_XPATH");
			text = CommonMethods.getElementText("DSTATUS_XPATH");
			System.out.println(text);
			log.info("Successfully captured Detail Page Status");
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	
	public void Interested(String sheetName, int rowNum, String password) 
	{
		try {
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);
			
			CommonMethods.highLight("Qualify_XPATH");
			CommonMethods.Click("Qualify_XPATH");
			text = CommonMethods.getElementText("Qualify_XPATH");
			System.out.println(text);
			log.info("Clicked on Qualify Milestone");
			
			CommonMethods.highLight("Interested_XPATH");
			CommonMethods.Click("Interested_XPATH");
			text = CommonMethods.getElementText("Interested_XPATH");
			System.out.println(text);
			log.info("Clicked on Interested status");
			ScreenShot.takeSnapShot("Interested Detail Page", "Pass");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch (Exception e)
		{
			e.printStackTrace();
			log.info(e.getMessage());
		}
		
		
	}
	
	public void InProcess() {
		try {
			CommonMethods.highLight("InProcess_XPATH");
			CommonMethods.Click("InProcess_XPATH");
			text = CommonMethods.getElementText("InProcess_XPATH");
			System.out.println(text);
			log.info("MileStone is selected");
			ScreenShot.takeSnapShot("In Process Milestone", "Pass");
		} catch( Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}

	public void FollowUp(String sheetName, int rowNum, String FDate, String FTime, String password)
	{
		try {
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

			InProcess();
			
			CommonMethods.highLight("FollowUpS_XPATH");
			CommonMethods.Click("FollowUpS_XPATH");
			text = CommonMethods.getElementText("FollowUpS_XPATH");
			System.out.println(text);
			log.info("Status is selected");
			
			CommonMethods.highLight("FollowDate_XPATH");
			CommonMethods.input("FollowDate_XPATH", FDate);
			log.info("Follow up date is entered");
			
			CommonMethods.highLight("FollowTime_XPATH");
			CommonMethods.input("FollowTime_XPATH", FTime);
			log.info("Follow up time is entered");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch( Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	
	
	public void Appointment(String sheetName, int rowNum, String ADate, String ATime, String password)
	{
		try {
				lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

				InProcess();
				CommonMethods.highLight("AppointmentS_XPATH");
				CommonMethods.Click("AppointmentS_XPATH");
				text = CommonMethods.getElementText("AppointmentS_XPATH");
				System.out.println(text);
				
				CommonMethods.highLight("AppointmentDate_XPATH");
				CommonMethods.input("AppointmentDate_XPATH", ADate);
			
				CommonMethods.highLight("AppointmentTime_XPATH");
				CommonMethods.input("AppointmentTime_XPATH", ATime);
				
				SavenPro();
				DStatus();
				lead.extractLead_AssignedToInfo(sheetName, rowNum);
				login.Logout();
				
			}catch( Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
		
	}
	
	public void DocsCollection(String sheetName, int rowNum, String password) 
	{
		try {
				lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);
	
				InProcess();
				
				CommonMethods.highLight("DocsCollection_XPATH");
				CommonMethods.Click("DocsCollection_XPATH");
				text = CommonMethods.getElementText("DocsCollection_XPATH");
				System.out.println(text);
				log.info("Clicked on Docs Collection status");
				ScreenShot.takeSnapShot("Docs Collection Details Page", "Pass");
				
				SavenPro();
				DStatus();
				lead.extractLead_AssignedToInfo(sheetName, rowNum);
				login.Logout();
				
			} catch(Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			
		}
	}
	
	public void Closure(String sheetName, int rowNum, String password) {
		try {
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

			CommonMethods.highLight("Disqualified_XPATH");
			CommonMethods.Click("Disqualified_XPATH");
			text = CommonMethods.getElementText("Disqualified_XPATH");
			System.out.println(text);
			log.info("Clicked on Disqualified Milestone");
			
			CommonMethods.highLight("Disqualified_Close_XPATH");
			CommonMethods.Click("Disqualified_Close_XPATH");
			text = CommonMethods.getElementText("Disqualified_Close_XPATH");
			System.out.println(text);
			log.info("Clicked on Disqualified_Close status");
			
			CommonMethods.highLight("ClosureReason_XPATH");
			CommonMethods.Click("ClosureReason_XPATH");
			CommonMethods.selectByValue("ClosureReason_XPATH","Customer not responding");
			log.info("Closure reason is selected");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}

	
	public void NotEligible(String sheetName, int rowNum, String password) {
		try {
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

			CommonMethods.highLight("NotEligible_XPATH");
			CommonMethods.Click("NotEligible_XPATH");
			text = CommonMethods.getElementText("Disqualified_XPATH");
			System.out.println(text);
			log.info("Clicked on Not Eligible");
			
			CommonMethods.highLight("Disqualified_Close_XPATH");
			CommonMethods.Click("Disqualified_Close_XPATH");
			text = CommonMethods.getElementText("Disqualified_Close_XPATH");
			System.out.println(text);
			log.info("Clicked on Disqualified_Close status");
			
			CommonMethods.highLight("ClosureReason_XPATH");
			CommonMethods.Click("ClosureReason_XPATH");
			CommonMethods.selectByValue("ClosureReason_XPATH","Customer not responding");
			log.info("Closure reason is selected");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	

}
