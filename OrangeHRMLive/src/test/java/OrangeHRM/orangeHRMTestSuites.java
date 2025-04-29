package OrangeHRM;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class orangeHRMTestSuites extends reusuableKeyWords {

	@BeforeTest
	 
    public void lauchApplication() throws Exception{
		
		openBrowser();
		login();
    }


@Test

public void Login() throws Exception {
	
	login();
	
}


@Test

public void About() throws Exception {
	
	about();
}

@Test

public void Support() throws Exception {
	
	support();
}

@Test

public void Admin() throws Exception {
	
	adminPage();
	
}
@Test

public void PIM() throws Exception {
	
	
	addEmployee();
	searchEmployee();
	deleteEmployee();
	
}


@Test
public void Leave() throws Exception {
	
	
	
	searchLeave();
	addLeave();
		
}



@Test
public void Recruitment() throws Exception {
	
	
	recruitmentPage();

}

@Test
public void Time() throws Exception {
	
	
	viewTime();
	
}


@Test

public void MyInfo() throws Exception {
	
	
	myInfoPage();
	
	
}

@Test

public void Performance() throws Exception {
	
	
	performance();
	
	
}


@Test

public void Dashboard() throws Exception {
	
	
	dashboard();
	
	
}

@Test

public void Directory() throws Exception {
	
	directory();
}

@Test
public void Buzz() throws Exception {
	
	
	creatingBuzz();
}



@AfterTest 
public void closeBrowsers() throws Exception {
  
    logout();
    quitDriver(); 
    closeBrowser(); 
}

}