package org.acoe.com.pages;

import org.acoe.com.enums.WaitStrategy;
import org.acoe.com.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

public final class AmazonHamburgerMenuPage extends BasePage {

    public void clickSubMenu(String subMenu) {
        String linkSubMenu = "//a[text()='%s']";
        String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, subMenu);
        click(By.xpath(newXpath), WaitStrategy.CLICKABLE, "Sub Menu: " + subMenu);
    }
}
