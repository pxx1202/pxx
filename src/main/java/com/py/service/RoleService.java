package com.py.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.py.entity.Admin;
import com.py.entity.Role;


public interface RoleService {
	/**
	 * 查询所有的角色
	 * @return
	 */
	public List<Role> selectAllRoles();
	/**
	 * 添加用户
	 * @param role
	 * @return
	 */
	public boolean insertRole(Role role);
	/**
	 * 通过角色id查询角色信息
	 * @param rid
	 * @return
	 */
	public Role selectRoleByRid(int rid);
	/**
	 * 修改角色信息
	 * @param rid
	 * @return
	 */
	public boolean updateRoleInfo(Role role);
	/**
	 * 通过角色id删除角色
	 * @param rid
	 * @return
	 */
	public boolean deleteRoleByRid(int rid);
}
