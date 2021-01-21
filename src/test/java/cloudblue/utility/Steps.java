package cloudblue.utility;

import cloudblue.utility.browser.Browser;

public class Steps {
    protected Browser browser;
    public Steps() {
        browser = Browser.getBrowserInstance();
    }
}
