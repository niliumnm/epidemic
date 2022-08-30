package com.cdut.epidemicsyscontrolframework.security;

import org.springframework.security.core.Authentication;

public class AuthenticationContextHolder {
    private static final ThreadLocal<Authentication> contextHolder = new ThreadLocal<>();

    public static Authentication getContext(){
        return contextHolder.get();
    }

    public static void setContext(Authentication authentication){
        contextHolder.set(authentication);
    }

    public static void clearContext()
    {
        contextHolder.remove();
    }
}
