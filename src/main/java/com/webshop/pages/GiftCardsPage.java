package com.webshop.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.webshop.driver.DriverScript;

public class GiftCardsPage extends DriverScript {

// ******************************************** Page Elements/Locators ****************************************//
	
	@FindBy(xpath = "//h1[text()='Gift Cards']") WebElement giftCardText;
	@FindBy(xpath = "//div[@class='product-grid']") WebElement productGrid;
	@FindBy(xpath = "//div[@class='product-grid']/div[@class='item-box']") List<WebElement> productItemBox;
	
	
// ******************************************** Page Initilization ********************************************//

	public GiftCardsPage() {
		PageFactory.initElements(driver, this);
	}

// ******************************************** Page Actions/Methods ******************************************//
	
	public String getGiftCardPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getGiftCardText()
	{
		return giftCardText.getText();
	}
	
	public boolean isProductGridDisplayed()
	{
		return productGrid.isDisplayed();
	}
	
	public int getProductItemCount()
	{
		return productItemBox.size();
	}
	
	

}
