package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.HomePage;
import com.crm.pages.CRMLogin.LeadsPage;
import com.crm.pages.CRMLogin.LoginPage;
import com.crm.pages.CRMLogin.SMEPage;
import com.crm.base.SetUp;



public class TC04SME extends SetUp
{
	public SMEPage sme;
	public LoginPage login;
	public HomePage home;
	public LeadsPage lead;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void SME(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "SME";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("SME",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test VerifyCRMLogin as the Run mode is NO");
			}
	   	//login to CRM
		login = new LoginPage();
		sme = new SMEPage();
		home = new HomePage();
		lead = new LeadsPage();
		
		login.Login(data.get("Username"), data.get("Password"));
		home.selectDeposit(data.get("Role"));
		sme.createLead(sheetName, data.get("Mobile"), data.get("CIFno"), rows.get(iterationCount -1));
		sme.Interested(sheetName, rows.get(iterationCount -1), data.get("Password"));
		sme.FollowUp(sheetName, rows.get(iterationCount -1), data.get("Follow Date"), data.get("Follow Time"), data.get("Password"));
		sme.Appointment(sheetName, rows.get(iterationCount -1),data.get("Appointment Date"), data.get("Appointment Date"), data.get("Password"));
		sme.DocsCollection(sheetName, rows.get(iterationCount -1), data.get("Password"));
		sme.Closure(sheetName, rows.get(iterationCount -1), data.get("Password"));
//		sme.SendCBS(sheetName, rows.get(iterationCount -1), data.get("Password"));
//		sme.CIFGenarate(sheetName, rows.get(iterationCount -1), data.get("Password"));
//		sme.AccountOpen(sheetName, rows.get(iterationCount -1), data.get("Password"));	
	}
}
