package OrangeHRM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver.Timeouts;
import java.time.Duration;



public class reusuableKeyWords extends objects{
	
	public static WebElement element = null;
	
	public static WebDriver driver;
	
	WebDriverWait wait;
	
	public static WebDriver openBrowser() throws Exception{
		
		if(browser == "chrome") {
			
			System.setProperty("WebDriver.chrome.driver", chromeDriverPath);
			
			driver = new ChromeDriver();
			
			} else  {
			
            System.setProperty("WebDriver.gecko.driveplummetedr", firefoxDriverPath);
			
			driver = new FirefoxDriver();
			  
			} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		//Thread.sleep(1000);
		
		
		return driver;
	}
	
	
	    // click method
		public void click(String locator) throws Exception
		 {
			 driver.findElement(By.xpath(locator)).click();
		 }
		
		// Text Input
		public void inputText(String locator, String text) throws Exception
		{
			click(locator);
			driver.findElement(By.xpath(locator)).clear();
			driver.findElement(By.xpath(locator)).sendKeys(text);
		}
		
		// Verify if the element is present
		public boolean elementpresent(String locator) {
			
			try {
				
				driver.findElement(By.xpath(locator));
				return true;
				
			} catch(Exception e) {
				
				return false;
			}
		}
		//Verify if the element is visible
		public void elementvisible(String locator, int time)
		{
			wait = new WebDriverWait(driver,Duration.ofSeconds(time));
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			
			
		}
		
		//Quit Driver
		public void quitDriver()
		{
			 driver.quit();
			 
		}
		
		//Close Driver
		public void closeBrowser() {
			   
			   driver.close();
		   }
		
		//dropdown select by text
		  public void selectByVisibleText(String locator, String text) throws Exception {
			   
			Select dropdown = new Select(driver.findElement(By.xpath(locator)));
			   dropdown.selectByVisibleText(text);
		   }
		  
		//dropdown select by index
		  public void selectByVisibleIndex(String locator, int indexValue) throws Exception {
			   
				Select dropdown = new Select(driver.findElement(By.xpath(locator)));
				   dropdown.selectByIndex(indexValue);
			   }
		
		//login method
		
		public void login() throws Exception {
			
			
			Thread.sleep(2000);
			inputText(Username,userName);
			inputText(Password, password);
			click(loginbtn);
			String pageTitle = driver.getTitle();
			if (pageTitle.equals("OrangeHRM")) {
				System.out.println("Login Successful");
			}else {
				System.out.println("Login Unsuccessful");
			}
			
			
		}
		
		//about user 
		public void about() throws Exception {
		
		Thread.sleep(5000);
		click(userDropdownIcon);
		click(aboutUser);
		elementvisible(textAbout, 10);
		System.out.println("About pop-up is visible");
		}
		
		//support
		public void support() throws Exception{
		Thread.sleep(5000);
		click(userDropdownIcon);
		click(support);
		elementvisible(textSupport, 10);
		System.out.println("Support page is displayed");
		
		}
		//logout
		public void logout() throws Exception{
			click(userDropdownIcon);
			click(logoutbtn);
			String pageTitle = driver.getTitle();
			Assert.assertEquals("Login", pageTitle);
		}
		 //Admin: Page display
		public void adminPage() throws Exception{
			
			
            Thread.sleep(5000);
			click(adminbtn);
			Thread.sleep(5000);
			elementvisible(adminText,10);
			System.out.println("Admin page is displayed");
//			selectByVisibleText(dropdownForRole,"Admin");
//			Thread.sleep(2000);
//			selectByVisibleText(dropdownForStatus,"Enabled");
//			Thread.sleep(2000);
//			click(searchbtn);
			
		}
		
		//PIM: Add,search and delete Employee
		
       public void addEmployee() throws Exception{
			
			
            Thread.sleep(5000);
			click(pimbtn);
			Thread.sleep(5000);
			click(addEmployeebtn);
			Thread.sleep(5000);
			inputText(nameOfEmployee,FirstName);
			Thread.sleep(2000);
			inputText(lastName,LastName);
			Thread.sleep(2000);
			click(save);
			
       }
       //Search Employee
       public void searchEmployee()throws Exception{
    	    
    	    Thread.sleep(2000);
    	    click(pimbtn);
    	    //click(employeeListbtn);
    	    Thread.sleep(10000);
    	    driver.findElement(By.xpath(employeeNameForPIM)).sendKeys("Saoly");
			//inputText(employeeNameForPIM, FirstName);
			Thread.sleep(2000);
			click(search);
			//elementvisible(textSupport, 10);
			
			
			
       }
       
       
       //Delete Employee
       public void deleteEmployee()throws Exception{
    	   //searchEmployee();
    	   Thread.sleep(5000);
    	   click(deleteEmployee);
    	   click(yesDeletebtn);
    	   
       }
       
