package TestScript;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class keywords {

	static ChromeDriver driver;
	static FileInputStream file;
	static Properties prop;
	static Select select;

		public void openbrowser() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);	
			
		file =new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Clockify\\src\\Objectrepository\\objectrepositories.properties");
		prop= new Properties();
		prop.load(file);
		
			
		}
	public void navigate(String url){
		driver.get(url);
	}

	public void input(String testdata,String objectName){
		driver.findElement(By.xpath(prop.getProperty(objectName))).sendKeys(testdata);
		
	}
	public void click(String objectName){
		driver.findElement(By.xpath(prop.getProperty(objectName))).click();
		
	}

	public String verifypagetitle(){
		String actual = driver.getTitle();
		return actual;
	}

	public String verifyeditbox(String objectName){
		String actual = driver.findElement(By.xpath(prop.getProperty(objectName))).getAttribute("value");
		return actual;
	}

	public void dropdown(String objectName,String testData){
		
		select = new Select(driver.findElement(By.xpath(prop.getProperty(objectName))));
		
		select.selectByValue(testData);
			
	}

	public String verifydropdown(String objectName){
		
		String av = driver.findElement(By.xpath(prop.getProperty(objectName))).getAttribute("value");
		return av;
		
		
		
		
	}



	public void closebrowser() throws Exception{
		Thread.sleep(10000);
		driver.close();
	}





	}	

