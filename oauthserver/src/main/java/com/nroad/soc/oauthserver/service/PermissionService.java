package com.nroad.soc.oauthserver.service;

import com.nroad.soc.oauthserver.entity.SysPermission;
import com.nroad.soc.oauthserver.entity.SysRole;

import java.util.List;

public interface PermissionService {

    List<SysPermission> findByUserId(Integer userId);

    List<SysRole> findRoleByUserId(Integer userId);

}
