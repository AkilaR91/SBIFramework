package com.crm.pages;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;

public class Agri_Gold_Loan extends SetUp {

	public static String LID;
	public static String LoginID;

	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	LeadsPage leads = new LeadsPage();

	public void AgriGold_CustomerDetails(String Sheetname, int rowNum, String PC, String product, String Excustomer, String CIF,
			 String LS, String LeadRating, String MobNum, String ExtCust, String Gender,
			String Location) throws Exception {
		/*
		 * CommonMethods.highLight("New_XPATH"); CommonMethods.Click("AgriGold_XPATH");
		 * CommonMethods.ExWait("AgriGold_XPATH");
		 * CommonMethods.highLight("AgriGold_XPATH"); // JavascriptExecutor ex =
		 * (JavascriptExecutor) ldriver; // ex.executeScript("arguments[0].click()",
		 * AgriGold); CommonMethods.Click("AgriGold_XPATH");
		 * 
		 */
		
		

		CommonMethods.ExWait("ProductCategory_XPATH");
		CommonMethods.highLight("ProductCategory_XPATH");
		CommonMethods.selectByText("ProductCategory_XPATH", PC);

		CommonMethods.ExWait("Product_XPATH");
		CommonMethods.highLight("Product_XPATH");
		CommonMethods.selectByText("Product_XPATH", product);

		CommonMethods.ExWait("ExtCust_XPATH");
		CommonMethods.highLight("ExtCust_XPATH");
		CommonMethods.mouseClick("ExtCust_XPATH");
		CommonMethods.selectByText("ExtCust_XPATH", ExtCust);
		

		
		CommonMethods.ExWait("CIFno_XPATH");
		CommonMethods.highLight("CIFno_XPATH");
		CommonMethods.input("CIFno_XPATH", CIF);

		/*
		 * CommonMethods.ExWait("CIFno_XPATH"); CommonMethods.highLight("CIFno_XPATH");
		 * CommonMethods.input("CIFno_XPATH", CIF);
		 */

		/*CommonMethods.ExWait("FirstName_XPATH");
		CommonMethods.highLight("FirstName_XPATH");
		CommonMethods.input("FirstName_XPATH", Fname);

		CommonMethods.ExWait("LastName_XPATH");
		CommonMethods.highLight("LastName_XPATH");
		CommonMethods.input("LastName_XPATH", Lname);  */

		CommonMethods.ExWait("LeadSource_XPATH");
		CommonMethods.highLight("LeadSource_XPATH");
		CommonMethods.selectByText("LeadSource_XPATH", LS);

		CommonMethods.scrollByVisibilityofElement("LeadRating_XPATH");
		CommonMethods.highLight("LeadRating_XPATH");
		CommonMethods.Click("LeadRating_XPATH");
		CommonMethods.selectByText("LeadRating_XPATH", LeadRating);

		/*
		 * public void Salutation() { WebDriverWait wait = new WebDriverWait(ldriver,
		 * Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.elementToBeClickable(Salutation));
		 * Salutation.click(); Select dropdown = new Select(Salutation);
		 * dropdown.selectByValue("15"); }
		 */

		CommonMethods.ExWait("Gender_XPATH");
		CommonMethods.highLight("Gender_XPATH");
		CommonMethods.Click("Gender_XPATH");
		CommonMethods.selectByText("Gender_XPATH", Gender);

		CommonMethods.ExWait("Calender_XPATH");
		CommonMethods.highLight("Calender_XPATH");
		CommonMethods.Click("Calender_XPATH");

		CommonMethods.ExWait("DOB_XPATH");
		CommonMethods.highLight("DOB_XPATH");
		CommonMethods.Click("DOB_XPATH");

		CommonMethods.ExWait("Mobile_XPATH");
		CommonMethods.highLight("Mobile_XPATH");
		CommonMethods.input("Mobile_XPATH", MobNum);

		CommonMethods.ExWait("PreBranch_XPATH");
		CommonMethods.highLight("PreBranch_XPATH");
		// JavascriptExecutor ex = (JavascriptExecutor) ldriver;
		// ex.executeScript("arguments[0].click()", PreBranch);
		CommonMethods.Click("PreBranch_XPATH");
		CommonMethods.ExWait("PCKTerrotory_XPATH");
		CommonMethods.selectByText("PCKTerrotory_XPATH", Location);

		CommonMethods.ExWait("Location1_XPATH");
		CommonMethods.highLight("Location1_XPATH");
		CommonMethods.Click("Location1_XPATH");
		
		ScreenShot.Ashot("AgriGoldCustomerDetails", "Pass");

		/*
		 * CommonMethods.highLight("SavenPro_XPATH"); int i = 0; WebElement Element =
		 * driver.findElement(By.xpath("//a[@data-autoid='FlowNext']")); while (true) {
		 * while (i < 50 && Element != null) { JavascriptExecutor ex1 =
		 * (JavascriptExecutor) driver; ex1.executeScript("arguments[0].click()",
		 * Element); ex1.executeScript("arguments[0].click()", Element);
		 * ex1.executeScript("arguments[0].click()", Element);
		 * ex1.executeScript("arguments[0].click()", Element);
		 * System.out.println("click" + i++); // if(!Element.isDisplayed())break; } i =
		 * 0; while (i < 50 && Element == null) { WebElement Element1 =
		 * driver.findElement(By.xpath("//button[normalize-space()='Ignore And Create']"
		 * )); JavascriptExecutor ex2 = (JavascriptExecutor) driver;
		 * ex2.executeScript("arguments[0].click()", Element1);
		 * ex2.executeScript("arguments[0].click()", Element1);
		 * ex2.executeScript("arguments[0].click()", Element1);
		 * ex2.executeScript("arguments[0].click()", Element1);
		 * 
		 * System.out.println("clicking" + i++); }
		 * 
		 * if (driver.findElements(By.
		 * xpath("//button[normalize-space()='Ignore And Create']")).size() > 0) Element
		 * = null; if (driver.findElements(By.xpath(
		 * "//*[@id=\"objectWrapper\"]/div/div[3]/div[1]/div/div/div/span")) .size() >
		 * 0) break; }
		 */

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
		
		CommonMethods.ExWait("IgnoreAndCreateBtn_XPATH");
		CommonMethods.mouseClick("IgnoreAndCreateBtn_XPATH");
		
		leads.extractLead_AssignedToInfo(Sheetname, rowNum);
		login.Logout();
	}

