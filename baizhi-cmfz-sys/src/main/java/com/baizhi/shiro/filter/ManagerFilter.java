package com.baizhi.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Created by Administrator on 2017/6/20.
 */
public class ManagerFilter extends AuthorizationFilter {


    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {

        Subject subject = getSubject(request, response);
        String roles[] = (String[]) mappedValue;

        if(roles==null || roles.length==0){
            return true;
        }

        for (String role : roles) {
            if(subject.hasRole(role)){
                return true;
            }
        }

        return false;
    }
}
