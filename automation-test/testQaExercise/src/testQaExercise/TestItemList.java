package testQaExercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*******************
 * Automation Test for QA Develpoer Exercise
 * (Only include functional testing for add item and remove item from the item list. 
 * Other testing like performance testing and browser testing are not include in this. )
 * 
 * @author
 * @since 2021/01/22
 */
public class TestItemList {
	WebDriver driver = null;
	String testUrl = "http://localhost:3000";
	WebDriverWait wait = null;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
	}

	@AfterClass
	public void teardown() {
		// driver.close();
		// driver.quit();
	}

	/*******************
	 * Add Item Test Case 1: Test add item with letter title (between 10 and 20
	 * characters)
	 */
	@Test
	public void testAddItemTC1() {

		driver.get(testUrl);
		addItem("abcdefghijk");
		boolean findResult = findElement("abcdefghijk");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 2: Test add item with number title (between 10 and 20
	 * characters)
	 */
	@Test
	public void testAddItemTC2() {

		driver.get(testUrl);
		addItem("12345678901");
		boolean findResult = findElement("12345678901");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 3: Test add item with Special characters title (between 10
	 * and 20 characters)
	 */
	@Test
	public void testAddItemTC3() {

		driver.get(testUrl);
		addItem("~!@#$%^&*()");
		boolean findResult = findElement("~!@#$%^&*()");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 4: Test add item with a title with space before it (letter
	 * between 10 and 20 characters, total > 20 characters )
	 */
	@Test
	public void testAddItemTC4() {

		driver.get(testUrl);
		addItem("         abcdefghijklmno");
		boolean findResult = findElement("abcdefghijklmno");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 5: Test add item with a title with space after it (letter
	 * between 10 and 20 characters, total > 20 characters )
	 */
	@Test
	public void testAddItemTC5() {

		driver.get(testUrl);
		addItem("abcdefghijklmno         ");
		boolean findResult = findElement("abcdefghijklmno");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 6: Test add item with a title (= 20 characters)
	 */
	@Test
	public void testAddItemTC6() {

		driver.get(testUrl);
		addItem("abcdefghijklmnopqrst");
		boolean findResult = findElement("abcdefghijklmnopqrst");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 7: Test add item with a title (> 20 characters)
	 */
	@Test
	public void testAddItemTC7() {

		driver.get(testUrl);
		addItem("abcdefghijklmnopqrstu");
		boolean findResult = findElement("abcdefghijklmnopqrstu");
		Assert.assertEquals(findResult, false);

		findResult = findElement("Title can be at most 20 characters.");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 8: Test add item with a title (= 10 characters)
	 */
	@Test
	public void testAddItemTC8() {

		driver.get(testUrl);
		addItem("abcdefghij");
		boolean findResult = findElement("abcdefghij");
		Assert.assertEquals(findResult, true);

	}

	/*******************
	 * Add Item Test Case 9: Test add item with a title (< 10 characters)
	 */
	@Test
	public void testAddItemTC9() {

		driver.get(testUrl);
		addItem("abcde");
		boolean findResult = findElement("abcde");
		Assert.assertEquals(findResult, false);

		findResult = findElement("Title must be at least 10 characters.");
		Assert.assertEquals(findResult, true);
	}

	/*******************
	 * Add Item Test Case 10: Test add item with a space title (between 10 and 20
	 * characters)
	 */
	@Test
	public void testAddItemTC10() {

		driver.get(testUrl);
		addItem("             ");
		boolean findResult = findElement("             ");
		Assert.assertEquals(findResult, false);

		findResult = findElement("Title must be at least 10 characters.");
		Assert.assertEquals(findResult, true);
	}

	/*******************
	 * Add Item Test Case 11: Test add item with a empty title
	 */
	@Test
	public void testAddItemTC11() {

		driver.get(testUrl);
		List<WebElement> removeBtns = driver.findElements(By.cssSelector("button.Item__remove"));
		int beforeAddItemsSize = removeBtns.size();

		addItem("");
		boolean findResult = findElement("");
		removeBtns = driver.findElements(By.cssSelector("button.Item__remove"));
		int afterAddItemsSize = removeBtns.size();
		Assert.assertEquals(beforeAddItemsSize, afterAddItemsSize);

		findResult = findElement("Title must be at least 10 characters.");
		Assert.assertEquals(findResult, true);
	}

	/*******************
	 * Remove Item Test Case: Remove the first item
	 */
	@Test
	public void testRemoveFirstItem() {

		driver.get(testUrl);
		List<WebElement> items = null;
		List<WebElement> removeBtns = driver.findElements(By.cssSelector("button.Item__remove"));
		removeBtns.get(0).click();

		items = driver.findElements(By.xpath("//*[text()='Wac, ft. Valeria - ¡°Tortoise¡±']"));
		Assert.assertEquals(items.size(), 0);
	}

	/*******************
	 * Remove Item Test Case: Remove the last item
	 */
	@Test
	public void testRemoveLastItem() {

		driver.get(testUrl);
		List<WebElement> items = null;
		List<WebElement> removeBtns = driver.findElements(By.cssSelector("button.Item__remove"));
		removeBtns.get(removeBtns.size() - 1).click();

		items = driver.findElements(By.xpath("//*[text()='Shugo Tokumaru - ¡°Lita-Ruta¡±']"));
		Assert.assertEquals(items.size(), 0);
	}

	/*******************
	 * Remove Item Test Case: Remove all items
	 */
	@Test
	public void testRemoveAllItems() {

		driver.get(testUrl);
		List<WebElement> items = null;
		List<WebElement> removeBtns = driver.findElements(By.cssSelector("button.Item__remove"));
		for (int i = 0; i < removeBtns.size(); i++) {
			removeBtns.get(0).click();
		}
		items = driver.findElements(By.cssSelector("div.Item"));
		Assert.assertEquals(items.size(), 0);
	}

	/**
	 * Add an item
	 * 
	 * @param itemName Item's name
	 */
	private void addItem(String itemName) {

		WebElement titleInput = driver.findElement(By.cssSelector("input[id='title']"));
		WebElement addBtn = driver.findElement(By.cssSelector("button.Form__add"));

		titleInput.sendKeys(itemName);
		addBtn.submit();

	}

	/**
	 * Find an element by elemnet's text
	 * 
	 * @param elementText Elemnet's text
	 * @return If the element is found return true, else return false.
	 */
	private boolean findElement(String elementText) {

		try {
			if (wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[text()='" + elementText + "']"))) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

	}
}
