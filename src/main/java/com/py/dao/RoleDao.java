package com.py.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.py.entity.Admin;
import com.py.entity.Role;

@Repository
public interface RoleDao {
	/**
	 * 通过管理员id查询角色信息
	 * @param admin
	 * @return
	 */
	public List<Role> selectRoleByAid(Admin admin);
	/**
	 * 通过角色id查询角色信息
	 * @param rid
	 * @return
	 */
	public Role selectRoleByRid(int rid);
	/**
	 * 查询所有的角色
	 * @return
	 */
	public List<Role> selectAllRoles();
	/**
	 * 添加角色
	 * @return
	 */
	public int insertRole(Role role);
	/**
	 * 通过角色id修改角色信息
	 * @return
	 */
	public int updateRoleInfoByRid(Role role);
	/**
	 * 通过角色id删除角色
	 * @param Rid
	 * @return
	 */
	public int deleteRoleByRid(int rid);
	/**
	 * 通过管理员id添加角色
	 * @param admin
	 * @return
	 */
	public int insertRolesByAdmin(Admin admin);
	/**
	 * 通过管理员id删除角色
	 * @param aid
	 * @return
	 */
	public int deleteRolesByAid(int aid);
}
