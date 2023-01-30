package com.crm.testCases;

import java.util.ArrayList;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.crm.base.SetUp;
import com.crm.commonUtilities.CommonMethods;
import com.crm.pages.CRMLogin.Agri_Gold_Loan;
import com.crm.pages.CRMLogin.HomePage;
import com.crm.pages.CRMLogin.LeadsPage;
import com.crm.pages.CRMLogin.LoginPage;

public class TC01Agri_Gold extends SetUp {

	public static int iterationCount = 0;
	public String sheetName="Agri_Gold";
	LoginPage login = new LoginPage();
	HomePage home = new HomePage();
	Agri_Gold_Loan agri = new Agri_Gold_Loan();
	LeadsPage leads =  new LeadsPage();

	@Test(dataProviderClass = CommonMethods.class, dataProvider = "dp")
	public void Agri_Gold(Hashtable<String, String> data) throws Exception {

		// sheetName from Excel to pass the testdata

		ArrayList<Integer> rows = excel.getRunnableRowsNumber(sheetName);

		// To check testcase runmode from excel (Yes/No) if yes then launch Browser and
		// execute script
		if (!(CommonMethods.isTestRunnable("Agri_Gold",sheetName, data.get("URL"), rows.get(iterationCount-1)))) {

			throw new SkipException("Skipping the test Agri_Gold as the Run mode is NO");
		}

		iterationCount++;
		login.Login(data.get("Username"), data.get("Password"));
		home.selectProfile(data.get("Role"));
		home.selectLayout_Agri_Gold();
		agri.AgriGold_CustomerDetails(sheetName, rows.get(iterationCount-1), data.get("ProductCategory"), data.get("Product"), data.get("ExtCust") ,data.get("CIF")
				, data.get("LS"), data.get("LeadRating"), data.get("MobNum"), data.get("ExtCust"), data.get("Gender"), data.get("Location"));
		agri.ApproveBM(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"));
		agri.Interested1(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"));
		agri.FollowUpS(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"), data.get("Timing"));
		agri.AppointmentS(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"), data.get("Timing"));
		agri.DocsCollection(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"), data.get("MarritalStatus"), data.get("SpouseOrFatherName"), 
				data.get("citizenShip"), data.get("LoanAmount"), data.get("Farmer Type"), data.get("Scheme"), data.get("ModeOfOperation"), data.get("Pincode"), data.get("Educational"));
		agri.SendToLos(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"));
		agri.LOSRejectedStage(sheetName,rows.get(iterationCount-1),data.get("Login ID"), data.get("Password"),data.get("AdminRole"));
		login.Logout();
		System.out.println();
		
	
		
		
		
		
		

	}
}
