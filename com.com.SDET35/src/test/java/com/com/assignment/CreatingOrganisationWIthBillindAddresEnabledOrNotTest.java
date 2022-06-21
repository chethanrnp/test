package com.com.assignment;

import static org.testng.Assert.assertTrue;

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

public class CreatingOrganisationWIthBillindAddresEnabledOrNotTest extends BaseClass{

	 @Test
 	 public void CreatingOrganisationWIthBillindAddresEnabledOrNotTest(){
	
		    ExcelUtility elib = new ExcelUtility();
		
			JavaUtility jlib = new JavaUtility();
		
			//fetches data from excel
			String orgName = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 0, 1)+jlib.getRandomNumber();
		
			//click on organasition
			Homepage home=new Homepage(driver);
			home.clickOrganisation();
			//click on create organization
			CreateOrganisationPage creORG=new CreateOrganisationPage(driver);
			creORG.clickCreateOrganization();
		    OrganisationPage org=new OrganisationPage(driver);
		    org.radioBtnBilAdrs(driver);
		    //enter organisation name 
		    org.enterOrgname(orgName);
	          org.ClickNotifyOner();
	          //check whether billing addres is selected
		    WebElement element2 = org.getRadioBtnBilAdrs();
		    element2.click();
		    assertTrue(element2.isSelected());
		/*	if(element2.isSelected()) {
				System.out.println("is selected");
			}
			else {
				System.out.println("is deselected");
			}*/
			//click on save
			org.ClickSave();
					
	}

}