	public void InProcess() throws Exception {
		CommonMethods.ExWait("InProcess_XPATH");
		CommonMethods.highLight("InProcess_XPATH");
		CommonMethods.Click("InProcess_XPATH");
		System.out.println(CommonMethods.getElementText("InProcess_XPATH"));

	}

	public void AppointmentS(String sheetName, int rowNum, String Username, String Password, String Role, String FTime) throws Exception {
		

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		
		clickOnArror();
		
		CommonMethods.ExWait("Appointment_XPATH");
		CommonMethods.highLight("Appointment_XPATH");
		CommonMethods.Click("Appointment_XPATH");
		
		CommonMethods.ExWait("FollowDateCalender_XPATH");
		CommonMethods.mouseClick("FollowDateCalender_XPATH");
		
		CommonMethods.ExWait("31stJanDate_XPATH");
		CommonMethods.mouseClick("31stJanDate_XPATH");
		
		CommonMethods.ExWait("FollowTime_XPATH");
		CommonMethods.highLight("FollowTime_XPATH");
		CommonMethods.input("FollowTime_XPATH", FTime);
		
		ScreenShot.takeSnapShot("AppointmentStage", "Pass");
		
		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
		
		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();
	}

	
	public void Disqualified() throws Exception {
		CommonMethods.ExWait("Disqualified_Close_XPATH");
		CommonMethods.highLight("Disqualified_Close_XPATH");
		CommonMethods.Click("Disqualified_Close_XPATH");
		System.out.println(CommonMethods.getElementText("Disqualified"));
	}

	public void Disqualified_Close() throws Exception {
		CommonMethods.ExWait("Disqualified_Close_XPATH");
		CommonMethods.highLight("Disqualified_Close_XPATH");
		CommonMethods.Click("Disqualified_Close_XPATH");
		System.out.println(CommonMethods.getElementText("Disqualified_Close_XPATH"));

	}

