package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;

public class SauceUtils {

	@Value("${local.server.port}")
	protected int port;
	
	static public WebDriver getDriver() {
		String sauceUser;
		String saucePassword;
		
		//sauceUser = System.getenv("SAUCE_USERNAME");
		//saucePassword = System.getenv("SAUCE_ACCESS_KEY");
		sauceUser = "dashboard2b";
		saucePassword = "176d6582-28d1-41ab-8982-97fbce376c55";
		URL saucelabs = null;
		
		DesiredCapabilities capabilities;
		
		WebDriver driver;
		if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
			try {
				saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");
			} catch (MalformedURLException e) {
				System.out.println("URI Sauce mal formada");
			}

			capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("platform", "OS X 10.11");
			capabilities.setCapability("version", "45");
			capabilities.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
			capabilities.setCapability("name", "test");
			driver = new RemoteWebDriver(saucelabs, capabilities);
		} else {
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
}
