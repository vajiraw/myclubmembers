package com.managment.members.service;

import java.util.List;

import com.managment.members.domain.SysUser;

public interface UserService {
	
	public void createSysUser(SysUser sysUser);
	public List<SysUser>  getAllUsers();

}
