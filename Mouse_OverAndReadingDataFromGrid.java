package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Mouse_OverAndReadingDataFromGrid {
	static WebDriver driver;
	static Actions builder=null;

	public static void createWebDriverInstatnce(){
		driver= new FirefoxDriver();

	}

	public static void setImplicitWait(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	

	}

	public static void loginToCirculus(){
		driver.get("http://qa.circulus.io/");
		driver.findElement(By.id("TxtEmail")).sendKeys("payments.circulus@gmail.com");
		driver.findElement(By.id("TxtPassword")).sendKeys("xeno@123");
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
	public void closeWebDriver() throws InterruptedException{
		Thread.sleep(10000);
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
		setImplicitWait();
		instatnceForActionClass();
		loginToCirculus();
		mouseOver_BillsMenu();
		clickOnSearchBills();
		printFirstCellValueUptoLastRecord();



	}
}
