package com.gef.simpleblog;

import java.io.IOException;
import java.sql.*;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import static org.testng.Assert.*;
import org.testng.annotations.*;

public class IntegrationTests {

    @Test
    public void homepageIsAvailableTest() throws IOException {
        //Given
        WebClient webclient = new WebClient();
        
        //When
        HtmlPage page = webclient.getPage("http://localhost:8084/SimpleBlog/");

        //Then
        assertEquals(page.getTitleText(), "SimpleBlog");
    }

    @Test
    public void checkPageIsAvailableUsingAPItest() throws IOException {
        //Given
        HttpUriRequest request = new HttpGet("http://localhost:8084/SimpleBlog/");
        
        //When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
        
        //Then
        assertEquals(httpResponse.getStatusLine().getStatusCode(),(HttpStatus.SC_OK));
        //HttpEntity entity = httpResponse.getEntity();
        //String responseString = EntityUtils.toString(entity, "UTF-8");
        //System.out.println(responseString);
    }
    
    @Test
    public void verifyDBisAvailable() throws ClassNotFoundException {
        //Given
        Class.forName("org.sqlite.JDBC");
        
        //When
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:sqlite:testdatabase.db");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM BLOG;");
        //Then
        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }
    
}