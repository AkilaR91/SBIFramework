package com.crm.pages.CRMLogin;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;

public class LeadsPage extends SetUp{
	
	public static String LID;
	public static String LeadStatus;
	public static String AssignedTo;
	public static String loginID;
	public LoginPage login = new LoginPage();
	
	
	
	public void extractLeadIDandLeadStatus(String sheetName, Integer rowNum) throws Exception{

		CommonMethods.ExWait("LeadID_XPATH");
		CommonMethods.highLight("LeadID_XPATH");
		LID = CommonMethods.getElementText("LeadID_XPATH");
		excel.setCellData(sheetName, "LeadID", rowNum, LID);
		System.out.println(LID);

		CommonMethods.ExWait("LeadStatus_XPATH");
		CommonMethods.highLight("LeadStatus_XPATH");
		LeadStatus = CommonMethods.getElementText("LeadStatus_XPATH");
		excel.setCellData(sheetName, "Lead Status", rowNum, LeadStatus);

		CommonMethods.scrollByVisibilityofElement("AssignedTo_XPATH");
		CommonMethods.highLight("AssignedTo_XPATH");
		AssignedTo = CommonMethods.getElementText("AssignedTo_XPATH");
		excel.setCellData(sheetName, "Assigned TO", rowNum, AssignedTo);
		CommonMethods.Click("AssignedTo_XPATH");
	 

		CommonMethods.ExWait("AssntoLID_XPATH");
		CommonMethods.highLight("AssntoLID_XPATH");
		loginID = CommonMethods.getElementText("AssntoLID_XPATH");
		System.out.println(loginID);
		excel.setCellData(sheetName, "Assigned_TO_Login_ID", rowNum, loginID);
		
	}
	
	public void AssignedToLogin_searchLead(String sheetName, int rowNum, String password){
		
		try {
			
			String loginID = loginWithAssignedTo(sheetName, rowNum, password);
						
			if(loginID.equals("admin"))
			{
				CommonMethods.ExWait("salesBtn_XPATH");
				CommonMethods.mouseHover("salesBtn_XPATH");
			}
			
			CommonMethods.highLight("Leads_XPATH");
			CommonMethods.Click("Leads_XPATH");
			log.info("Lead Object is selected successfully");
			
			
			
//			CommonMethods.ExWait("SearchLeads_XPATH");
//			CommonMethods.mouseClick("SearchLeads_XPATH");
			
			CommonMethods.ExWait("SearchIcon_XPATH");
			CommonMethods.mouseClick("SearchIcon_XPATH");
			
			CommonMethods.ExWait("LeadIDField_XPATH");
			CommonMethods.highLight("LeadIDField_XPATH");
			CommonMethods.input("LeadIDField_XPATH", excel.getCellData(sheetName, "LeadID", rowNum));
			
			CommonMethods.ExWait("Lead_SearchBtn_XPATH");
			CommonMethods.highLight("Lead_SearchBtn_XPATH");
			CommonMethods.mouseClick("Lead_SearchBtn_XPATH");
			
			CommonMethods.ExWait("EditBtn_XPATH");
			CommonMethods.scrollByVisibilityofElement("EditBtn_XPATH");
			CommonMethods.mouseClick("EditBtn_XPATH");
			System.out.println("Edit the lead...............");
			
			
			
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
		
	public String loginWithAssignedTo(String sheetName, int rowNum, String password) {
			
		String loginID = null;
			try {
				
				loginID = excel.getCellData(sheetName, "Login ID", rowNum );
				if(loginID == null)
					loginID= excel.getCellData(sheetName, "Username", rowNum);
				login.Login(loginID, password);
				
			} catch(Exception e) {
				
				e.printStackTrace();
				log.info(e.getMessage());
			}
			
			return loginID;
		}


}
