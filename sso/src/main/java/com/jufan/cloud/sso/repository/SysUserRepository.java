package com.jufan.cloud.sso.repository;


import com.jufan.cloud.sso.domain.SysUser;
import com.jufan.cloud.sso.repository.support.WiselyRepository;

import java.util.Optional;

public interface SysUserRepository extends WiselyRepository<SysUser,Long> {
    Optional<SysUser> findOneWithRolesByUsername(String username);
}
