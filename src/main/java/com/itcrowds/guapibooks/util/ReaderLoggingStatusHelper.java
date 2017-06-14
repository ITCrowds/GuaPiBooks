package com.itcrowds.guapibooks.util;

import com.itcrowds.guapibooks.domain.Reader;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class ReaderLoggingStatusHelper {
    public boolean isLogin() {
        return !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken);
    }

    public Reader getLoginReader() {
        if (isLogin()) {
            return (Reader) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else {
            return null;
        }
    }
}
