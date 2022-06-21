package com.com.assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.objectRepositry.CreateOrganisationPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganisationPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.IPathConstants;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(genericUtilities.myListner.class)
public class CreateOrganisationWithShippingaddresEnabledOrNotTest extends BaseClass{
     @Test(groups = {"SmokeTest"},retryAnalyzer = genericUtilities.RetryAnalyserImptn.class)
 	 public void CreateOrganisationWithShippingaddresEnabledOrNotTest(){
		 
		JavaUtility jLib=new JavaUtility();
			
			//fetching data from excel
			String orgName = eLib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 1, 7)+jLib.getRandomNumber();
			
		
			
			//click on Organisation
			Homepage home=new Homepage(driver);
			home.clickOrganisation();
		//	Assert.fail();
			//click on createOrganisation
			CreateOrganisationPage creORG=new CreateOrganisationPage(driver);
			creORG.clickCreateOrganization();
			
		    OrganisationPage org=new OrganisationPage(driver);
		    org.clickShipAdrsRef(driver);
		    
		    //enters the Organisation name
		    org.enterOrgname(orgName);
		    //verify whether shipping addres is selected   
		    WebElement element = org.getRadioBtnShipAdrs();
		    element.click();
		//    Assert.assertTrue(element.isSelected());
	   /*     if(element.isSelected()) {
			System.out.println("is selected");
			}
			else {
				System.out.println("is deselected");
			}*/
	        
	        //click on save
			org.ClickSave();
			
		
	}
	
}
