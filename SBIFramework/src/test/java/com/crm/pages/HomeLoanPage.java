package com.crm.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class HomeLoanPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(HomeLoanPage.class.getName());
	public LoginPage login = new LoginPage();
	public LeadsPage lead = new LeadsPage();
	String LeadID = null;
	String text = null;
	String maritalValue = null;
		
	public void createLead(String sheetName, String productCategory, String product, 
			String mobileNo, String CIFno, String leadSource, String Fname, String Lname,
			String Gender, String saluation, String occupationType, int rowNum)
	{
		try {
			
			CommonMethods.highLight("PreBranch_XPATH");
			CommonMethods.Click("PreBranch_XPATH");
			CommonMethods.Click("HL_Location_XPATH");
			CommonMethods.selectByValue("HL_Location_XPATH", "-1");
		
		
			
			CommonMethods.highLight("HL_Location1_XPATH");
			CommonMethods.Click("HL_Location1_XPATH");
			
			CommonMethods.highLight("ProductCategory_XPATH");
			CommonMethods.input("ProductCategory_XPATH", productCategory);
			
			CommonMethods.highLight("Product_XPATH");
			CommonMethods.input("Product_XPATH", product);
			
			CommonMethods.highLight("LeadSource_XPATH");
			CommonMethods.input("LeadSource_XPATH", leadSource);
			
			CommonMethods.highLight("ExtCust_XPATH");
			CommonMethods.Click("ExtCust_XPATH");
			CommonMethods.selectByValue("ExtCust_XPATH", "1");
			
			CommonMethods.highLight("CIFno_XPATH");
			CommonMethods.input("CIFno_XPATH", CIFno);
			
			CommonMethods.highLight("FirstName_XPATH");
			CommonMethods.input("FirstName_XPATH", Fname);
			
			CommonMethods.highLight("LastName_XPATH");
			CommonMethods.input("LastName_XPATH", Lname);

			
			
			CommonMethods.highLight("Gender_XPATH");
			CommonMethods.ClickWithJavaScript("Gender_XPATH");
			CommonMethods.selectByValue("Gender_XPATH", Gender);
		
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
			
			CommonMethods.highLight("LoanAmount_XPATH");
			CommonMethods.ClickWithJavaScript("LoanAmount_XPATH");
			CommonMethods.input("LoanAmount_XPATH", "30000");
			
			CommonMethods.highLight("LeadRating_XPATH");
			CommonMethods.ClickWithJavaScript("LeadRating_XPATH");
			CommonMethods.selectByValue("LeadRating_XPATH", "1");
			
			CommonMethods.highLight("Mobile_XPATH");
			CommonMethods.input("Mobile_XPATH", mobileNo);
			
			CommonMethods.highLight("Salutation_XPATH");
			CommonMethods.ClickWithJavaScript("Salutation_XPATH");
			CommonMethods.selectByValue("Salutation_XPATH", saluation);
			CommonMethods.highLight("OcupationType_XPATH");
			CommonMethods.input("OcupationType_XPATH", occupationType);			
					
			SavenPro();
			Dedupe();
			DStatus();
			
			lead.extractLead_AssignedToInfo(sheetName, rowNum);
			RoleValidation();
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
			CommonMethods.highLight("PMJJY_DSTATUS_XPATH");
			text = CommonMethods.getElementText("PMJJY_DSTATUS_XPATH");
			System.out.println(text);
			log.info("Successfully captured Detail Page Status");
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}
	}
	
	public void Dedupe() {
		try 
		{
			if(CommonMethods.isElementDisplayed("IgnoreAndCreateBtn_XPATH"))
			{
				CommonMethods.ExWait("IgnoreAndCreateBtn_XPATH");
				CommonMethods.highLight("IgnoreAndCreateBtn_XPATH");
				CommonMethods.Click("IgnoreAndCreateBtn_XPATH");
				System.out.println("Lead was duplicate, Lead were created by 'Ignore and Create'");
			} else {
				System.out.println("Lead is Saved");
			}
		} catch(Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
		}

	}
	
	public void RoleValidation() {
		  try {
				String roleVal = CommonMethods.getElementText("Role_XPATH");
				CommonMethods.highLight("Role_XPATH");
	            String parts[] = roleVal.split(",");
	            for(String part:parts)
	            {
	                if(part.equals("Branch Head (BM)"))
	                    System.out.println("The role is found as : " + roleVal);
	                System.out.println("Role is as expected.");
	            }
           } catch (Exception e) {
            System.out.println("Role is not matched");
            e.printStackTrace();
            e.getMessage();
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
			
			CommonMethods.highLight("HL_Interested_XPATH");
			CommonMethods.Click("HL_Interested_XPATH");
			text = CommonMethods.getElementText("HL_Interested_XPATH");
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
				
				CommonMethods.highLight("HL_DocsCollection_XPATH");
				CommonMethods.Click("HL_DocsCollection_XPATH");
				text = CommonMethods.getElementText("HL_DocsCollection_XPATH");
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


}
