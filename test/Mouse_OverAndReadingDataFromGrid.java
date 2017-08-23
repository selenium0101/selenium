package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;





public class Mouse_OverAndReadingDataFromGrid {
	static WebDriver driver;
	static Actions builder=null;

	public static void createWebDriverInstatnce(){
		driver= new FirefoxDriver();

	}

	public static void setImplicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public static void setExplicitWait(String property){
		displayCurrentDate();
		try{
			WebDriverWait wait = new WebDriverWait(driver, 2);
			System.out.println("ExplicitWait");
			wait.until(ExpectedConditions.visibilityOfElementLocated	(
					By.id(property)));
		}
		catch(Exception e){
			displayCurrentDate();
			throw e;
		}
	}
	public static void displayCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

	public static void openURL(){
		driver.get("http://qa.circulus.io/");
	}

	public static void loginToCirculus(String userName, String passWord){
		driver.findElement(By.id("TxtEmail")).sendKeys(userName);
		driver.findElement(By.id("TxtPassword")).sendKeys(passWord);
		driver.findElement(By.id("BtnLogin")).click();
	}

	public static void instatnceForActionClass(){
		builder= new Actions(driver);
	}

	public static void mouseOver_BillsMenu() throws InterruptedException{
		WebElement elem_billsMenu = driver.findElement(By.id("menu_aBills"));
		builder.moveToElement(elem_billsMenu).build().perform();
		Thread.sleep(3000);
	}

	public static void clickOnSearchBills(){
		WebElement elem_searchBills = driver.findElement(By.id("menu_aBillSearch"));
		builder.moveToElement(elem_searchBills).click().perform();
	}
	public static void closeWebDriver() throws InterruptedException{
		Thread.sleep(1000);
		driver.close();
	}
	public static int getTheSizeOfSearchBillsGrid(){
		return driver.findElements(By.xpath(".//*[@id='cpBody_GVSearchBills']/tbody/tr")).size();
	}
	public static void printFirstCellValueUptoLastRecord(){
		int gridSize=getTheSizeOfSearchBillsGrid();
		for(int i=1;i<=gridSize;i++){
			System.out.println(driver.findElement(By.xpath(".//*[@id='cpBody_GVSearchBills']/tbody/tr["+i+"]/td[1]")).getText());
		}
	}
	public static void main(String[] args) throws InterruptedException {
		createWebDriverInstatnce();
		setImplicitWait(10);
		openURL();
		loginToCirculus("qa.circulus@gmail.com","xeno@123");
		mouseOver_BillsMenu();
		clickOnSearchBills();
		printFirstCellValueUptoLastRecord();
		closeWebDriver();
	}

	public static void setFluentWait(int i,final String property, WebDriver driver){
		// TODO Auto-generated method stub
		new FluentWait<WebDriver>(driver) 
		.withTimeout(i, TimeUnit.SECONDS)
		.pollingEvery(2, TimeUnit.SECONDS)
		.ignoring(org.openqa.selenium.NoSuchElementException.class)
		.until(new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				System.out.println("Checking dom for the presence of property");
				return driver.findElement(By.id(property));
			}
		});
	}
}
