package com.nroad.soc.oauthserver.repository;

import com.nroad.soc.oauthserver.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SysUserRepository extends JpaSpecificationExecutor<SysUser>, JpaRepository<SysUser, Integer> {

    SysUser findByUsername(String username);
}
