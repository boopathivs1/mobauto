package pages;


import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import wrappers.ProjectWrappers;

public class TransactionHistoryPage extends ProjectWrappers {

	
	public TransactionHistoryPage(AndroidDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	
	}
	
	public TransactionHistoryPage verifyTransactionHistoryBillers(String amount) throws InterruptedException{
		String amt=regvalue(amount);	
			
			//verifyTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
			
				
			
			String str = amt;
			String digits="";
			for (int i = 0; i < str.length(); i++) {
			    char chrs = str.charAt(i);
			    if (Character.isDigit(chrs)){
			    	digits = digits+chrs;
			}
			System.out.println(digits);

					}


			String getbal = digits.substring(0,2);

			
			
			System.out.println("qqqqqq");
			System.out.println("retrived balance"+getbal+"");
			
			//verifyExactTextcontainslistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),firsttwonum);

			
		verifyExactTextcontainslistReg(prop.getProperty("verify.transhistory.amount.xpath"),getbal);
			
			//	verifyTextMatchlistByXpath(prop.getProperty("verify.within.transferhistory.xpath"),amt);
			
			/*
			Boolean a=driver.getPageSource().contains(amount);
			if(a){
				reportStep("Transaction amount has matched", "PASS");
			}
			else{
				reportStep("Transaction amount has not matched", "PASS");

			}
			*/
			
		return this;
		}

	
	

	
	public DashboardPage clickBacktoDashboard(){
		clickByXpathExplict(prop.getProperty("click.transbackbutton.xpath"));

		clickByXpathExplict(prop.getProperty("click.transbackbutton.xpath"));
		clickByXpathExplict(prop.getProperty("click.transhistorybackbutton.xpath"));
		

		return new DashboardPage(driver, test);
	}
	
	public TransactionHistoryPage filterTransactionHistoryValue(String fromacc,String toacchistory,String transtype,String beneficiarytype,String channelid,String device) throws InterruptedException{

	String toaccount=regvalue(toacchistory);
	
	
	String fromaccount=regvalue(fromacc);

    	selectVisibileTextByXPath(prop.getProperty("select.transhistory.transtype.xpath"),transtype);
    	//Thread.sleep(10000);
    	System.out.println("ele will click");

    	try {
    		
   		 readytimes();
   		//readywithtime(xpathVal);
   	//	readystate();
   		jqueryload();
   	} catch (InterruptedException e1) {
   		
   	}

    	
    	if(device.equalsIgnoreCase("Redmi")){
          int fx = Integer.parseInt(mofromX);
          int fy = Integer.parseInt(mofromY);
                tapByCoordinates(fx,fy);
    	ContextHandlingNative();  
    	Thread.sleep(1000);
    	clickById(prop.getProperty("click.id.calendar.ok.button"));
    	 int tx = Integer.parseInt(motoX);
         int ty = Integer.parseInt(motoY);
    	tapByCoordinates(tx,ty);
    	Thread.sleep(2000);
	clickById(prop.getProperty("click.id.calendar.ok.button"));
ContextHandlingWeb();

    	}
    	else if(device.equalsIgnoreCase("Vivo")){
    		  int fx = Integer.parseInt(mtfromX);
              int fy = Integer.parseInt(mtfromY);
              tapByCoordinates(fx,fy);
          	ContextHandlingNative(); 
          	Thread.sleep(1000);
          	clickById(prop.getProperty("click.id.calendar.ok.button"));
            int tx = Integer.parseInt(mttoX);
            int ty = Integer.parseInt(mttoY);

          	tapByCoordinates(tx,ty);
          	Thread.sleep(2000);
          	clickById(prop.getProperty("click.id.calendar.ok.button"));
      ContextHandlingWeb();
        		
    	}
    	else if(device.equalsIgnoreCase("Realme")){
    		 int fx = Integer.parseInt(mthfromX);
             int fy = Integer.parseInt(mthfromY);
             tapByCoordinates(fx, fy);
         	ContextHandlingNative();
         	Thread.sleep(1000);
         	clickById(prop.getProperty("click.id.calendar.ok.button"));
            int tx = Integer.parseInt(mthtoX);
            int ty = Integer.parseInt(mthtoY);

         	tapByCoordinates(tx,ty);
         	Thread.sleep(2000);
         	clickById(prop.getProperty("click.id.calendar.ok.button"));
     ContextHandlingWeb();
    	}
    	else{
    		reportStep("device name not matched for X,Y cordinate action in datefield","FAIL");
    	}
selectVisibileTextByXPath(prop.getProperty("click.history.fromacc.xpath"),fromaccount);


selectVisibileTextByXPath(prop.getProperty("select.beneficiarytype.xpath"),beneficiarytype);
selectVisibileTextByXPath(prop.getProperty("select.bene.accno.xpath"),toaccount);
selectVisibileTextByXPath(prop.getProperty("select.channel.id.xpath"),channelid);
clickByXpathExplict(prop.getProperty("click.view.history.xpath"));



	
return new TransactionHistoryPage(driver, test);	
	
	}	
	
	
	
	

}
