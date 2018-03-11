
package kroz.SeleniumTask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import kroz.SeleniumTask.utils.SeleniumProvider;

public class GeneralPage {

	private WebDriver driver = SeleniumProvider.get();

	public void waitForPage() {
		WebDriverWait wait = new WebDriverWait(SeleniumProvider.get(), 60);

		try {
			wait.until((WebDriver driver) -> {
				return ((JavascriptExecutor) driver)
						.executeScript("return document.readyState")
						.equals("complete");
			});
		} catch (Exception e) {
			throw new RuntimeException(
					"After: " + 60 + "seconds page didn't load completly");
		}
	}
	public void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void waitForElementToBeEnabled(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement getLinkByVivibleText(String linkName) {
		return driver
				.findElement(By.xpath("//a[contains(.,'" + linkName + "')]"));
	}
}