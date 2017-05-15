package com.gef.simpleblog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import static org.testng.Assert.*;
import org.testng.annotations.*;


public class UnitTests extends Mockito {
    
    /*@Test
    public void mockitoExample() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }
    
    @Test
    public void exampleTest() {
        List list = new ArrayList();
        list.add("one");
        
        Assert.assertEquals(list.get(0), new ArrayList().get(0));
    }*/
    
    @Test
    public void simpleServletTest() throws ServletException, IOException{
        
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);
        
        //when(req.getParameter("user")).thenReturn("admin");
        //when(req.getParameter("password")).thenReturn("admin");
        PrintWriter writer = new PrintWriter("test.txt");
        when(res.getWriter()).thenReturn(writer);
        
        new TestServlet().doGet(req, res);
        
        
        
        assertTrue(true);
    }
    
}
