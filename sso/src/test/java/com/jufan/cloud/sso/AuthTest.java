package com.jufan.cloud.sso;

import com.jufan.cloud.sso.domain.SysAuthority;
import com.jufan.cloud.sso.domain.SysRole;
import com.jufan.cloud.sso.domain.SysUser;
import com.jufan.cloud.sso.repository.SysAuthotityRepository;
import com.jufan.cloud.sso.repository.SysRoleRepository;
import com.jufan.cloud.sso.repository.SysUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthTest {

	@Autowired
	private SysUserRepository sysUserRepository;

	@Autowired
	private SysRoleRepository sysRoleRepository;

	@Autowired
	private SysAuthotityRepository sysAuthotityRepository;

	@Test
	public void insertTestUser() {
		//准备创建用户
		SysUser sysUser = new SysUser();
		sysUser.setUsername("mocker");
		sysUser.setPassword("$2a$10$D7GyWBL34McU.tQwOGmbruluKRLfdagx8UY/kJXZieIzqSY1lu7O6");
		sysUser.setFirstName("root");
		sysUser.setLastName("anonymous");
		sysUser.setEmail("huifumanlove@gmail.com");
		sysUser.setImageUrl("anonymous");
		//输入创建时间
		sysUser.setCreatedBy("mocker");
		sysUser.setCreatedDate(Instant.now());
		sysUserRepository.save(sysUser);
		//准备创建角色
		SysRole sysRole = new SysRole();
		sysRole.setName("管理员");
		sysRole.setValue("admin");
		sysRole.setCreatedBy("mocker");
		sysRole.setCreatedDate(Instant.now());
		sysRoleRepository.save(sysRole);
		//准备创建权限
		SysAuthority sysAuthority = new SysAuthority();
		sysAuthority.setName("测试权限");
		sysAuthority.setValue("test");
		sysAuthority.setCreatedBy("mocker");
		sysAuthority.setCreatedDate(Instant.now());
		sysAuthotityRepository.save(sysAuthority);

		//将角色赋予用户
		Set<SysRole> roles = new HashSet<>();
		roles.add(sysRole);
		sysUser.setRoles(roles);

		//将权限赋予角色
		Set<SysAuthority> authorities = new HashSet<>();
		authorities.add(sysAuthority);
		sysRole.setAuthorities(authorities);

		//保存创建
		sysUserRepository.save(sysUser);
		sysRoleRepository.save(sysRole);
		sysAuthotityRepository.save(sysAuthority);
	}
}