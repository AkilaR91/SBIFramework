package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.DepositsPage;
import com.crm.pages.CRMLogin.HomePage;
import com.crm.pages.CRMLogin.LeadsPage;
import com.crm.pages.CRMLogin.LoginPage;
import com.crm.base.SetUp;



public class TC02Deposit extends SetUp
{
	public DepositsPage deposit;
	public LoginPage login;
	public HomePage home;
	public LeadsPage lead;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void Deposit(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "Deposit";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("Deposit",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test VerifyCRMLogin as the Run mode is NO");
			}
	   	//login to CRM
		login = new LoginPage();
		deposit = new DepositsPage();
		home = new HomePage();
		lead = new LeadsPage();
		
		login.Login(data.get("Username"), data.get("Password"));
		home.selectDeposit(data.get("Role"));
		deposit.createLead(sheetName, data.get("Mobile"), data.get("CIFno"), data.get("Marital Status"), rows.get(iterationCount -1));
		deposit.Interested(sheetName, rows.get(iterationCount -1), data.get("Password"));
		deposit.FollowUp(sheetName, rows.get(iterationCount -1), data.get("Follow Date"), data.get("Follow Time"), data.get("Password"));
		deposit.Appointment(sheetName, rows.get(iterationCount -1),data.get("Appointment Date"), data.get("Appointment Date"), data.get("Password"));
		deposit.DocsCollection(sheetName, rows.get(iterationCount -1), data.get("Password"));
		deposit.Closure(sheetName, rows.get(iterationCount -1), data.get("Password"));
		deposit.SendCBS(sheetName, rows.get(iterationCount -1), data.get("Password"));
		deposit.CIFGenarate(sheetName, rows.get(iterationCount -1), data.get("Password"));
		deposit.AccountOpen(sheetName, rows.get(iterationCount -1), data.get("Password"));	
	}
}
