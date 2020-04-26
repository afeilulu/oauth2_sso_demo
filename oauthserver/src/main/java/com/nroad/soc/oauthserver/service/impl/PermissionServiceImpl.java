package com.nroad.soc.oauthserver.service.impl;

import com.nroad.soc.oauthserver.entity.SysPermission;
import com.nroad.soc.oauthserver.entity.SysRolePermission;
import com.nroad.soc.oauthserver.entity.SysUserRole;
import com.nroad.soc.oauthserver.entity.SysRole;
import com.nroad.soc.oauthserver.repository.SysPermissionRepository;
import com.nroad.soc.oauthserver.repository.SysRoleRepository;
import com.nroad.soc.oauthserver.repository.SysRolePermissionRepository;
import com.nroad.soc.oauthserver.repository.SysUserRoleRepository;
import com.nroad.soc.oauthserver.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysRolePermissionRepository sysRolePermissionRepository;
    @Autowired
    private SysPermissionRepository sysPermissionRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> rolePermissionList = sysRolePermissionRepository.findByRoleIds(roleIdList);
        if (CollectionUtils.isEmpty(rolePermissionList)) {
            return null;
        }
        List<Integer> permissionIdList = rolePermissionList.stream().map(SysRolePermission::getPermissionId).distinct().collect(Collectors.toList());
        List<SysPermission> sysPermissionList = sysPermissionRepository.findByIds(permissionIdList);
        if (CollectionUtils.isEmpty(sysPermissionList)) {
            return null;
        }
        return sysPermissionList;
    }

    @Override
    public List<SysRole> findRoleByUserId(Integer userId) {
        List<SysUserRole> sysUserRoleList = sysUserRoleRepository.findByUserId(userId);
        if (CollectionUtils.isEmpty(sysUserRoleList)) {
            return null;
        }
        List<Integer> roleIdList = sysUserRoleList.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        return sysRoleRepository.findByIds(roleIdList);
    }
}
