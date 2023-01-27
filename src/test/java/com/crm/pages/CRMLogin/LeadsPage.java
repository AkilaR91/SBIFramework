package com.crm.pages.CRMLogin;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;

public class LeadsPage extends SetUp{
	
	public static String LID;
	public static String LeadStatus;
	public static String AssignedTo;
	public static String LoginID;
	
	
	
	public void toVerifyLeadIDandLeadStatus(String Sheetname, Integer rowNum, String AssignLID) throws Exception{

		CommonMethods.ExWait("LeadID_XPATH");
		CommonMethods.highLight("LeadID_XPATH");
		LID = CommonMethods.getElementText("LeadID_XPATH");
		excel.setCellData(Sheetname, "LeadID", rowNum, LID);
		System.out.println(LID);

		CommonMethods.ExWait("LeadStatus_XPATH");
		CommonMethods.highLight("LeadStatus_XPATH");
		LeadStatus = CommonMethods.getElementText("LeadStatus_XPATH");
		excel.setCellData(Sheetname, "Lead Status", rowNum, LeadStatus);
		

		/*
		 * WebElement e = ldriver.findElement(By.xpath(
		 * "/html/body/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/form/div/div/div/div/div/div[4]/div[1]/div/div/div/div/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div/div[5]/div/div/div/div/a/span"
		 * )); JavascriptExecutor js = (JavascriptExecutor) ldriver; js.
		 * executeScript("arguments[0].setAttribute('style','border: solid 3px red');",
		 * e);
		 */

		// WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(30));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"objectWrapper\"]/div/div/div/div/div/div/div[2]/div/div/div/div/div[5]/div/div/div/div/a")));

		CommonMethods.scrollByVisibilityofElement("AssignedTo_XPATH");
		CommonMethods.highLight("AssignedTo_XPATH");
		AssignedTo = CommonMethods.getElementText("AssignedTo_XPATH");
		excel.setCellData(Sheetname, "Assigned TO", rowNum, AssignedTo);
		CommonMethods.Click("AssignedTo_XPATH");
	 

		CommonMethods.ExWait("AssntoLID_XPATH");
		CommonMethods.highLight("AssntoLID_XPATH");
		LoginID = CommonMethods.getElementText("AssntoLID_XPATH");
		System.out.println(LoginID);
		excel.setCellData(Sheetname, "Login ID", rowNum, LoginID);
		
	}
	
	public void searchLead(String LeadID){
		
		try {
			
			CommonMethods.waitFor(3000);
			CommonMethods.ExWait("salesBtn_XPATH");
			CommonMethods.mouseHover("salesBtn_XPATH");
			
			CommonMethods.ExWait("SearchLeads_XPATH");
			CommonMethods.mouseClick("SearchLeads_XPATH");
			
			CommonMethods.ExWait("SearchIcon_XPATH");
			CommonMethods.mouseClick("SearchIcon_XPATH");
			
			CommonMethods.ExWait("LeadIDField_XPATH");
			CommonMethods.highLight("LeadIDField_XPATH");
			CommonMethods.input("LeadIDField_XPATH", LeadID);
			
			CommonMethods.mouseClick("SerachBtn_XPATH");
			
			CommonMethods.ExWait("EditBtn_XPATH");
			CommonMethods.scrollByVisibilityofElement("EditBtn_XPATH");
			CommonMethods.mouseClick("EditBtn_XPATH");
			
			
			
		}catch(Exception e) {
			
			
		}
		
		
	}


}
