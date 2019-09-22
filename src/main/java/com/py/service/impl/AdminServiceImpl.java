package com.py.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.dao.AdminDao;
import com.py.dao.PrivDao;
import com.py.dao.RoleDao;
import com.py.entity.Admin;
import com.py.entity.Priv;
import com.py.entity.Role;
import com.py.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired(required=true)
	AdminDao adminDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	PrivDao privDao;
	
	@Override
	public Admin selectAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Admin admin1=new Admin();
		admin1=adminDao.selectAdminByName(admin);
		return admin1;
	}

	@Override
	public boolean updateAdminInfo(Admin admin) {
		// TODO Auto-generated method stub
		int i=adminDao.updateAdminInfo(admin);
		return i>0?true:false;
	}

	@Override
	public boolean updateAdminPwd(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println(admin.getApwd());
		int i=adminDao.updateAdminPwd(admin);
		return i>0?true:false;
	}

	@Override
	public List<Admin> selectAllAdmins() {
		// TODO Auto-generated method stub
		List<Admin> admins=adminDao.selectAllAdmin();
		for(Admin admin:admins) {
			List<Role> lr=roleDao.selectRoleByAid(admin);
			List<Priv> lp=privDao.selectPrivByAid(admin);
			admin.setLr(lr);
			admin.setLp(lp);
		}
		return admins;
	}

	@Override
	public boolean insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		int succ=adminDao.insertAdmin(admin);
		succ+=roleDao.insertRolesByAdmin(admin);
		return succ>0?true:false;
	}
	@Override
	public boolean deleteAdmin(int aid) {
		// TODO Auto-generated method stub
		int succ=roleDao.deleteRolesByAid(aid);
		succ+=adminDao.deleteAdminByAid(aid);
		return succ>1?true:false;
	}

	@Override
	public Admin selectAdminInfo(int aid) {
		// TODO Auto-generated method stub
		Admin admin1=adminDao.selectAdminInfoByaid(aid);
		if(admin1!=null) { 
			List<Priv> lp=privDao.selectPrivByAid(admin1);
			admin1.setLp(lp);
			List<Role> lr=roleDao.selectRoleByAid(admin1);
			admin1.setLr(lr);
		}
		return admin1;
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		int succ=adminDao.updateAdminInfo(admin);
		succ+=roleDao.deleteRolesByAid(admin.getAid());
		succ+=roleDao.insertRolesByAdmin(admin);
		return succ>2?true:false;
	}
}
