import base.BaseTest;
import org.testng.annotations.Test;
import pagess.NavBar;

public class NavBarTest extends BaseTest {

    @Test
    public void NavBar() throws InterruptedException {
        NavBar navBar = new NavBar(driver);
        navBar.goHomePage();
        navBar.goContactPage();
//        navBar.goAboutPage();
//        navBar.goCartPage();
//        navBar.goLoginPage();
//        navBar.goSingPage();
    }
}
