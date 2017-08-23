package test;

public class ImplicitWait extends Mouse_OverAndReadingDataFromGrid {
	
	public static void main(String[] args) throws InterruptedException {
		createWebDriverInstatnce();
		setImplicitWait(10);
		instatnceForActionClass();
		openURL();
		loginToCirculus("qa.circulus@gmail.com","xeno@123");
		mouseOver_BillsMenu();
		clickOnSearchBills();
		printFirstCellValueUptoLastRecord();
		closeWebDriver();
	}

}
