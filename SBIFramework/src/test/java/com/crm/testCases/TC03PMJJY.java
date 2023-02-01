package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.HomePage;
import com.crm.pages.CRMLogin.LeadsPage;
import com.crm.pages.CRMLogin.LoginPage;
import com.crm.pages.CRMLogin.PMJJYPage;
import com.crm.base.SetUp;



public class TC03PMJJY extends SetUp
{
	public PMJJYPage pmjjy;
	public LoginPage login;
	public HomePage home;
	public LeadsPage lead;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void PMJYY(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "PMJJY";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("PMJJY",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test VerifyCRMLogin as the Run mode is NO");
			}
	   	//login to CRM
		login = new LoginPage();
		pmjjy = new PMJJYPage();
		home = new HomePage();
		lead = new LeadsPage();
		
		login.Login(data.get("Username"), data.get("Password"));
		home.selectDepositLayout(data.get("Role"));
		pmjjy.createLead(sheetName, data.get("Mobile"), data.get("CIFno"), rows.get(iterationCount -1));
		pmjjy.Interested(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pmjjy.FollowUp(sheetName, rows.get(iterationCount -1), data.get("Follow Date"), data.get("Follow Time"), data.get("Password"));
		pmjjy.Appointment(sheetName, rows.get(iterationCount -1),data.get("Appointment Date"), data.get("Appointment Date"), data.get("Password"));
		pmjjy.DocsCollection(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pmjjy.Closure(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pmjjy.SendCBS(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pmjjy.CIFGenarate(sheetName, rows.get(iterationCount -1), data.get("Password"));
		pmjjy.AccountOpen(sheetName, rows.get(iterationCount -1), data.get("Password"));	
	}
}
