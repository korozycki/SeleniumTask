package kroz.SeleniumTask.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.io.File.separator;
import static java.lang.System.getProperty;

import java.util.concurrent.TimeUnit;

public class SeleniumProvider {

	private static WebDriver driver;

	public static void initialize() {

		System.setProperty("webdriver.chrome.driver",
				getProperty("user.dir") + separator
						+ "src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver get() {
		return driver;
	}

	public static void quit() {

		if (driver != null) {

			driver.quit();
			driver = null;
		}
	}
}
