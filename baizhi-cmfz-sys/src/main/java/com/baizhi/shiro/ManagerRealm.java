package com.baizhi.shiro;

import com.baizhi.dao.ManagerDAO;
import com.baizhi.dao.PerssionDAO;
import com.baizhi.dao.RoleDAO;
import com.baizhi.entity.Manager;
import com.baizhi.entity.Perssion;
import com.baizhi.entity.Role;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/6/20.
 */
public class ManagerRealm extends AuthorizingRealm{

    @Autowired
    private ManagerDAO managerDAO;
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private PerssionDAO perssionDAO;

    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Manager manager = managerDAO.selectByUsername((String) principals.getPrimaryPrincipal());
        List<Role> roles = roleDAO.selectByManaId(manager.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //授予登录用户角色
        for (Role role : roles) {
            simpleAuthorizationInfo.addRole(role.getRole());
            //授予登录用户权限
            List<Perssion> perssions = perssionDAO.selectByRoleId(role.getId());
            for (Perssion perssion : perssions) {
                simpleAuthorizationInfo.addStringPermission(perssion.getResource()+":"+perssion.getName());
            }
        }
        return simpleAuthorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        Manager manager = managerDAO.selectByUsername((String) token.getPrincipal());
        if(manager != null){

            return new SimpleAuthenticationInfo(manager.getUsername(),manager.getPwd(),
                    ByteSource.Util.bytes(manager.getSalt()),this.getName());
        }

        return null;
    }
}
