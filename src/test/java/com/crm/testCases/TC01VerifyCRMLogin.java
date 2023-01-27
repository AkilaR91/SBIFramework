package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.CRMLoginPage;
import com.crm.base.SetUp;



public class TC01VerifyCRMLogin extends SetUp
{
	public CRMLoginPage login;
	public static int iterationCount = 0;
	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void VerifyCRMLogin(Hashtable<String, String> data) throws Exception
	{
	
		//sheetName from Excel to pass the testdata
		String sheetName = "VerifyCRMLogin";
		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);
		iterationCount++;
		 //To check  testcase runmode from excel (Yes/No) if yes then launch Browser and execute script
		  if (!(CommonMethods.isTestRunnable("VerifyCRMLogin",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

				throw new SkipException(
						"Skipping the test VerifyCRMLogin as the Run mode is NO");
			}
		   		//login to CRM
			login = new CRMLoginPage();
			login.CRMLogin(data.get("Username"), data.get("Password"));
			login.setUserName(sheetName, rows.get(iterationCount - 1));
			login.Logout();
		  
		  
		}
}
