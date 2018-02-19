package javaModel;

public enum MenuElements {
    INDEX("Main page", "/jokes"),
    REGISTER("User registration", "/register"),
    LOGIN("log in page", "/login"),
    LOGOUT("logout", "/logout");


    private String elementName;
    private String url;


    MenuElements(String elementName, String url) {
        this.elementName = elementName;
        this.url = url;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
