package Functionality;

import Utility.Driver;
import Utility.ExcelData;
import Utility.Logfile;

public class ReadWriteExcel extends Driver {
	String path = currentDirectory+"\\gd.xlsx";
	ExcelData data = new ExcelData(path);
	static int i=40;
	public void Read() throws Exception
	{
		i=i+1;
		String url =data.getData("Input", i);
		String Pacode = data.PAcode("Input", i);
		sheetData.add(Pacode);
		sheetData.add(url);
		driver.get(url);
		Logfile.info(i + " " + " getting url " + " " + url);
	}
	
	
	public void write() throws Throwable
	{
		try {
			int RowNumber = data.getRowcount("Input");
		if (i <= RowNumber) 
		{
			data.Writedata("Output SocialMedia", i, path);
			sheetData.removeAll(sheetData);
			Read();
			gd smartt = new gd();
			smartt.SocialMedial();
			write();
		}
		}
		catch(Exception e) {}
		
	}
}


