package kroz.SeleniumTask.utils;

import kroz.SeleniumTask.pages.Github.GithubPage;

public class PageFactory {

	private GithubPage githubPage;
	public GithubPage getGitHab() {
		githubPage = new GithubPage();
		return githubPage;
	}
}
