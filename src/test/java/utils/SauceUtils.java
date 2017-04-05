package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;

public class SauceUtils {

	@Value("${local.server.port}")
	protected int port;
	
	static public WebDriver getDriver() {
		String sauceUser;
		String saucePassword;
		
		sauceUser = System.getenv("SAUCE_USERNAME");
		saucePassword = System.getenv("SAUCE_ACCESS_KEY");
		//sauceUser = "dashboard2b";
		//saucePassword = "176d6582-28d1-41ab-8982-97fbce376c55";
		URL saucelabs = null;
		
		DesiredCapabilities capabilities;
		
		WebDriver driver;
		if (sauceUser != null && saucePassword != null && !sauceUser.isEmpty() && !saucePassword.isEmpty()) {
			try {
				saucelabs = new URL("http://" + sauceUser + ":" + saucePassword + "@ondemand.saucelabs.com/wd/hub");
			} catch (MalformedURLException e) {
				System.out.println("URI Sauce mal formada");
			}

			DesiredCapabilities capabilities1 = DesiredCapabilities.firefox();
			capabilities1.setCapability("platform", "Windows 10");
			capabilities1.setCapability("version", "43.0");
			capabilities1.setCapability("tunnel-identifier", System.getenv("TRAVIS_JOB_NUMBER"));
			driver = new RemoteWebDriver(saucelabs, capabilities1);
		} else {
			driver = new HtmlUnitDriver();
		}
		
		return driver;
	}
}
