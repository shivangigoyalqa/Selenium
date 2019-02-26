package com.selenium;

import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest 
    
{
  @Test
  public void TestExample() {
	  String search="QA InfoTech";
	  WebDriver driver = new ChromeDriver(); 
      driver.get("http://www.google.com"); 
      WebElement element = driver.findElement(By.name("q"));
    element.sendKeys(search);
      element.submit();
      java.util.List<WebElement> results = driver.findElements(By.cssSelector(".r"));
      System.out.println(results.get(1).getText());
      Assert.assertTrue(results.get(1).getText().contains(search), "Search result validation failed");
      
     }
  
  @Test
  public void testList() {
	  WebDriver driver = new ChromeDriver(); 
      driver.get("http://10.0.14.57:9292");
      WebElement temp = driver.findElement(By.className("heading"));
      List<WebElement> refList = driver.findElements(By.tagName("a"));

       for(WebElement we : refList) {
           
           try {
        	   HttpURLConnection huc = null;
        	   String url=we.getAttribute("href");
               huc = (HttpURLConnection)(new URL(we.getAttribute("href")).openConnection());
               
               huc.setRequestMethod("HEAD");
               
               huc.connect();
               int respCode=200;
               respCode = huc.getResponseCode();
               
               if(respCode!=200){
                   System.out.println(url+" is a broken link");
                   
               }
               else{
                   System.out.println(url+" is a valid link");
               }
           }catch (Exception e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
       }
       }
                 
       
//      List<String> result =new ArrayList<String>();
//      result.add("/abtest");
//      result.add("/basic_auth");
//      result.add("/broken_images");
//      result.add("/challenging_dom");
//      result.add("/checkboxes");
//      result.add("/context_menu");
//      result.add("/disappearing_elements");
//      result.add("/drag_and_drop");
//      result.add("/dropdown");
//      result.add("/dynamic_content");
//      result.add("/dynamic_controls");
//      result.add("/dynamic_loading");
//      result.add("/exit_intent");
//      result.add("/download");
//      result.add("/upload");
//      result.add("/floating_menu");
//      result.add("/forgot_password");
//      result.add("/login");
//      result.add("/frames");
//      result.add("/geolocation");
//      result.add("/horizontal_slider");
//      result.add("/hovers");
//      result.add("/infinite_scroll");
//      result.add("/jqueryui/menu");
//      result.add("/javascript_alerts");
//      result.add("/javascript_error");
//      result.add("/key_presses");
//      result.add("/large");
//      result.add("/windows");
//      result.add("/nested_frames");
//      result.add("/notification_message_rendered");
//      result.add("/redirector");
//      result.add("/download_secure");
//      result.add("/shifting_content");
//      result.add("/slow");
//      result.add("/tables");
//      result.add("/status_codes");
//      result.add("/typos");
//      result.add("/tinymce");
//     
      
     
      //Assert.assertEquals(result,list);

       }
  
      }
  

