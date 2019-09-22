package com.py.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.py.entity.Admin;


public interface AdminService {
	/**
	 * 登录验证
	 * @param admin
	 * @return
	 */
	public Admin selectAdmin(Admin admin);
	/**
	 * 修改管理员用户信息验证
	 * @param admin
	 * @return
	 */
	public boolean updateAdminInfo(Admin admin);
	/**
	 * 修改管理员密码
	 * @param admin
	 * @return
	 */
	public boolean updateAdminPwd(Admin admin);
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<Admin> selectAllAdmins();
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public boolean insertAdmin(Admin admin);
	/**
	 * 通过管理员id删除管理员
	 * @param aid
	 * @return
	 */
	public boolean deleteAdmin(int aid);
	/**
	 * 通过管理员id查询所有的信息
	 * @param aid
	 * @return
	 */
	public Admin selectAdminInfo(int aid);
	/**
	 * 修改管理员所有信息
	 * @param admin
	 * @return
	 */
	public boolean updateAdmin(Admin admin);
}
