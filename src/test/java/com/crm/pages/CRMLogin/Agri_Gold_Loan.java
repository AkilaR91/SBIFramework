package com.crm.pages.CRMLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;

public class Agri_Gold_Loan extends SetUp {
	
	public static String LID;
	public static String LoginID;
	
	
	public void AgriGold_CustomerDetails(String Sheetname, int rowNum, String PC,String product, String CIF,String Fname, String Lname,
			String LS, String LeadRating, String MobNum, String ExtCust,String Gender, String Location) throws Exception {
		/*CommonMethods.highLight("New_XPATH");
		CommonMethods.Click("AgriGold_XPATH");
		CommonMethods.ExWait("AgriGold_XPATH");
		CommonMethods.highLight("AgriGold_XPATH");
		// JavascriptExecutor ex = (JavascriptExecutor) ldriver;
		// ex.executeScript("arguments[0].click()", AgriGold);
		CommonMethods.Click("AgriGold_XPATH");  */

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

	/*	CommonMethods.ExWait("CIFno_XPATH");
		CommonMethods.highLight("CIFno_XPATH");
		CommonMethods.input("CIFno_XPATH", CIF);   */

		CommonMethods.ExWait("FirstName_XPATH");
		CommonMethods.highLight("FirstName_XPATH");
		CommonMethods.input("FirstName_XPATH", Fname);

		CommonMethods.ExWait("LastName_XPATH");
		CommonMethods.highLight("LastName_XPATH");
		CommonMethods.input("LastName_XPATH", Lname);

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

		/* CommonMethods.highLight("SavenPro_XPATH");
		int i = 0;
		WebElement Element = driver.findElement(By.xpath("//a[@data-autoid='FlowNext']"));
		while (true) {
			while (i < 50 && Element != null) {
				JavascriptExecutor ex1 = (JavascriptExecutor) driver;
				ex1.executeScript("arguments[0].click()", Element);
				ex1.executeScript("arguments[0].click()", Element);
				ex1.executeScript("arguments[0].click()", Element);
				ex1.executeScript("arguments[0].click()", Element);
				System.out.println("click" + i++);
				// if(!Element.isDisplayed())break;
			}
			i = 0;
			while (i < 50 && Element == null) {
				WebElement Element1 = driver.findElement(By.xpath("//button[normalize-space()='Ignore And Create']"));
				JavascriptExecutor ex2 = (JavascriptExecutor) driver;
				ex2.executeScript("arguments[0].click()", Element1);
				ex2.executeScript("arguments[0].click()", Element1);
				ex2.executeScript("arguments[0].click()", Element1);
				ex2.executeScript("arguments[0].click()", Element1);

				System.out.println("clicking" + i++);
			}

			if (driver.findElements(By.xpath("//button[normalize-space()='Ignore And Create']")).size() > 0)
				Element = null;
			if (driver.findElements(By.xpath("//*[@id=\"objectWrapper\"]/div/div[3]/div[1]/div/div/div/span"))
					.size() > 0)
				break;
		}   */
		

		

		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
	}	
	
	public void InProcess() throws Exception {
		CommonMethods.ExWait("InProcess_XPATH");
		CommonMethods.highLight("InProcess_XPATH");
		CommonMethods.Click("InProcess_XPATH");
		System.out.println(CommonMethods.getElementText("InProcess_XPATH"));

	}

	public void AppointmentS() throws Exception {
		CommonMethods.ExWait("AppointmentS_XPATH");
		CommonMethods.highLight("AppointmentS_XPATH");
		CommonMethods.Click("AppointmentS_XPATH");
		System.out.println(CommonMethods.getElementText("AppointmentS_XPATH"));
	}

	public void setAppointmentDate(String ADate) throws Exception {
		CommonMethods.ExWait("AppointmentDate_XPATH");
		CommonMethods.highLight("AppointmentDate_XPATH");
		CommonMethods.input("AppointmentDate_XPATH", ADate);
	}