     //Leave: 
		
       public void searchLeave() throws Exception{
			
    	    
            Thread.sleep(5000);
            click(leaveMenu);
            //Thread.sleep(5000);
            //WebElement value1 = driver.findElement(By.xpath(fromDate));
            Thread.sleep(2000);
            driver.findElement(By.xpath(fromDate)).sendKeys("\b\b\b\b\b\b\b\b\b\b");
            //driver.findElement(By.xpath(fromDate)).sendKeys(Keys.BACK_SPACE);
            Thread.sleep(2000);
            driver.findElement(By.xpath(fromDate)).sendKeys("2024-10-11");
            Thread.sleep(2000);
			//inputText(fromDate,FromDate);
            driver.findElement(By.xpath(toDate)).sendKeys("\b\b\b\b\b\b\b\b\b\b");
			Thread.sleep(5000);
			driver.findElement(By.xpath(toDate)).sendKeys("2024-25-11");
			Thread.sleep(5000);
			//Select drpdwn = new Select (driver.findElement(By.xpath(showLeaveWithStatus)));
			//Thread.sleep(5000);
			//selectByVisibleText(showLeaveWithStatus,"Scheduled");
			Thread.sleep(2000);
			click(search);
			elementvisible(toaster, 10);
		
       }
		//add leave
       public void addLeave() throws Exception{
    	   addEmployee();
    	   click(leaveMenu);
    	   Thread.sleep(5000);
    	   click(assignLeavebtn);
    	   Thread.sleep(5000);
    	   driver.findElement(By.xpath(employeeName)).sendKeys("Saoly");
    	   Thread.sleep(5000);
    	   selectByVisibleText(leaveType,"CAN - Vacation");
    	   Thread.sleep(5000);
    	   inputText(fromDate,FromDate);
    	   Thread.sleep(5000);
		   inputText(toDate,ToDate);
		   Thread.sleep(5000);
		   click(assignbtn);
		   Thread.sleep(5000);
		   deleteEmployee();
		
       }
       
       //Time
       public void viewTime() throws Exception{
    	   
    	   Thread.sleep(2000);
    	   addEmployee();
    	   Thread.sleep(2000);
    	   click(timeMenu);
    	   Thread.sleep(10000);
    	   selectByVisibleText(employeeName,"Saoly Test");
    	   Thread.sleep(2000);
    	   click(view);
    	   searchEmployee();
     	   deleteEmployee();
    	   
       }
       
     //Recuritment
     		public void recruitmentPage() throws Exception{
     		Thread.sleep(5000);
     		click(recruitmentMenu);
     		elementvisible(recruitment, 10);
     		System.out.println("Recruitment page is displayed");
     		
     		}
       
     		//My Info
     		public void myInfoPage() throws Exception{
     		Thread.sleep(5000);
     		click(myInfoMenu);
     		elementvisible(PIMText, 10);
     		System.out.println("My Info page is displayed");
     		
     		}
     		
     		//Performance
     		  public void performance() throws Exception {
     	    	   
     	    	   Thread.sleep(5000);
     	    	   addEmployee();
     	    	   Thread.sleep(2000);
     	    	   click(performanceMenu);
     	    	   Thread.sleep(5000);
     	    	   inputText(employeeName,reviewEmployeeName);
     	    	   Thread.sleep(5000);
     	    	   selectByVisibleIndex(employeeName, 1);
     	    	   Thread.sleep(5000);
     	    	   click(search);
     	    	   deleteEmployee();
     	    	   
     	       }

       //Dashboard
     		
     		 public void dashboard() throws Exception{
     			Thread.sleep(5000);
     			click(dashboardMenu);
     			elementvisible(dashboardText, 10);
     			System.out.println("Dashboard page is displayed");
     			
     			}
     		 
     		 
     		 //Directory
     		 
      		
     		 public void directory() throws Exception{
     			Thread.sleep(5000);
     			click(directoryMenu);
     			elementvisible(directoryText, 10);
     			System.out.println("Directory page is displayed");
     			
     			}
     		 
     		// Buzz
     		public void creatingBuzz() throws Exception{
     			Thread.sleep(5000);
     			click(buzzMenu);
     			elementvisible(buzzText, 10);
     			inputText(buzzField,BuzzText);
     			click(postbtn);
     			System.out.println("Buzz is added successfully");
     		}
     			

}

