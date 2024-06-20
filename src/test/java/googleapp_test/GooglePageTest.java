package googleapp_test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.genericutility.BaseClass;
import com.example.pomrepo.GooglePage;

public class GooglePageTest extends BaseClass {

	@Test
	public void fetchTheTextOfSearchResults() throws IOException {

		driver.get(fileUtils.getPropertyKeyValue("url"));

		webdriverUtils.waitForATitle(driver, fileUtils.getPropertyKeyValue("title"));
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, fileUtils.getPropertyKeyValue("title"));

		GooglePage googlePage = new GooglePage(driver);

		googlePage.search(fileUtils.getPropertyKeyValue("text"));
		googlePage.clickBtn();

		webdriverUtils.waitForTitleContains(driver, "Google Search");
		actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Google Search"), "Page title is incorrect");
	}
}
