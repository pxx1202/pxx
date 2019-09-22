package com.py.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.py.entity.Admin;
import com.py.entity.Priv;
import com.py.entity.Role;

@Repository
public interface PrivDao {
	/**
	 * 通过管理员id查询所有权限
	 * @param admin
	 * @return
	 */
	public List<Priv> selectPrivByAid(Admin admin);
	/**
	 * 通过角色id查询所有权限
	 * @param admin
	 * @return
	 */
	public List<Priv> selectPrivByRid(int rid);
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public List<Priv> selectAllPrivs();
	/**
	 * 通过角色添加角色权限
	 * @param role
	 * @return
	 */
	public int insertPrivByRid(Role role);
	/**
	 * 通过角色id删除角色权限
	 * @param rid
	 * @return
	 */
	public int deletePrivsByRid(int rid);
}
