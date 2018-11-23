package pageActions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumDriver;
import utils.SeleniumHelper;

public class CBOL_CommonActions_test {

	public final int ELEMENT_WAIT_TIME = 30;
	public final int MAX_RETRY = 3;
	 WebDriver driver;
	 
	public CBOL_CommonActions_test(){
    
}
	//---------------------------------------------------------------------
	//-----------------Send Keys and Value------------------------
	//---------------------------------------------------------------------
	
	public void CBOLPerformSendKeys(final WebElement e, String val) {
		//SeleniumHelper.waitForVisibilityofElement(e, 10);
		Actions action = new Actions(SeleniumDriver.getDriver());
		Actions seriesOfUIDAction = action.moveToElement(e).click();
		action.sendKeys(val);
		action.build().perform();	
	}

	public void CBOLPerformClick(final WebElement e){
		//SeleniumHelper.waitForVisibilityofElement(e, 10);
		Actions action = new Actions(SeleniumDriver.getDriver());
		Actions seriesOfUIDAction = action.moveToElement(e).click();
		action.click();
		action.build().perform();	
	}
	

    public String getText(final WebElement element) {
       return getText(element, ELEMENT_WAIT_TIME);
    }

    public String getText(final WebElement element, final int second) {
    
        String value = "";
        if (isTextPresent(element, 3)) {
            value = element.getText();
            value = StringUtils.defaultString(StringUtils.trim(value));
        }
        if (value.isEmpty()) {
            value = element.getAttribute("value");
            value = StringUtils.defaultString(StringUtils.trim(value));
        }
        if (value.isEmpty()) {
            value = element.getAttribute("innerHTML");
            value = StringUtils.defaultString(StringUtils.trim(value));
        }
        return value;
    }
	
    public boolean isTextPresent(final WebElement element, final int second) {
        try {
            waitForTextVisibilityOf(element, second);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    
    private void waitForTextVisibilityOf(final WebElement element) {
        waitForTextVisibilityOf(element, ELEMENT_WAIT_TIME);
    }

    private void waitForTextVisibilityOf(final WebElement element, final int second) {
        WebDriverWait wait = new WebDriverWait(driver, second);
        wait.until(ExpectedConditions.not(textEmpty(element)));
    }
    
    public static ExpectedCondition<Boolean> textEmpty(final WebElement element) {
        return new ExpectedCondition<Boolean>() {
            private String currentValue = null;

            @Override
            public Boolean apply(final WebDriver driver) {
                try {
                    currentValue = element.getText();
                    boolean matches = currentValue.isEmpty();
                    return matches;
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }
	
    public void selectByIndex(final WebElement element, final int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public void selectByVisible(final WebElement element, final String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    
    public void selectByVal(final WebElement element, final String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public boolean verifyElementAvailability(WebElement e){
    	return e.isDisplayed();
    }    
}
