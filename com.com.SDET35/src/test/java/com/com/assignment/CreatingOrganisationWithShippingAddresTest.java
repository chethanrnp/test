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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CreatingOrganisationWithShippingAddresTest extends BaseClass{
 
	 @Test(groups = {"regressionTest"})
	 public void  CreatingOrganisationWithShippingAddresTest(){
                 //Create Object of Excel Utility
		ExcelUtility elib = new ExcelUtility();
		 //Create Object of Java Utility
		JavaUtility jlib = new JavaUtility();
	
			//fetch data from excel
			String orgname = elib.getDataFromExcelSheet(IPathConstants.excelPath, "Organisation", 0, 1)+jlib.getRandomNumber();
	
			//click on Organasition
			Homepage home=new Homepage(driver);
			home.clickOrganisation();
			//click on create organization
			CreateOrganisationPage creORG=new CreateOrganisationPage(driver);
			creORG.clickCreateOrganization();
			 OrganisationPage org=new OrganisationPage(driver);
			 //click on shipping addres
			 org.ClickSipAdders();
			 //enter organization name
			 org.enterOrgname(orgname);
			 //enters the data in Discription
			 org.enterDiscription();
			 //click on save
			 org.ClickSave();
			 
		
			
			
	}
	
}