	public void setAppointmentTime(String ATime) throws Exception {
		CommonMethods.highLight("AppointmentTime_XPATH");
		CommonMethods.input("AppointmentTime_XPATH", ATime);

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

	public void ClosureReason(String Reason) throws Exception {
		CommonMethods.ExWait("ClosureReason_XPATH");
		CommonMethods.highLight("ClosureReason_XPATH");
		CommonMethods.Click("ClosureReason_XPATH");
		CommonMethods.selectByValue("ClosureReason_XPATH", Reason);
	}

	public void SearchIcon() throws Exception {
		CommonMethods.mouseClick("SearchIcon_XPATH");
	}

	public void selectobject() throws Exception {
		CommonMethods.mouseClick("selectobject_XPATH");
	}

	public void EnterLID() throws Exception {
		CommonMethods.ExWait("EnterLID_XPATH");
		CommonMethods.highLight("EnterLID_XPATH");
		CommonMethods.input("EnterLID_XPATH", LID);

		/*
		 * EnterLID.sendKeys("01258445"); System.out.println("01258445");
		 * System.out.println("**********************");
		 */
	}

	public void Searchbtn() throws Exception {
		CommonMethods.ExWait("Searchbtn_XPATH");
		CommonMethods.mouseClick("Searchbtn_XPATH");
	}

	public void Editbtn() throws Exception {
		CommonMethods.ExWait("Editbtn_XPATH");
		CommonMethods.mouseClick("Editbtn_XPATH");
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

	public void ApproveBM() throws Exception {
		CommonMethods.ExWait("ApproveBM_XPATH");
		CommonMethods.highLight("ApproveBM_XPATH");
		System.out.println(CommonMethods.getElementText("ApproveBM_XPATH"));
		CommonMethods.Click("ApproveBM_XPATH");
	}

	public void SavenPro1() throws Exception {
		CommonMethods.ExWait("SavenPro_XPATH");
		CommonMethods.highLight("SavenPro_XPATH");
		CommonMethods.Click("SavenPro_XPATH");
	}
	

	public void DocsCollection() throws Exception
	{
		CommonMethods.ExWait("DocsCollection_XPATH");
		CommonMethods.highLight("DocsCollection_XPATH");
		System.err.println(CommonMethods.getElementText("DocsCollection_XPATH"));
		CommonMethods.Click("DocsCollection_XPATH");
		
	}
	
	public void FollowUpS() throws Exception
	{
		CommonMethods.ExWait("FollowUpS_XPATH");
		CommonMethods.highLight("FollowUpS_XPATH");
		System.err.println(CommonMethods.getElementText("FollowUpS_XPATH"));
		CommonMethods.Click("FollowUpS_XPATH");
	}
	
	public void setFollowDate(String FDate) throws Exception 
	{
		CommonMethods.ExWait("FollowDate_XPATH");
		CommonMethods.highLight("FollowDate_XPATH");
		CommonMethods.input("FollowDate_XPATH", FDate);	
	}
	
	public void setFollowTime (String FTime) throws Exception 
	{
		CommonMethods.ExWait("FollowTime_XPATH");
		CommonMethods.highLight("FollowTime_XPATH");
		CommonMethods.input("FollowTime_XPATH", FTime);	
	}
	
	public void Leads() throws Exception {
		CommonMethods.ExWait("Leads_XPATH");
		CommonMethods.highLight("Leads_XPATH");
		System.out.println(CommonMethods.getElementText("Leads_XPATH"));
		CommonMethods.Click("Qualify_XPATH");

	}

	public void Qualify() throws Exception {
		CommonMethods.ExWait("Qualify_XPATH");
		CommonMethods.highLight("Qualify_XPATH");
		System.out.println(CommonMethods.getElementText("Qualify_XPATH"));
		CommonMethods.Click("Qualify_XPATH");

	}

	public void Interested1() throws Exception {
		CommonMethods.ExWait("Interested_XPATH");
		CommonMethods.highLight("Interested_XPATH");
		System.out.println(CommonMethods.getElementText("Interested_XPATH"));
		CommonMethods.Click("Interested_XPATH");
	}



}
