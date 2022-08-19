import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCalc {
    @Test
    public void test_calc() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");

        Select selectFirstElement = new Select(driver.findElement(By.id("selectBuild")));
        selectFirstElement.selectByVisibleText("Prototype");

        WebElement firstInput = driver.findElement(By.id("number1Field"));
        firstInput.sendKeys("2");

        WebElement secondInput = driver.findElement(By.id("number2Field"));
        secondInput.sendKeys("3");

        Select selectSecondElement = new Select(driver.findElement(By.id("selectOperationDropdown")));
        selectSecondElement.selectByVisibleText("Subtract");

        WebElement buttonResult = driver.findElement(By.id("calculateButton"));
        buttonResult.click();

        WebElement answerInput = driver.findElement(By.id("numberAnswerField"));
        String res = answerInput.getAttribute("value");
        System.out.println("В поле Answer значение равно: "+res);
        Assert.assertEquals(res, "-1");
        if (res.equals("-1")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }
}
