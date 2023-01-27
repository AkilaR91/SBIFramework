package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.Agri_Gold_Loan;
import com.crm.pages.CRMLogin.CRMLoginPage;
import com.crm.pages.CRMLogin.HomePage;
import com.crm.pages.CRMLogin.LeadsPage;

public class CreateNewLead extends SetUp {

	public static int iterationCount = 0;
	public String sheetName="Agri_Gold";
	CRMLoginPage login = new CRMLoginPage();
	HomePage home = new HomePage();
	Agri_Gold_Loan agri = new Agri_Gold_Loan();
	LeadsPage leads =  new LeadsPage();

	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void Agri_Gold(Hashtable<String, String> data) throws Exception {

		// sheetName from Excel to pass the testdata

		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);

		// To check testcase runmode from excel (Yes/No) if yes then launch Browser and
		// execute script
		if (!(CommonMethods.isTestRunnable("Agri_Gold", sheetName))) {

			throw new SkipException("Skipping the test Agri_Gold as the Run mode is NO");
		}

		iterationCount++;
		login.CRMLogin(data.get("Username"), data.get("Password"));
		home.selectProfile(data.get("Role"));
		home.selectLayout();
		agri.AgriGold_CustomerDetails(sheetName, rows.get(iterationCount-1), data.get("ProductCategory"), data.get("Product"), data.get("CIF"), 
				data.get("Fname"), data.get("Lname"), data.get("LS"), data.get("LeadRating"), data.get("MobNum"), data.get("ExtCust"), data.get("Gender"), data.get("Location"));
		leads.toVerifyLeadIDandLeadStatus(sheetName, rows.get(iterationCount-1), data.get("AssignedLID"));
		login.adminLogInLogout();
		login.CRMLogin(data.get("Login ID"), data.get("Password"));
		home.selectProfile(data.get("AdminRole"));
		System.out.println("*********************");
		leads.searchLead(data.get("LeadID"));
		System.out.println("*********************");
		
		
		
		

	}
}
