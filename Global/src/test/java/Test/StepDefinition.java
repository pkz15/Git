package Test;

import Functionality.ReadWriteExcel;
import Functionality.gd;
import Utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	@Given("Open Broswer")
	public void open_broswer() {
		Driver driver = new Driver();
		driver.OpenBrowswe();
	}

	@When("Read Data From Excel")
	public void read_data_from_excel() throws Exception {
		ReadWriteExcel Read = new ReadWriteExcel();
		Read.Read();
	}

	@And("gd Verfication")
	public void Car_type() throws Throwable {
		gd smartt = new gd();
		smartt.SocialMedial();
		
	}
	@And("Recursion")
	public void Recursion() throws Throwable {
		ReadWriteExcel Write = new ReadWriteExcel();
		Write.write();
	}

	@Then("Close Browser")
	public void close_browser() throws Exception {
		Driver driver = new Driver();
		driver.closeBrowser();
	}
}
