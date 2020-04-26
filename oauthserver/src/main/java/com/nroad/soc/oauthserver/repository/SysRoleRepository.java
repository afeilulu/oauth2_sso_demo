package com.nroad.soc.oauthserver.repository;

import com.nroad.soc.oauthserver.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysRoleRepository extends JpaSpecificationExecutor<SysRole>, JpaRepository<SysRole, Integer> {

    @Query(value = "SELECT * FROM sys_role WHERE id IN (:ids)", nativeQuery = true)
    List<SysRole> findByIds(@Param("ids") List<Integer> ids);

}
