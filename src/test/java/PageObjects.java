import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

public class PageObjects {


    public PageObjects Search(String Search){
        Selenide.$(By.id(LocatorsStorage.DefaultSearch)).clear();
        Selenide.$(By.id(LocatorsStorage.DefaultSearch)).sendKeys(Search);
        return this;
    }

    public PageObjects Login (String Username, String Password){
        Selenide.$(By.id(LocatorsStorage.username)).sendKeys(Username);
        Selenide.$(By.id(LocatorsStorage.password)).sendKeys(Password);
        Selenide.back();
        Selenide.$(By.id(LocatorsStorage.accept)).click();
        return this;
    }


}
