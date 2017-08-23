package test;

import org.openqa.selenium.By;

public class loginWithMultipleUsers extends Mouse_OverAndReadingDataFromGrid {

	
	public static void main(String[] args) throws InterruptedException {
		
		for(String[] userCredintials:DataDriven.getExcelData()){
			
			System.out.println(userCredintials[0]);
			System.out.println(userCredintials[1]);
			
			createWebDriverInstatnce();
			openURL();
			loginToCirculus(userCredintials[0],userCredintials[1]);
			closeWebDriver();
		}
	}
}
