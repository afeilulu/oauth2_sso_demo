package com.nroad.soc.oauthserver.service.impl;

import com.nroad.soc.oauthserver.entity.SysUser;
import com.nroad.soc.oauthserver.repository.SysUserRepository;
import com.nroad.soc.oauthserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public SysUser getByUsername(String username) {
        return sysUserRepository.findByUsername(username);
    }
}
