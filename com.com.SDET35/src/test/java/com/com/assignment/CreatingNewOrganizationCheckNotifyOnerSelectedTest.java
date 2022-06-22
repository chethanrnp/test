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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.objectRepositry.CreateOrganisationPage;
import com.crm.objectRepositry.Homepage;
import com.crm.objectRepositry.LoginPage;
import com.crm.objectRepositry.OrganisationPage;

import genericUtilities.BaseClass;
import genericUtilities.ExcelUtility;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatingNewOrganizationCheckNotifyOnerSelectedTest extends BaseClass{
   @Test(groups = {"SmokeTest"})
 	 public  void CreatingNewOrganizationCheckNotifyOnerSelectedTest(){
	
		
			ExcelUtility elib=new ExcelUtility();
			JavaUtility jlib=new JavaUtility();
	
		//get data from excel sheet using apache poi repositry 
			String orgName = elib.getDataFromExcelSheet(".\\src\\test\\resources\\FLIPKART.xlsx", "Organisation", 1, 2)+jlib.getRandomNumber();
	
		//click on organisation
		Homepage home=new Homepage(driver);
		home.clickOrganisation();
		//click on create organization
		CreateOrganisationPage creORG=new CreateOrganisationPage(driver);
		creORG.clickCreateOrganization();
		OrganisationPage org=new OrganisationPage(driver);
		org.clickNotifyRef(driver);
		//enter organisation name
		org.enterOrgname(orgName);
		//verify whether notify oner is selected
		WebElement element2 = org.getCheckBxNotifyOner();
		
	       element2.click();
	       SoftAssert ast=new SoftAssert();
	       ast.assertTrue(element2.isSelected());
	/*  if(element2.isSelected()) {
			System.out.println("is selected");
		}
		else {
			System.out.println("is deselected");
		}*/
	  //click on save
		 org.ClickSave();
		 ast.assertAll();
		
	}
	
}
