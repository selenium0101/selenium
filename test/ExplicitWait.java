package test;

public class ExplicitWait extends Mouse_OverAndReadingDataFromGrid {

	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		createWebDriverInstatnce();
		instatnceForActionClass();
		openURL();
		loginToCirculus("qa.circulus@gmail.com","xeno@123");
		setExplicitWait("menu_aBills");
		mouseOver_BillsMenu();
		clickOnSearchBills();
		printFirstCellValueUptoLastRecord();
		closeWebDriver();
		
		
	}
	
}
