package com.py.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.dao.PrivDao;
import com.py.dao.RoleDao;
import com.py.entity.Admin;
import com.py.entity.Role;
import com.py.service.RoleService;

@Service("roleServlce")
public class RoleServiceImpl implements RoleService {
	@Autowired(required=true)
	RoleDao roleDao;
	@Autowired(required=true)
	PrivDao privDao;
	@Override
	public List<Role> selectAllRoles() {
		List<Role> lr =roleDao.selectAllRoles();
		if(lr!=null) { 
			for(Role role:lr) {
				role.setLp(privDao.selectPrivByRid(role.getRid()));
			}
		}
		return lr;
	}
	@Override
	public boolean insertRole(Role role) {
		// TODO Auto-generated method stub
		roleDao.insertRole(role);
		int succ=privDao.insertPrivByRid(role);
		return succ>0?true:false;
	}
	@Override
	public Role selectRoleByRid(int rid) {
		// TODO Auto-generated method stub
		return roleDao.selectRoleByRid(rid);
	}
	@Override
	public boolean updateRoleInfo(Role role) {
		// TODO Auto-generated method stub
		int i=roleDao.updateRoleInfoByRid(role);
		i+=privDao.deletePrivsByRid(role.getRid());
		i+=privDao.insertPrivByRid(role);
		return i>3?true:false;
	}
	@Override
	public boolean deleteRoleByRid(int rid) {
		// TODO Auto-generated method stub
		int i=privDao.deletePrivsByRid(rid);
		i+=roleDao.deleteRoleByRid(rid);
		return i>1?true:false;
	}
}
