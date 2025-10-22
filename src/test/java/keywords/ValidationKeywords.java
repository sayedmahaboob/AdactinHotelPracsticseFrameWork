package keywords;

import org.testng.Assert;
import org.testng.asserts.Assertion;

public class ValidationKeywords extends GenericKeywords {
	public void verifyTile(String title) {
		Assert.assertEquals(getsTitle(), title);
	}

}
