package test;

public class FluentWait extends Mouse_OverAndReadingDataFromGrid {
	
	
	public static void main(String[] args) throws InterruptedException {
		createWebDriverInstatnce();
		instatnceForActionClass();
		openURL();
		loginToCirculus("qa.circulus@gmail.com","xeno@123");
		setFluentWait(10,"menu_aBills",driver);
		mouseOver_BillsMenu();
		clickOnSearchBills();
		printFirstCellValueUptoLastRecord();
		closeWebDriver();
	} 
	

}
