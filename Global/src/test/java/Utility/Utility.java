package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends Driver {
	public void popupclose() {
		
			try {
				WebElement popup = driver
						.findElement(By.xpath("//a[@href='#' and @class='ui-dialog-titlebar-close ui-corner-all'] | //img[contains(@alt,'close')]|/descendant::a[@href='#' and @class='ui-dialog-titlebar-close ui-corner-all'][2]|//button[@class='close']"));
				if (popup.isDisplayed()) {
					popup.click();
					Logfile.info("Pop is closed");
				}
			}
			catch (Exception e) {
			}
		
	}
}		/*
			try {
				WebElement popup = driver
						.findElement(By.xpath("/descendant::a[@href='#' and @class='ui-dialog-titlebar-close ui-corner-all'][2]"));
				if (popup.isDisplayed()) {
					popup.click();
					Log.info("Pop is closed");
			}
			}
			catch (Exception e) {
			}
			try {
				WebElement popup1 = driver.findElement(By.xpath("//button[@class='close']"));
				if (popup1.isDisplayed()) {
					popup1.click();
					Log.info("Pop is closed");
				}
			} catch (Exception e) {
			}
		} catch (Exception e) {
		}
		*/
	

