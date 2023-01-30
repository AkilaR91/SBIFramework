package com.crm.pages.CRMLogin;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class DepositsPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(DepositsPage.class.getName());
	public LoginPage login = new LoginPage();
	public LeadsPage lead = new LeadsPage();
	String LeadID = null;
	String text = null;
	String maritalValue = null;
		
	public void createLead(String sheetName, String Mobile, String CIFno, String maritalStatus, int rowNum)
	{
		try {
			CommonMethods.highLight("ExtCust_XPATH");
			CommonMethods.Click("ExtCust_XPATH");
			CommonMethods.selectByValue("ExtCust_XPATH","1");
			log.info("Existing customer is selected");
			
			
			CommonMethods.highLight("CIF_XPATH");
			CommonMethods.input("CIF_XPATH", CIFno);
			log.info("CIF no Entered");
			
			CommonMethods.highLight("ProductCategory_XPATH");
			CommonMethods.Click("ProductCategory_XPATH");
			CommonMethods.selectByValue("ProductCategory_XPATH", "79");
			log.info("Proposal Type is selected");
			
			CommonMethods.highLight("Product_XPATH");
			CommonMethods.Click("Product_XPATH");
			CommonMethods.selectByValue("Product_XPATH", "81");
			log.info("Product is selected");
			
			CommonMethods.highLight("LeadSource_XPATH");
			CommonMethods.ClickWithJavaScript("LeadSource_XPATH");
			// LeadSource.click();
			CommonMethods.selectByValue("LeadSource_XPATH","10");
		    log.info("LeadSource is selected");
		    
			CommonMethods.highLight("LeadType_XPATH");
			//LeadType.click();
			CommonMethods.selectByValue("LeadType_XPATH","HNI");
		    log.info("LeadType is selected");
		    
			CommonMethods.ClickWithJavaScript("LeadRating_XPATH");
			CommonMethods.highLight("LeadRating_XPATH");
			//LeadRating.click();
			CommonMethods.selectByValue("LeadRating_XPATH", "1");
			log.info("LeadRating is selected");
				
			CommonMethods.highLight("Mobile_XPATH");
			CommonMethods.input("Mobile_XPATH", Mobile);
			log.info("Mobile no is Entered");
			
			CommonMethods.highLight("Marital_Status_XPATH");
			if(maritalStatus.equalsIgnoreCase("Married"))
				maritalValue = "M";
			else
				maritalValue ="S";
			CommonMethods.selectByValue("Marital_Status_XPATH", maritalValue);
			log.info("Marital Status is Selected");

			SavenPro();
			DStatus();
			
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
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
			CommonMethods.highLight("DStatus_XPATH");
			text = CommonMethods.getElementText("DStatus_XPATH");
			System.out.println(text);
			log.info("Successfully captured Detail Page Status");
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
//	public void SearchIcon() throws Exception
//	{
//		CommonMethods.highLight("SearchIcon_XPATH");
//		CommonMethods.Click("SearchIcon_XPATH");
//		log.info("Advance search is selected");
//	}
	
//	public void EnterLID() throws Exception
//	{
//		CommonMethods.highLight("EnterLID_XPATH");
//		System.out.println("LeadID :" + LeadID);
//		CommonMethods.input("EnterLID_XPATH", LeadID);
//		log.info("Lead Id is entered");
//		
//	}
//	
//	public void Searchbtn() throws Exception
//	{
//		CommonMethods.highLight("SearchBtn_XPATH");
//		CommonMethods.Click("SearchBtn_XPATH");
//		log.info("Clicked on search button");
//	}
//	
//	public void Editbtn() throws Exception
//	{
//		CommonMethods.highLight("EditBtn_XPATH");
//		CommonMethods.Click("EditBtn_XPATH");
//		log.info("Clicked on edit button");
//	}
	
	
	public void Interested(String sheetName, int rowNum, String password) 
	{
		try {
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

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
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
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
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

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
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
			login.Logout();
			
		} catch( Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	
	
	public void Appointment(String sheetName, int rowNum, String ADate, String ATime, String password)
	{
		try {
				lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

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
				lead.extractLeadIDandLeadStatus(sheetName, rowNum);
				login.Logout();
				
			}catch( Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
		
	}
	
	public void DocsCollection(String sheetName, int rowNum, String password) 
	{
		try {
				lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
	
				InProcess();
				
				CommonMethods.highLight("DocsCollection_XPATH");
				CommonMethods.Click("DocsCollection_XPATH");
				text = CommonMethods.getElementText("DocsCollection_XPATH");
				System.out.println(text);
				log.info("Clicked on Docs Collection status");
				ScreenShot.takeSnapShot("Docs Collection Details Page", "Pass");
				
				SavenPro();
				DStatus();
				lead.extractLeadIDandLeadStatus(sheetName, rowNum);
				login.Logout();
				
			} catch(Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			
		}
	}
	
	public void Closure(String sheetName, int rowNum, String password) {
		try {
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

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
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}

	
	public void Fulfil()
	{
		try {
			CommonMethods.highLight("Fulfil_XPATH");
			CommonMethods.Click("Fulfil_XPATH");
			text = CommonMethods.getElementText("Fulfil_XPATH");
			System.out.println(text);
			log.info("Clicked on Fulfil Milestone");
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

	}
	
	public void CIFGenarate(String sheetName, int rowNum, String password)
	{
		try {
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
			
			Fulfil();
			
			CommonMethods.highLight("CIFGenerated_XPATH");
			CommonMethods.Click("CIFGenerated_XPATH");
			text = CommonMethods.getElementText("CIFGenerated_XPATH");
			System.out.println(text);
			log.info("Clicked on Interested status");
			ScreenShot.takeSnapShot("Fulful Milestone", "Pass");
			
			SavenPro();
			DStatus();
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		
	}
	
	public void AccountOpen(String sheetName, int rowNum, String password) 
	{	
		try {
				lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

				Fulfil();
				CommonMethods.highLight("AccountOpened_XPATH");
				CommonMethods.Click("AccountOpened_XPATH");
				text = CommonMethods.getElementText("AccountOpened_XPATH");
				System.out.println(text);
				log.info("Clicked on Interested status");
				
				SavenPro();
				DStatus();
				lead.extractLeadIDandLeadStatus(sheetName, rowNum);
				login.Logout();
				
			} catch(Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
		
	}
	
	public void SendCBS(String sheetName, int rowNum, String password)
	{
		try {
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);

			InProcess();
			CommonMethods.highLight("SendToCBS_XPATH");
			CommonMethods.Click("SendToCBS_XPATH");
			text = CommonMethods.getElementText("SendToCBS_XPATH");
			System.out.println(text);		
			log.info("Clicked on Send to CBS status");
			
			SavenPro();
			DStatus();
			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}

}