	public void NotInterested(String Reason) throws Exception {
		clickOnArror();
		CommonMethods.ExWait("Not_Interested_XPATH");
		CommonMethods.highLight("Not_Interested_XPATH");
		CommonMethods.Click("Not_Interested_XPATH");

		CommonMethods.ExWait("ClosureReason_XPATH");
		CommonMethods.highLight("ClosureReason_XPATH");
		CommonMethods.selectByValue("ClosureReason_XPATH", Reason);
		
		ScreenShot.takeSnapShot("NotInteretsedStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
	}

	public void clickOnArror() throws Exception {

		CommonMethods.ExWait("nextPossiblestagesarrow_XPATH");
		CommonMethods.highLight("nextPossiblestagesarrow_XPATH");
		CommonMethods.Click("nextPossiblestagesarrow_XPATH");

	}

	public void Initiate() throws Exception {
		CommonMethods.ExWait("Initiate_XPATH");
		System.out.println(CommonMethods.getElementText("Initiate_XPATH"));
		CommonMethods.mouseClick("Initiate_XPATH");

	}

	public void DedupeApp() throws Exception {
		CommonMethods.ExWait("DedupeApp_XPATH");
		CommonMethods.highLight("DedupeApp_XPATH");
		System.out.println(CommonMethods.getElementText("DedupeApp_XPATH"));
		CommonMethods.Click("DedupeApp_XPATH");

	}

	public void ApproveBM(String sheetName, int rowNum, String Username, String Password, String Role)
			throws Exception {

	//	login.CRMLogin(Username, Password);

	//	home.selectProfile(Role);

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		
		clickOnArror();
		
		CommonMethods.ExWait("ApproveAdmin_XPATH");
		CommonMethods.highLight("ApproveAdmin_XPATH");
		CommonMethods.Click("ApproveAdmin_XPATH");
		
		ScreenShot.takeSnapShot("ApproveBMStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");

		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();

	}

	public void DocsCollection(String sheetName, int rowNum, String Username, String Password, String Role,String MarritalStatus,
			String SpouseOrFatherName, String citizenShip, String LoanAmount, String farmerType, String Scheme, String ModeOfOperation, String Pincode, String Education) throws Exception {
		
		

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		
		clickOnArror();
		
		CommonMethods.ExWait("DocsCollection_XPATH");
		CommonMethods.highLight("DocsCollection_XPATH");
		System.err.println(CommonMethods.getElementText("DocsCollection_XPATH"));
		CommonMethods.Click("DocsCollection_XPATH");
		
		CommonMethods.scrollByVisibilityofElement("DocCollectionCtegory_XPATH");
		CommonMethods.mouseClick("DocCollectionCtegory_XPATH");
		
		CommonMethods.ExWait("Bahaist_Gen_XPATH");
		CommonMethods.mouseClick("Bahaist_Gen_XPATH");
		
		CommonMethods.ExWait("MarritalStatus_XPATH");
		CommonMethods.selectByText("MarritalStatus_XPATH", MarritalStatus);
		
		CommonMethods.highLight("Father_SpouseName_XPATH");
		CommonMethods.input("Father_SpouseName_XPATH", SpouseOrFatherName);
		
		CommonMethods.highLight("SeniorCitizen_XPATH");
		CommonMethods.selectByText("SeniorCitizen_XPATH", citizenShip);
		
		CommonMethods.highLight("loanAmout_XPATH");
		CommonMethods.input("loanAmout_XPATH", LoanAmount);
		
		CommonMethods.mouseClick("LoanPurpose_XPATH");
		
		CommonMethods.ExWait("LoanPurposeName_XPATH");
		CommonMethods.mouseClick("LoanPurposeName_XPATH");
		
		CommonMethods.scrollByVisibilityofElement("ProductCode_XPATH");
		CommonMethods.mouseClick("ProductCode_XPATH");
		
		CommonMethods.ExWait("ProductCodeNumber_XPATH");
		CommonMethods.mouseClick("ProductCodeNumber_XPATH");
		
		CommonMethods.ExWait("FarmerType-XPATH");
		CommonMethods.highLight("FarmerType-XPATH");
		CommonMethods.selectByText("FarmerType-XPATH", farmerType);
		
		CommonMethods.highLight("Scheme_XPATH");
		CommonMethods.selectByText("Scheme_XPATH", Scheme);
		
		CommonMethods.ExWait("Educational_XPATH");
		CommonMethods.highLight("Educational_XPATH");
		CommonMethods.selectByText("Educational_XPATH", Education);
		
		CommonMethods.highLight("ModeOfOperation_XPATH");
		CommonMethods.selectByText("ModeOfOperation_XPATH", ModeOfOperation);
		
		CommonMethods.ExWait("VillageSearch_XPATH");
		CommonMethods.scrollByVisibilityofElement("VillageSearch_XPATH");
		CommonMethods.mouseClick("VillageSearch_XPATH");
		
		CommonMethods.ExWait("VillageName_XPATH");
		CommonMethods.mouseClick("VillageName_XPATH");
		
		CommonMethods.ExWait("CitySearch_XPATH");
		CommonMethods.mouseClick("CitySearch_XPATH");
		
		CommonMethods.ExWait("CityName_XPATH");
		CommonMethods.mouseClick("CityName_XPATH");
		
		CommonMethods.ExWait("PinCode_XPATH");
		CommonMethods.input("PinCode_XPATH", Pincode);
		
		ScreenShot.Ashot("DocCollectionStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
		
		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();

	}

	public void FollowUpS(String sheetName, int rowNum, String Username, String Password, String Role, String FTime) throws Exception {
		

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		clickOnArror();
		CommonMethods.ExWait("FollowUpS_XPATH");
		CommonMethods.highLight("FollowUpS_XPATH");
		System.err.println(CommonMethods.getElementText("FollowUpS_XPATH"));
		CommonMethods.Click("FollowUpS_XPATH");
		
		CommonMethods.ExWait("FollowDateCalender_XPATH");
		CommonMethods.mouseClick("FollowDateCalender_XPATH");
		
		CommonMethods.ExWait("31stJanDate_XPATH");
		CommonMethods.mouseClick("31stJanDate_XPATH");
		
		CommonMethods.ExWait("FollowTime_XPATH");
		CommonMethods.highLight("FollowTime_XPATH");
		CommonMethods.input("FollowTime_XPATH", FTime);
		
		ScreenShot.takeSnapShot("FollowUpStage", "Pass");
		
		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
		
		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();
		
		
	}

	public void Leads() throws Exception {
		CommonMethods.ExWait("Leads_XPATH");
		CommonMethods.highLight("Leads_XPATH");
		System.out.println(CommonMethods.getElementText("Leads_XPATH"));
		CommonMethods.Click("Qualify_XPATH");

	}

	public void Qualify() throws Exception {

		clickOnArror();
		CommonMethods.ExWait("Qualify_XPATH");
		CommonMethods.highLight("Qualify_XPATH");
		System.out.println(CommonMethods.getElementText("Qualify_XPATH"));
		CommonMethods.Click("Qualify_XPATH");
		
		ScreenShot.takeSnapShot("QualifyStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");

	}

	public void Interested1(String sheetName, int rowNum, String Username, String Password, String Role)
			throws Exception {

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		
		clickOnArror();
		CommonMethods.ExWait("InterestedStage_XPATH");
		CommonMethods.highLight("InterestedStage_XPATH");
		CommonMethods.Click("InterestedStage_XPATH");
		
		ScreenShot.takeSnapShot("InterestedStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");

		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();

	}

	public void SendToLos(String sheetName, int rowNum, String Username, String Password, String Role) throws Exception {
		
		

		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		clickOnArror();
		CommonMethods.ExWait("SendToLos_XPATH");
		CommonMethods.highLight("SendToLos_XPATH");
		CommonMethods.Click("SendToLos_XPATH");
		
		ScreenShot.takeSnapShot("SendToLosStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");

		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();


	}
	
	public void LOSRejectedStage(String sheetName, int rowNum, String Username, String Password, String Role) throws Exception{
		
		
		leads.AssignedToLogin_LeadSearch(sheetName, rowNum, Password);

		clickOnArror();
		CommonMethods.ExWait("LOSRejectedStage_XPATH");
		CommonMethods.highLight("LOSRejectedStage_XPATH");
		CommonMethods.Click("LOSRejectedStage_XPATH");
		
		ScreenShot.takeSnapShot("LOSRejectionStage", "Pass");

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");

		leads.extractLead_AssignedToInfo(sheetName, rowNum);

		login.Logout();
		System.out.println();
		
		
	}

}
