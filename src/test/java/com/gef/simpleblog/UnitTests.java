package com.gef.simpleblog;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;

import static org.testng.Assert.*;
import org.testng.annotations.*;


public class UnitTests {
    
    /**
     * Simple unit tests
     */
    
    @Test
    public void parser_whenEmptyString_ReturnsZero() {
        //Arrange
        
        
        //Act
        int result = Parser.parseAndSum("");
        
        //Assert
        assertEquals(result, 0);
    }
    
    @Test
    public void parser_whenSingleNumberInString_ReturnsThisNumber() {
        //Arrange
        
        
        //Act
        int result = Parser.parseAndSum("123");
        
        //Assert
        assertEquals(result, 123);
    }
    
    @Test
    public void parser_whenValidString_ReturnsResult() {
        //Arrange
        
        
        //Act
        int result = Parser.parseAndSum("1,2,3,4,5,6,7,8");
        
        //Assert
        assertEquals(result, 36);
    }
    
    
    /**
     * Mockito
     */
    
    @Test
    public void mockitoExample() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        //mockedList.clear();

        verify(mockedList).add("one");
        //verify(mockedList).clear();
    }
    
    @Test
    public void adminPanelServlet_doesSomething() throws ServletException, IOException {
        //Arrange
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        
        //Act
        TestServlet servlet = new TestServlet();
        servlet.doGet(req, res);
        
        //Assert
    }
    
}
