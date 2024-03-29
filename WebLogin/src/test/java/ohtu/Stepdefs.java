package ohtu;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {
    //WebDriver driver = new ChromeDriver();
    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567";
    
    @Given("login is selected")
    public void loginIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("login"));       
        element.click();   
    } 
    
    @Given("command new user is selected")
    public void newUserIsSelected() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.linkText("register new user"));       
        element.click();   
    } 

    @When("a valid username {string} and password {string} and matching password confirmation are entered")
    public void aValidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
     createNewUser(username, password);
    }

    @When("an invalid username {string} and password {string} and matching password confirmation are entered")
    public void anInvalidUsernameAndPasswordAndMatchingPasswordConfirmationAreEntered(String username, String password) {
     createNewUser(username, password);
    }

    @When("correct username {string} and password {string} are given")
    public void correctUsernameAndPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }    
    
    @Then("user is logged in")
    public void userIsLoggedIn() {
        pageHasContent("Ohtu Application main page");
    }    
 
    @When("correct username {string} and incorrect password {string} are given")
    public void correctUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    } 
    
    @When("a valid username {string} and too short password {string} and matching password confirmation are entered")
    public void newUserFailsWithcorrectUsernameAndIncorrectPassword(String username, String password) {
        createNewUser(username, password);
    }
    
    @When("valid username {string} but nonmatching password {string} and passwordConfirmation {string} are entered")
    public void newUserFailsWithcorrectUsernameButNonMatchingPasswords(String username, String password, String passwordConfirmation) {
        createNewUserWithToPasswords(username, password, passwordConfirmation);
    } 
    
    @Then("user is not created and error message about password is reported")
    public void UserIsNotCreated() {
        pageHasContent("password should have at least 8 characters");
    } 
    
    @Then("user is not created and error message about passwords not matching is reported")
    public void UserIsNotCreated2() {
        pageHasContent("password and password confirmation do not match");
    }  
    
  

    @When("nonexistent username {string} and incorrect password {string} are given")
    public void nonexistentUsernameAndIncorrectPasswordAreGiven(String username, String password) {
        logInWith(username, password);
    }

    
    
    @Then("user is not logged in and error message is given")
    public void userIsNotLoggedInAndErrorMessageIsGiven() {
        pageHasContent("invalid username or password");
        pageHasContent("Give your credentials to login");

    } 
    
    @Then("a new user is created")
    public void newUserIsCreated() {
        pageHasContent("Welcome to Ohtu Application!");
    }  
    
    @Then("user is not created and error message is reported")
    public void newUserIsNotCreated() {
        pageHasContent("username should have at least 3 characters");
    }      

    
    @After
    public void tearDown(){
        driver.quit();
    }

    private void createNewUserWithToPasswords(String username, String password, String confirmPassword) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(confirmPassword);
        element = driver.findElement(By.name("signup"));
        element.submit();   
    }
        
    private void createNewUser(String username, String password) {
        assertTrue(driver.getPageSource().contains("Create username and give password"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(password);
        element = driver.findElement(By.name("signup"));
        element.submit();   
    }
 
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }
        
    private void logInWith(String username, String password) {
        assertTrue(driver.getPageSource().contains("Give your credentials to login"));
        WebElement element = driver.findElement(By.name("username"));
        element.sendKeys(username);
        element = driver.findElement(By.name("password"));
        element.sendKeys(password);
        element = driver.findElement(By.name("login"));
        element.submit();  
    } 
}
