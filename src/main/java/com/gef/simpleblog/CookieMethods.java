package com.gef.simpleblog;

import javax.servlet.http.*;


public class CookieMethods {
    
    public static boolean isUserCookiePresent(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("user")) {
                return true;
            }
        }
        return false;
    }

    static String getUserName(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals("user")) {
                return cookie.getValue();
            }
        }
        return "";
    }
    
}
