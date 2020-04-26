package com.nroad.soc.oauthserver.service;

import com.nroad.soc.oauthserver.entity.SysUser;

public interface UserService {

    SysUser getByUsername(String username);
}
