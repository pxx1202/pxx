package com.py.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.py.entity.Admin;

@Repository
public interface AdminDao {
	/**
	 * 通过用户名密码校验
	 * @param admin
	 * @return
	 */
	public Admin selectAdminByName(Admin admin);
	/**
	 * 修改管理员信息
	 * @param admin
	 * @return
	 */
	public int updateAdminInfo(Admin admin);
	/**
	 * 修改密码
	 * @param admin
	 * @return
	 */
	public int updateAdminPwd(Admin admin);
	/**
	 * 查询所有管理员用户
	 * @return
	 */
	public List<Admin> selectAllAdmin();
	/**
	 * 通过管理员id删除管理员信息
	 * @return
	 */
	public int deleteAdminByAid(int aid);
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public int insertAdmin(Admin admin);
	/**
	 * 通过管理员id查询所有信息
	 * @param aid
	 * @return
	 */
	public Admin selectAdminInfoByaid(int aid);
}
