package com.example.todo.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieUtil {

    public static Cookie findCookie(HttpServletRequest request, String name){

        Cookie[] arr = request.getCookies();
        if(arr == null || arr.length == 0){
            return null;
        }

        Cookie result = null;

        for (Cookie ck:arr) {
            if(ck.getName().equals(name)){
                result = ck;
                break;
            }
        }
        return result;
    }
}
