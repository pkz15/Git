package Utility;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Logfile extends Driver  {
	static Logger log = LogManager.getLogger(Logfile.class.getName());

	public static void info(Object Message) {
		log.info(Message);
	}

	public static void main(String[] args) {
		
		PropertyConfigurator.configure(currentDirectory+"\\src\\main\\resources\\log4j.properties");
	}

}
