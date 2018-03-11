package kroz.SeleniumTask.pages.Github;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import kroz.SeleniumTask.pages.GeneralPage;
import kroz.SeleniumTask.utils.SeleniumProvider;

public class GithubPage extends GeneralPage {

	private WebDriver driver = SeleniumProvider.get();

	public WebElement getSingInButton() {
		return driver.findElement(By.xpath("//a[@href='/login']"));
	}

	public WebElement getLoginTextbox() {
		return driver.findElement(By.id("login_field"));
	}

	public WebElement getPasswordTextbox() {
		return driver.findElement(By.id("password"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}

	public WebElement getNewRepositoryButton() {
		return driver.findElement(
				By.xpath("//div[@id='your_repos']//a[@href='/new']"));
	}

	public WebElement getHederCreatePlusButton() {
		return driver
				.findElement(By.xpath("//summary[@aria-label='Create new…']"));
	}

	public WebElement getHederCreateNewRepositoryButton() {
		return driver.findElement(By
				.xpath("//a[@data-ga-click='Header, create new repository']"));
	}

	public WebElement getHederProfileButton() {
		return driver.findElement(
				By.xpath("//summary[@aria-label='View profile and more']"));
	}

	public WebElement getHederSignOutButton() {
		return driver.findElement(
				By.xpath("//button[contains(@data-ga-click,'sign out')]"));
	}

	public WebElement getRepositoryNameTextbox() {
		return driver.findElement(By.id("repository_name"));
	}

	public WebElement getRepositoryDescriptionTextbox() {
		return driver.findElement(By.id("repository_description"));
	}

	public WebElement getCreateRepositoryButton() {
		return driver.findElement(By
				.xpath("//button[@data-disable-with='Creating repository…']"));
	}

	public WebElement getSettingsButton() {
		return driver.findElement(By
				.xpath("//a[contains(@data-selected-links,'repo_settings')]"));
	}

	public WebElement getDeleteRepositoryButton() {
		return driver.findElement(By
				.xpath("//li[@class='Box-row']/button[contains(.,'Delete')]"));
	}

	public WebElement getDeleteRepositoryDialog() {
		return driver.findElement(
				By.xpath("//div[@aria-label='Are you absolutely sure?']"));
	}

	public WebElement getDialogConfirmNameTextbox() {
		return driver.findElement(By.xpath(
				"//input[contains(@aria-label,'delete this repository')]"));
	}

	public WebElement getDialogDeleteButton() {
		return driver.findElement(By.xpath(
				"//div[@aria-label='Are you absolutely sure?']//button[@type='submit']"));
	}

	public WebElement getCommitButton() {
		return driver.findElement(By.xpath(
				"//div[contains(@class,'file-commit-form')]//button[@type='submit']"));
	}

	public WebElement getCreateNewFileButton() {
		return driver.findElement(
				By.xpath("//button[@data-disable-with='Creating file…']"));
	}

	public WebElement getNewFileTextbox() {
		return driver.findElement(By.xpath("//input[@name='filename']"));
	}

	public WebElement getCreatNewBranchCheckbox() {
		return driver.findElement(
				By.xpath("//strong[.='new branch']/ancestor::label/input"));
	}

	public WebElement getCreatNewPullRequest() {
		return driver
				.findElement(By.xpath("//button[.='Create pull request']"));
	}

	public WebElement getSearchTextbox() {
		return driver
				.findElement(By.xpath("//input[@aria-label='Search GitHub']"));
	}

	public WebElement getPullRequestButton() {
		return driver.findElement(By.xpath("//span[.='Pull requests']"));
	}

	public WebElement getFilesChangedButton() {
		return driver.findElement(By.xpath(
				"//div[contains(@class,'tabnav')]//a[contains(@href,'/files')]"));
	}

	public WebElement getReviewChangesButton() {
		return driver.findElement(
				By.xpath("//button[contains(.,'Review changes')]"));
	}

	public WebElement getApprovedCheckbox() {
		return driver.findElement(By.xpath("//input[@value='approve']"));
	}

	public WebElement getSubmitReviewButton() {
		return driver
				.findElement(By.xpath("//button[contains(.,'Submit review')]"));
	}

	public WebElement getRevieverApparovedStatus(String revieverName) {
		return driver.findElement(By
				.xpath("//span[contains(@class,'reviewers-status') and contains(@aria-label,'"
						+ revieverName + " approved these changes')]"));
	}
	
	public String getNoFoundRepositoryMessage() {
		return driver.findElement(By
				.xpath("//div[@class='blankslate']//h3")).getText();
	}
	
}
