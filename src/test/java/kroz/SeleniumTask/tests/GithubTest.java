package kroz.SeleniumTask.tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import kroz.SeleniumTask.utils.SeleniumProvider;
import static kroz.SeleniumTask.utils.Page.*;

public class GithubTest {
	private final WebDriver driver = SeleniumProvider.get();

	private final String USER_ONE = "testUser66688";

	private final String USER_TWO = "testUser0009998";

	private final String PASSWORD = "op$$#dfDF44#";

	private final String URL = "https://github.com/";

	private final String REPOSITORY_NAME = "New-repository";

	private final String FILE_NAME = "NewFile";

	private final String SEARCH = "testUser66688/New-repository";

	private final String NO_REPOSITORY_MESSAGE = "We couldn’t find any repositories matching 'testUser66688/New-repository'";

	@BeforeClass
	public static void before() {
		SeleniumProvider.initialize();
	}

	@Test
	public void gitHubTest() throws InterruptedException {
		// Navigate to GitHub
		driver.get(URL);

		// Click Sing In button
		getPage().getGitHab().getSingInButton().click();

		// Enter user name
		getPage().getGitHab().getLoginTextbox().sendKeys(USER_ONE);

		// Enter password
		getPage().getGitHab().getPasswordTextbox().sendKeys(PASSWORD);

		// Click submit button
		getPage().getGitHab().getSubmitButton().click();

		// Click header plus button
		getPage().getGitHab().getHederCreatePlusButton().click();

		// Click new repository button
		getPage().getGitHab().getHederCreateNewRepositoryButton().click();

		// Enter repository name
		getPage().getGitHab().getRepositoryNameTextbox()
				.sendKeys(REPOSITORY_NAME);
		getPage().getGitHab().getRepositoryDescriptionTextbox().click();

		// Click create new repository button
		getPage().getGitHab().waitForElementToBeEnabled(
				getPage().getGitHab().getCreateRepositoryButton());
		getPage().getGitHab().getCreateRepositoryButton().click();

		// Create README file
		getPage().getGitHab().getLinkByVivibleText("README").click();
		getPage().getGitHab().getCommitButton().click();

		// Click create new file
		getPage().getGitHab().getCreateNewFileButton().click();

		// Enter file name
		getPage().getGitHab().getNewFileTextbox().sendKeys(FILE_NAME);

		// Click new branch checkbox
		getPage().getGitHab().getCreatNewBranchCheckbox().click();

		// Click commit
		getPage().getGitHab().getCommitButton().click();

		// Click pull request
		getPage().getGitHab().getCreatNewPullRequest().click();

		// Sing out
		getPage().getGitHab().getHederProfileButton().click();
		getPage().getGitHab().getHederSignOutButton().click();

		// Click Sing IN button
		getPage().getGitHab().getSingInButton().click();

		// Enter password
		getPage().getGitHab().getLoginTextbox().sendKeys(USER_TWO);

		// Enter password
		getPage().getGitHab().getPasswordTextbox().sendKeys(PASSWORD);

		// Click submit button
		getPage().getGitHab().getSubmitButton().click();

		// Search repository
		getPage().getGitHab().getSearchTextbox().sendKeys(SEARCH);
		getPage().getGitHab().getSearchTextbox().sendKeys(Keys.ENTER);

		// Click repository link
		getPage().getGitHab().getLinkByVivibleText(SEARCH).click();

		// Click pull request button
		getPage().getGitHab().getPullRequestButton().click();

		// Click pull request link
		getPage().getGitHab().getLinkByVivibleText(FILE_NAME).click();

		// Click file changed
		getPage().getGitHab().getFilesChangedButton().click();

		// Clik Review changes
		getPage().getGitHab().getReviewChangesButton().click();

		// Click approve button
		getPage().getGitHab().getApprovedCheckbox().click();

		// Click submit review
		getPage().getGitHab().getSubmitReviewButton().click();

		// Sing out
		getPage().getGitHab().getHederProfileButton().click();
		getPage().getGitHab().getHederSignOutButton().click();

		// Click Sing IN button
		getPage().getGitHab().getSingInButton().click();

		// Enter user name
		getPage().getGitHab().getLoginTextbox().sendKeys(USER_ONE);

		// Enter password
		getPage().getGitHab().getPasswordTextbox().sendKeys(PASSWORD);

		// Click submit button
		getPage().getGitHab().getSubmitButton().click();

		// Search repository
		getPage().getGitHab().getSearchTextbox().sendKeys(SEARCH);
		getPage().getGitHab().getSearchTextbox().sendKeys(Keys.ENTER);

		// Click repository link
		getPage().getGitHab().getLinkByVivibleText(SEARCH).click();

		// Click pull request button
		getPage().getGitHab().getPullRequestButton().click();

		// Click pull request link
		getPage().getGitHab().getLinkByVivibleText(FILE_NAME).click();

		// Verify that pull request is approved
		Assert.assertTrue("Page not contains expected text",
				getPage().getGitHab().getRevieverApparovedStatus(USER_TWO)
						.isDisplayed());

		// Click Settings button
		getPage().getGitHab().getSettingsButton().click();

		// Clcik Delete repository button
		getPage().getGitHab().getDeleteRepositoryButton().click();

		// Verify that confirmation dialog is Displayed
		assertTrue("Delete repository Dialog is not displayed", getPage()
				.getGitHab().getDeleteRepositoryDialog().isDisplayed());

		// Confirm repository name
		getPage().getGitHab().getDialogConfirmNameTextbox().clear();
		getPage().getGitHab().getDialogConfirmNameTextbox()
				.sendKeys(REPOSITORY_NAME);

		// Verify that delete button is enabled
		assertTrue(
				getPage().getGitHab().getDeleteRepositoryDialog().isEnabled());

		// Click delete button
		getPage().getGitHab().getDialogDeleteButton().click();

		// Search repository
		getPage().getGitHab().getSearchTextbox().sendKeys(SEARCH);
		getPage().getGitHab().getSearchTextbox().sendKeys(Keys.ENTER);

		// Verify that repository was removed
		assertEquals(getPage().getGitHab().getNoFoundRepositoryMessage(),
				NO_REPOSITORY_MESSAGE);
	}

	@AfterClass
	public static void after() {
		SeleniumProvider.quit();
	}
}
