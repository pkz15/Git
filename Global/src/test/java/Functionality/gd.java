package Functionality;

import java.util.ArrayList;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Driver;
import Utility.Logfile;
import Utility.Utility;

public class gd extends Driver {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(240));
	

	public void gdfunction() throws Throwable {
		try {
			Utility popup = new Utility();
			popup.popupclose();
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebElement FordPrivacy = driver.findElement(By.xpath(
					"//a[contains(@href,'http://www.forddirectprivacy.com/')]|//a[contains(@href,'https://www.forddirectprivacy.com')] | //a[contains(@href,'https://www.forddirect.com/privacy')]|//a[contains(@href,'/privacy-policy/')]"));
			js.executeScript("arguments[0].click();", FordPrivacy);
			int size = driver.getWindowHandles().size();
			if (size > 1) {
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				try {
					String FordpolicyTitle = driver
							.findElement(
									By.xpath("//h2[contains(@class,'terms')] | //h1[contains(@class,'store-name')]"))
							.getText();
					if (FordpolicyTitle.contentEquals("FordDirect Privacy Statement")
							|| FordpolicyTitle.contentEquals("Privacy Policy")) {
						sheetData.add("Pass");
					} else {
						sheetData.add("Fail");
						sheetData.add("Failed to verify Ford Privacy");
					}

				} catch (Exception e) {
					boolean Zscaler = driver
							.findElement(By.xpath(
									"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
							.isDisplayed();
					if (Zscaler == true)
						sheetData.add("Pass");
					sheetData.add("Zscaler");
				}
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				try {
					String FordpolicyTitle = driver.findElement(By.xpath("//h2[contains(@class,'terms')]")).getText();
					if (FordpolicyTitle.contentEquals("FordDirect Privacy Statement")) {
						sheetData.add("Pass");
						sheetData.add("Open in sameTab");
					} else {
						sheetData.add("Fail");
						sheetData.add("Failed to verify Ford Privacy");
					}
				} catch (Exception e) {
					boolean Zscaler = driver
							.findElement(By.xpath(
									"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
							.isDisplayed();
					if (Zscaler == true)
						sheetData.add("Pass");
					sheetData.add("Zscaler in samepage");
				}
			}
		} catch (Exception e) {
			boolean Zscaler = driver
					.findElement(
							By.xpath("//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
					.isDisplayed();
			if (Zscaler == true)
				sheetData.add("Zscaler");
		}
	}

	public void termsandcondition() {
		try {
			Utility popup = new Utility();
			popup.popupclose();
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
			WebElement terms = driver.findElement(By.xpath(
					"//a[contains(@href,'https://www.forddirect.com/dealerconnection-terms')]|//a[contains(@href,'https://www.forddirectprivacy.com/dcterms.html')]|//span[contains(normalize-space(),'Terms & Conditions')]"));
			js.executeScript("arguments[0].click();", terms);
			int size = driver.getWindowHandles().size();
			if (size > 1) {
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs2.get(1));
				Thread.sleep(5000);
				try {
					WebElement TermsandCondition = driver
							.findElement(By.xpath("//h1[normalize-space()='DealerConnection Terms and Conditions']"));
					if (TermsandCondition.isDisplayed() || TermsandCondition.isEnabled() == true) {
						sheetData.add("Pass");
						Logfile.info("T&C present and open in new tab");
					} else {
						sheetData.add("Fail");
						sheetData.add("Failed to verify Ford Privacy");
					}

				} catch (Exception e) {
					boolean Zscaler = driver
							.findElement(By.xpath(
									"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
							.isDisplayed();
					if (Zscaler == true)
						sheetData.add("Pass");
					sheetData.add("Zscaler");
				}
				Thread.sleep(2000);
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			} else {
				try {
					WebElement TermsandCondition = driver
							.findElement(By.xpath("//h1[normalize-space()='DealerConnection Terms and Conditions']"));
					if (TermsandCondition.isDisplayed() || TermsandCondition.isEnabled() == true) {
						sheetData.add("Pass");

						Logfile.info("T&C present and open in new tab");
					} else {
						sheetData.add("Fail");
						sheetData.add("Failed to verify Ford Privacy");
					}
				} catch (Exception e) {
					boolean Zscaler = driver
							.findElement(By.xpath(
									"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
							.isDisplayed();
					if (Zscaler == true)
						sheetData.add("Pass");
					sheetData.add("Zscaler in same page");
				}
			}
		} catch (Exception e) {
			boolean Zscaler = driver
					.findElement(
							By.xpath("//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
					.isDisplayed();
			if (Zscaler == true)
				sheetData.add("Zscaler");
		}

	}

	public void Copyright() {

		Utility popup = new Utility();
		popup.popupclose();
		// Actions a = new Actions(driver);
		// a.keyDown(Keys.CONTROL).sendKeys(Keys.END).build().perform();
		// WebElement FordDirect =
		// driver.findElement(By.xpath("//span[contains(@class,'copyrightProvider')
		// ]"));
		try {
			WebElement Copyright = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
					"//span[contains(@jsselect,'heading')]|//span[contains(normalize-space(),'Copyright © 2023 FordDirect')]|//p[contains(@class,'sb-header  ')]|//p[contains(normalize-space(),'Copyright © 2023 - FordDirect')]|//span[contains(@class,'credit')]|//span[contains(@class,'copyrightYear') ] |//span[contains(normalize-space(),'© 2023 FordDirect. All rights reserved.')]|//div[contains(@class,'sc-pjumZ sc-pJVnX sc-pkURi gihEOX')] |//span[contains(normalize-space(),'Copyright © 2023 FordDirect. All Rights Reserved.')]"))));
			// WebElement Copyright = driver.findElement(By.xpath(
			// "//span[contains(@jsselect,'heading')]|//span[contains(normalize-space(),'Copyright
			// © 2023 FordDirect')]|//p[contains(@class,'sb-header
			// ')]|//p[contains(normalize-space(),'Copyright © 2023 -
			// FordDirect')]|//span[contains(@class,'credit')]|//span[contains(@class,'copyrightYear')
			// ] |//span[contains(normalize-space(),'© 2023 FordDirect. All rights
			// reserved.')]|//div[contains(@class,'sc-pjumZ sc-pJVnX sc-pkURi gihEOX')]
			// |//span[contains(normalize-space(),'Copyright © 2023 FordDirect. All Rights
			// Reserved.')]"));
			Thread.sleep(2000);
			if (Copyright.isDisplayed() || Copyright.isEnabled()) {
				sheetData.add("Pass");
				sheetData.add("Copyright is Present");
				Logfile.info("Copyright is present");
			} else {
				sheetData.add("Fail");
				sheetData.add("Copyright is Not Present");
				Logfile.info("Copyright is Not present");
			}
		} catch (Exception n) {
			sheetData.add("Fail");
			try {
				if (driver.findElement(By.xpath("//h2[contains(@id,'challenge-running') ]")).isDisplayed() || driver
						.findElement(By.xpath("//h2[contains(@id,'challenge-running') ]")).isDisplayed() == true) {
					sheetData.add("checking site secure");
				}
			} catch (Exception ww) {
				try {
					if (driver
							.findElement(By.xpath("//h1[contains(normalize-space(),'Your connection is not private')]"))
							.isDisplayed()
							|| driver
									.findElement(By.xpath(
											"//h1[contains(normalize-space(),'Your connection is not private')]"))
									.isDisplayed() == true) {
						sheetData.add("Private Connection");
					}
				} catch (Exception r) {
					try {
						if (driver.findElement(By.xpath("//span[contains(@jsselect,'heading')]")).isDisplayed()
								|| driver.findElement(By.xpath("//span[contains(@jsselect,'heading')]"))
										.isDisplayed() == true) {
							sheetData.add("Site cant Reach");
						}
					} catch (Exception t) {
						boolean Zscaler = driver
								.findElement(By.xpath(
										"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
								.isDisplayed();
						if (Zscaler == true)
							sheetData.add("Zscaler");
					}
				}
				Logfile.info("Copyright is Not present");
				Logfile.info("Locator mismatch");
			}

		}

	}

	public void SocialMedial() {
		Utility popup = new Utility();
		popup.popupclose();
		boolean Facebook=false;
		boolean Youtube=false;
		boolean Instagram=false;
		boolean Twitter=false;

		try {
			try {
				Thread.sleep(2000);
				Facebook = driver.findElement(By.xpath("//a[contains(@href,'https://www.facebook.com/')]")).isDisplayed();
				if (Facebook==true) {
					sheetData.add("Facebook Icon is Present");
				}
					else
					{
						sheetData.add("Facebook Icon is Not Present");
					}
				
			} catch (Exception q) {
				sheetData.add("Facebook Icon is Not Present");
			}
			try {
				Thread.sleep(2000);
				Youtube = driver.findElement(By.xpath(
						"//a[contains(@aria-label,'Youtube')]|//a[contains(@href,'https://www.youtube.com/')] |//div[contains(@data-app,'youtube')]")).isDisplayed();

				if (Youtube==true) {
					sheetData.add("Youtube Icon is Present");
				}
				else
				{
					sheetData.add("Youtube Icon  is Not Present");
				}
			} catch (Exception q) {
				sheetData.add("Youtube Icon is Not Present");
			}
			try {
				Thread.sleep(2000);
				Twitter = driver.findElement(By.xpath("//a[contains(@href,'https://twitter.com/')]")).isDisplayed();
				if (Twitter==true) {
					sheetData.add("Twitter Icon is Present");
				}
				else
				{
					sheetData.add("Twitter Icon  is Not Present");
				}
			} catch (Exception q) {
				sheetData.add("Twitter Icon is Not Present");
			}
			try {
				Thread.sleep(2000);
				Instagram = driver.findElement(By.xpath("//a[contains(@href,'https://www.instagram.com/')]")).isDisplayed();
				if (Instagram==true) {
					sheetData.add("Instagram Icon is Present");
				}
				else
				{
					sheetData.add("Instagram Icon  is Not Present");
				}
			} catch (Exception q) {
				sheetData.add("Instagram Icon is Not Present");
			}
		
			
			if ( Facebook && Instagram && Youtube && Twitter==true)
			{
				sheetData.add("Pass");
			}
			else
			{
				sheetData.add("Fail Some link Missing");
			}
		} 
		catch (Exception eq) {
			sheetData.add("Fail");
			try {
				if (driver.findElement(By.xpath("//h2[contains(@id,'challenge-running') ]")).isDisplayed() || driver
						.findElement(By.xpath("//h2[contains(@id,'challenge-running') ]")).isDisplayed() == true) {
					sheetData.add("checking site secure");
				}
			} catch (Exception ww) {
				try {
					if (driver
							.findElement(By.xpath("//h1[contains(normalize-space(),'Your connection is not private')]"))
							.isDisplayed()
							|| driver
									.findElement(By.xpath(
											"//h1[contains(normalize-space(),'Your connection is not private')]"))
									.isDisplayed() == true) {
						sheetData.add("Private Connection");
					}
				} catch (Exception r) {
					try {
						if (driver.findElement(By.xpath("//span[contains(@jsselect,'heading')]")).isDisplayed()
								|| driver.findElement(By.xpath("//span[contains(@jsselect,'heading')]"))
										.isDisplayed() == true) {
							sheetData.add("Site cant Reach");
						}
					} catch (Exception t) {
						boolean Zscaler = driver
								.findElement(By.xpath(
										"//*[contains(@src,'https://login.zscalertwo.net:443/__zsig/DNSP0qr2RtJj6')]"))
								.isDisplayed();
						if (Zscaler == true)
							sheetData.add("Zscaler");
					}
				}
				Logfile.info("Locator mismatch");
			}
		}
	}

	// a[@title='Pinterest'] -.//a[contains(@href,'https://www.pinterest.com/')]
	// a[@title='Twitter'] -> //a[contains(@href,'https://twitter.com/')]
	// a[@title='Instagram'] ->//a[contains(@href,'https://www.instagram.com/')]
	// a[@title='Youtube'] ->//a[contains(@href,'https://www.youtube.com/')]
	// ||//div[contains(@data-app,'youtube')]
	// a[@title='Facebook'] ->//a[contains(@href,'https://www.facebook.com/')]

}
