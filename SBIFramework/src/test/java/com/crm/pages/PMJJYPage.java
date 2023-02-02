package com.crm.pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class PMJJYPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(PMJJYPage.class.getName());
	public LoginPage login = new LoginPage();
	public LeadsPage lead = new LeadsPage();
	String LeadID = null;
	String text = null;
	String maritalValue = null;
		
	public void createLead(String sheetName, String MobileNo, String CIFno, int rowNum)
	{
		try {
			CommonMethods.highLight("PMJJY_ExtCust_XPATH");
			CommonMethods.Click("PMJJY_ExtCust_XPATH");
			CommonMethods.selectByValue("PMJJY_ExtCust_XPATH", "1");
			
		
			CommonMethods.highLight("PMJJY_CIF_XPATH");
			CommonMethods.input("PMJJY_CIF_XPATH", CIFno);
			
		
			CommonMethods.highLight("PMJJY_ProductCategory_XPATH");
			CommonMethods.Click("PMJJY_ProductCategory_XPATH");
			CommonMethods.selectByValue("PMJJY_ProductCategory_XPATH", "79");
			
		
			CommonMethods.highLight("PMJJY_Product_XPATH");
			CommonMethods.Click("PMJJY_Product_XPATH");
			CommonMethods.selectByValue("PMJJY_Product_XPATH", "81");
		
		
			CommonMethods.highLight("PMJJY_LeadSource_XPATH");
			CommonMethods.ClickWithJavaScript("PMJJY_LeadSource_XPATH");
			CommonMethods.selectByValue("PMJJY_LeadSource_XPATH", "10");
	
			
			CommonMethods.highLight("PMJJY_LeadType_XPATH");
			CommonMethods.selectByValue("PMJJY_LeadType_XPATH", "HN1");

			CommonMethods.highLight("PMJJY_LeadRating_XPATH");
			CommonMethods.ClickWithJavaScript("PMJJY_LeadRating_XPATH");
			CommonMethods.selectByValue("PMJJY_LeadRating_XPATH", "1");
		
		
			CommonMethods.highLight("PMJJY_DOB_XPATH");
			CommonMethods.Click("PMJJY_DOB_XPATH");
		
		
			CommonMethods.highLight("PMJJY_PreBranch_XPATH");
			CommonMethods.Click("PMJJY_PreBranch_XPATH");
			CommonMethods.Click("PMJJY_Location_XPATH");
			CommonMethods.selectByValue("PMJJY_Location_XPATH", "-1");

			CommonMethods.Click("PMJJY_Location1_XPATH");
		
			CommonMethods.highLight("PMJJY_Mobile_XPATH");
			CommonMethods.input("PMJJY_Mobile_XPATH", MobileNo);
			
			SavenPro();
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
			CommonMethods.highLight("PMJJY_SavenPro_XPATH");
			CommonMethods.Click("PMJJY_SavenPro_XPATH");
		} catch (Exception e){
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	public void DStatus() {
		try {
			CommonMethods.highLight("PMJJY_DSTATUS_XPATH");
			text = CommonMethods.getElementText("PMJJY_DSTATUS_XPATH");
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
			
			CommonMethods.highLight("PMJJY_Qualify_XPATH");
			CommonMethods.Click("PMJJY_Qualify_XPATH");
			text = CommonMethods.getElementText("PMJJY_Qualify_XPATH");
			System.out.println(text);
			log.info("Clicked on Qualify Milestone");
			
			CommonMethods.highLight("PMJJY_Interested_XPATH");
			CommonMethods.Click("PMJJY_Interested_XPATH");
			text = CommonMethods.getElementText("PMJJY_Interested_XPATH");
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
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);
			
			Fulfil();
			
			CommonMethods.highLight("CIFGenerated_XPATH");
			CommonMethods.Click("CIFGenerated_XPATH");
			text = CommonMethods.getElementText("CIFGenerated_XPATH");
			System.out.println(text);
			log.info("Clicked on Interested status");
			ScreenShot.takeSnapShot("Fulful Milestone", "Pass");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
		
	}
	
	public void AccountOpen(String sheetName, int rowNum, String password) 
	{	
		try {
				lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

				Fulfil();
				CommonMethods.highLight("AccountOpened_XPATH");
				CommonMethods.Click("AccountOpened_XPATH");
				text = CommonMethods.getElementText("AccountOpened_XPATH");
				System.out.println(text);
				log.info("Clicked on Interested status");
				
				SavenPro();
				DStatus();
				lead.extractLead_AssignedToInfo(sheetName, rowNum);
				login.Logout();
				
			} catch(Exception e) {
				e.printStackTrace();
				log.info(e.getMessage());
			}
		
	}
	
	public void SendCBS(String sheetName, int rowNum, String password)
	{
		try {
			
			lead.AssignedToLogin_LeadSearch(sheetName, rowNum, password);

			InProcess();
			CommonMethods.highLight("SendToCBS_XPATH");
			CommonMethods.Click("SendToCBS_XPATH");
			text = CommonMethods.getElementText("SendToCBS_XPATH");
			System.out.println(text);		
			log.info("Clicked on Send to CBS status");
			
			SavenPro();
			DStatus();
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			login.Logout();
			
		} catch(Exception e) 
		{
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}

}
