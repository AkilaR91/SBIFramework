package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.HomePage;
import com.crm.pages.LeadsPage;
import com.crm.pages.LoginPage;
import com.crm.pages.NRIHomeLoanPage;
import com.crm.base.SetUp;



public class TC06NRIHomeLoan extends SetUp
{
	public NRIHomeLoanPage nrihl;
	public LoginPage login;
	public HomePage home;
	public LeadsPage lead;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void NRIHomeLoan(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "Deposit";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("NRIHomeLoan",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test NRI Home Loan as the Run mode is NO");
			}
	   	//login to CRM
		login = new LoginPage();
		nrihl = new NRIHomeLoanPage();
		home = new HomePage();
		lead = new LeadsPage();
		
		login.Login(data.get("Username"), data.get("Password"));
		home.selectNRIHomeLoanLayout(data.get("Role"));
		nrihl.createLead(sheetName, data.get("ProductCategory"), data.get("Product"), data.get("LeadSource"), data.get("LeadType") , data.get("CIFno"),
				data.get("FirstName"), data.get("LastName"), data.get("Gender"), 
				data.get("MobileNo"), data.get("Resident Status"), rows.get(iterationCount -1));
		nrihl.Interested(sheetName, rows.get(iterationCount -1), data.get("Password"));
		nrihl.FollowUp(sheetName, rows.get(iterationCount -1), data.get("Follow Date"), data.get("Follow Time"), data.get("Password"));
		nrihl.Appointment(sheetName, rows.get(iterationCount -1),data.get("Appointment Date"), data.get("Appointment Date"), data.get("Password"));
		nrihl.DocsCollection(sheetName, rows.get(iterationCount -1), data.get("Password"));
		nrihl.Closure(sheetName, rows.get(iterationCount -1), data.get("Password"));	
	}
}
