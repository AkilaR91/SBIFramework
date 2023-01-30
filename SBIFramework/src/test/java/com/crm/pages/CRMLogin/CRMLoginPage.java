package com.crm.pages.CRMLogin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.crm.commonUtilities.CommonMethods;
import com.crm.commonUtilities.ScreenShot;
import com.crm.listeners.TestListeners;



public class CRMLoginPage extends TestListeners
{
	public static Logger log =LogManager.getLogger(CRMLoginPage.class.getName());
	
	
	public void CRMLogin(String Username, String Password ) throws Exception
	{
				extentInfo("Login for ", Username +" Intiated");
				ScreenShot.takeSnapShot("LoginPage", "Pass");
				CommonMethods.input("Username_XPATH", Username);
				CommonMethods.input("Password_XPATH", Password);
				CommonMethods.highLight("LoginBtn_XPATH");
				CommonMethods.Click("LoginBtn_XPATH");
				extentInfo("Sucessfully Login","");
	}
	
	/******************LOGOUT*************************/
	
		
	public void Logout() throws Exception
	{
			CommonMethods.highLight("ProfileBtn_XPATH");
			CommonMethods.Click("ProfileBtn_XPATH");
			CommonMethods.highLight("LogoutBtn_XPATH");
			CommonMethods.Click("LogoutBtn_XPATH");
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
