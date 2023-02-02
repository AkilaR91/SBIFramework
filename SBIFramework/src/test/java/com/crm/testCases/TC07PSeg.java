package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.HomePage;
import com.crm.pages.LeadsPage;
import com.crm.pages.LoginPage;
import com.crm.pages.PSegPage;
import com.crm.base.SetUp;



public class TC07PSeg extends SetUp
{
	public PSegPage pseg;
	public LoginPage login;
	public HomePage home;
	public LeadsPage lead;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void PSeg(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "Deposit";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("PSeg",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test NRI Home Loan as the Run mode is NO");
			}
	   	//login to CRM
		login = new LoginPage();
		pseg = new PSegPage();
		home = new HomePage();
		lead = new LeadsPage();
		
		login.Login(data.get("Username"), data.get("Password"));
		home.selectPSegLayout(data.get("Role"));
		pseg.createLead(sheetName, data.get("Lead Type"), data.get("ProductCategory"), data.get("Product"), data.get("LeadSource"),
				data.get("FirstName"), data.get("LastName"), data.get("Gender"), 
				data.get("MobileNo"), rows.get(iterationCount -1));
		pseg.Interested(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pseg.FollowUp(sheetName, rows.get(iterationCount -1), data.get("Follow Date"), data.get("Follow Time"), data.get("Password"));
		pseg.Appointment(sheetName, rows.get(iterationCount -1),data.get("Appointment Date"), data.get("Appointment Date"), data.get("Password"));
		pseg.DocsCollection(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pseg.Closure(sheetName, rows.get(iterationCount -1), data.get("Password"));	
		pseg.NotEligible(sheetName, rows.get(iterationCount -1), data.get("Password"));
	}
}
