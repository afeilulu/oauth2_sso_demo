package com.nroad.soc.oauthserver.service;

import com.alibaba.fastjson.JSON;
import com.nroad.soc.oauthserver.domain.MyUser;
import com.nroad.soc.oauthserver.entity.SysPermission;
import com.nroad.soc.oauthserver.entity.SysUser;
import com.nroad.soc.oauthserver.entity.SysRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getByUsername(username);
        if (null == sysUser) {
            log.warn("用户{}不存在", username);
            throw new UsernameNotFoundException(username);
        }
        List<SysPermission> permissionList = permissionService.findByUserId(sysUser.getId());
        List<String> roleList = permissionService.findRoleByUserId(sysUser.getId()).stream().map(SysRole::getRoleCode).collect(Collectors.toList());;
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(permissionList)) {
            for (SysPermission sysPermission : permissionList) {
                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
            }
        }

        MyUser myUser = new MyUser(sysUser.getUsername(), passwordEncoder.encode(sysUser.getPassword()), authorityList);
        myUser.setRoles(roleList);

        log.info("登录成功！用户: {}", JSON.toJSONString(myUser));

        return myUser;
    }
}
