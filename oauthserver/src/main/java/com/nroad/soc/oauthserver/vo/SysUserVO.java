package com.nroad.soc.oauthserver.vo;

import com.nroad.soc.oauthserver.entity.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class SysUserVO extends SysUser {

    private List<String> authorityList;

}
