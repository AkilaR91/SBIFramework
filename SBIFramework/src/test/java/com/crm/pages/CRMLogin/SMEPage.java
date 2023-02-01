package com.crm.pages.CRMLogin;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class SMEPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(SMEPage.class.getName());
	public LoginPage login = new LoginPage();
	public LeadsPage lead = new LeadsPage();
	String LeadID = null;
	String text = null;
	String maritalValue = null;
		
	public void createLead(String sheetName, String MobileNo, String CIFno, int rowNum)
	{
		try {
			CommonMethods.highLight("ExtCust_XPATH");
			CommonMethods.Click("ExtCust_XPATH");
			CommonMethods.selectByValue("ExtCust_XPATH", "1");
		
			
			CommonMethods.highLight("CIF_XPATH");
			CommonMethods.input("CIF_XPATH", CIFno);
			
			CommonMethods.highLight("ProposalType_XPATH");
			CommonMethods.Click("ProposalType_XPATH");
			CommonMethods.selectByValue("ProposalType_XPATH", "New");
			
			
			CommonMethods.highLight("ProductType_XPATH");
			CommonMethods.Click("ProductType_XPATH");
			CommonMethods.selectByValue("ProductType_XPATH", "1113980");
			
			CommonMethods.highLight("Constitution_XPATH");
			CommonMethods.ClickWithJavaScript("Constitution_XPATH");
			CommonMethods.selectByValue("Constitution_XPATH", "8");			
			
			CommonMethods.highLight("NameOfUnit_XPATH");
			CommonMethods.input("NameOfUnit_XPATH", "Test BusinessCustomerName");

			CommonMethods.highLight("NameKeyPerson_XPATH");
			CommonMethods.input("NameKeyPerson_XPATH", "rajesh");

		
			CommonMethods.highLight("SME_PreBranch_XPATH");
			CommonMethods.Click("SME_PreBranch_XPATH");

			CommonMethods.Click("SME_Location_XPATH");
			CommonMethods.selectByValue("SME_Location_XPATH", "-1");			
	
			CommonMethods.Click("SME_Location1_XPATH");
	
			CommonMethods.highLight("LeadRating_XPATH");
			CommonMethods.Click("LeadRating_XPATH");
			CommonMethods.selectByValue("LeadRating_XPATH", "1");				
			

			CommonMethods.highLight("SME_ProposedAmount_XPATH");
			CommonMethods.ClickWithJavaScript("SME_ProposedAmount_XPATH");
			CommonMethods.input("SME_ProposedAmount_XPATH", "20000");
		
			CommonMethods.highLight("SME_CCODAmount_XPATH");
			CommonMethods.ClickWithJavaScript("SME_CCODAmount_XPATH");
			CommonMethods.input("SME_CCODAmount_XPATH", "10000");
			
			CommonMethods.highLight("SME_LGBGAmount_XPATH");
			CommonMethods.ClickWithJavaScript("SME_LGBGAmount_XPATH");
			CommonMethods.input("SME_LGBGAmount_XPATH", "10000");
			
			CommonMethods.highLight("SME_DLTLAmount_XPATH");
			CommonMethods.ClickWithJavaScript("SME_DLTLAmount_XPATH");
			CommonMethods.input("SME_DLTLAmount_XPATH", "10000");
			
			CommonMethods.highLight("LeadSource_XPATH");
			CommonMethods.ClickWithJavaScript("LeadSource_XPATH");
			CommonMethods.selectByValue("LeadSource_XPATH", "59");
			
			
			CommonMethods.highLight("Mobile_XPATH");
			CommonMethods.input("Mobile_XPATH", MobileNo);
						
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
			CommonMethods.highLight("SME_SavenPro_XPATH");
			int i=0;
			//WebElement Element =  ldriver.findElement(By.xpath("//a[@data-autoid='FlowNext']"));
			CommonMethods.ExWait("SME_FlowNext_XPATH");
			while(true) {
			while(i<50) {
				CommonMethods.ClickWithJavaScript("SME_FlowNext_XPATH");
				CommonMethods.ClickWithJavaScript("SME_FlowNext_XPATH");
				CommonMethods.ClickWithJavaScript("SME_FlowNext_XPATH");
				CommonMethods.ClickWithJavaScript("SME_FlowNext_XPATH");
				System.out.println("click" + i++);
	       // if(!Element.isDisplayed())break;
			}
			i=0;
			CommonMethods.ExWait("SME_FlowNext_XPATH");
			CommonMethods.ExWait("SME_Ignore_Create_XPATH");

			while(i<50)	{
				CommonMethods.ClickWithJavaScript("SME_Ignore_Create_XPATH");
				
				System.out.println("clicking" + i++);
				}
			
//				if(ldriver.findElements(By.xpath("//button[normalize-space()='Ignore And Create']")).size()>0)Element=null;
//			if(ldriver.findElements(By.xpath("/html/body/div[5]/div/div/div[2]/button[1]")).size()>0)break;
			}
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
			
			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
			
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
	
//	public void CIFGenarate(String sheetName, int rowNum, String password)
//	{
//		try {
//			
//			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
//			
//			Fulfil();
//			
//			CommonMethods.highLight("CIFGenerated_XPATH");
//			CommonMethods.Click("CIFGenerated_XPATH");
//			text = CommonMethods.getElementText("CIFGenerated_XPATH");
//			System.out.println(text);
//			log.info("Clicked on Interested status");
//			ScreenShot.takeSnapShot("Fulful Milestone", "Pass");
//			
//			SavenPro();
//			DStatus();
//			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
//			login.Logout();
//			
//		} catch(Exception e) {
//			e.printStackTrace();
//			log.info(e.getMessage());
//		}
//		
//	}
	
//	public void AccountOpen(String sheetName, int rowNum, String password) 
//	{	
//		try {
//				lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
//
//				Fulfil();
//				CommonMethods.highLight("AccountOpened_XPATH");
//				CommonMethods.Click("AccountOpened_XPATH");
//				text = CommonMethods.getElementText("AccountOpened_XPATH");
//				System.out.println(text);
//				log.info("Clicked on Interested status");
//				
//				SavenPro();
//				DStatus();
//				lead.extractLeadIDandLeadStatus(sheetName, rowNum);
//				login.Logout();
//				
//			} catch(Exception e) {
//				e.printStackTrace();
//				log.info(e.getMessage());
//			}
//		
//	}
	
//	public void SendCBS(String sheetName, int rowNum, String password)
//	{
//		try {
//			
//			lead.AssignedToLogin_searchLead(sheetName, rowNum, password);
//
//			InProcess();
//			CommonMethods.highLight("SendToCBS_XPATH");
//			CommonMethods.Click("SendToCBS_XPATH");
//			text = CommonMethods.getElementText("SendToCBS_XPATH");
//			System.out.println(text);		
//			log.info("Clicked on Send to CBS status");
//			
//			SavenPro();
//			DStatus();
//			lead.extractLeadIDandLeadStatus(sheetName, rowNum);
//			login.Logout();
//			
//		} catch(Exception e) 
//		{
//			e.printStackTrace();
//			log.info(e.getMessage());
//		}
//	}

}
