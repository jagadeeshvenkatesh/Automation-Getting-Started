package org.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by shantonu on 5/9/16.
 */
public abstract class PageBase {
    private String name;
    private  String url;
    protected WebDriver driver;

    private PageBase(){

    }
    public PageBase(WebDriver aDriver){
        this.driver =aDriver;
        initElement(this);
    }
    public <T extends PageBase> void initElement(T t){
        PageFactory.initElements(driver,t);
    }

    public PageBase load(){
        driver.get(url);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
