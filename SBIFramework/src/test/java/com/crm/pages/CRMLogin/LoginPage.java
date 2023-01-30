package com.crm.pages.CRMLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class LoginPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(LoginPage.class.getName());
	
	
	public void Login(String Username, String Password ) throws Exception
	{
				extentInfo("Login for ", Username +" Intiated");
				CommonMethods.highLight("Username_XPATH");
				CommonMethods.input("Username_XPATH", Username);
				CommonMethods.highLight("Password_XPATH");
				CommonMethods.input("Password_XPATH", Password);
				CommonMethods.highLight("LoginBtn_XPATH");
				CommonMethods.Click("LoginBtn_XPATH");		
				extentInfo("Sucessfully Login","");
	}
	
	/******************LOGOUT*************************/
	
		
	public void Logout() throws Exception
	{
			CommonMethods.highLight("Admin_ProfileBtn_XPATH");
			CommonMethods.Click("Admin_ProfileBtn_XPATH");
			CommonMethods.highLight("Admin_LogoutBtn_XPATH");
			CommonMethods.Click("Admin_LogoutBtn_XPATH");
			log.info("Sucessfully logout..");
	}
	
	public void setUserName(String sheetName, int rowNum) {
		String userName = null;
		try {
			CommonMethods.highLight("ProfileBtn_XPATH");
			CommonMethods.Click("ProfileBtn_XPATH");
			userName = CommonMethods.getElementText("UserID_XPATH");
			if(!(userName == null))
				excel.setCellData(sheetName, "UserName", rowNum, userName);
			CommonMethods.highLight("ProfileBtn_XPATH");
			CommonMethods.Click("ProfileBtn_XPATH");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
