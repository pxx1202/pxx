package com.py.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.py.entity.Priv;
import com.py.entity.Role;
import com.py.service.PrivService;
import com.py.service.RoleService;
import com.py.service.impl.PrivServiceImpl;
import com.py.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	PrivService privService;
	
	@RequestMapping("/roleList")
	public String roleList(HttpServletRequest request) {
		List<Role> lr=roleService.selectAllRoles();
		request.setAttribute("role", lr);
		return "/role/role_list";
	}
	
	@RequestMapping("/listToAddRole")
	public String listToAddRole(HttpServletRequest request) {
		List<Priv> privs =privService.selectAllPrivs();
		request.setAttribute("privs", privs);
		return "/role/role_add";
	}
	
	@RequestMapping("/addRole")
	public String addRole(HttpServletRequest request) {
		String rname=request.getParameter("rname");
		String[] privs=request.getParameterValues("privs");
		List<Priv> lp=new ArrayList();
		for(int i=0;i<privs.length;i++) {
			Priv priv=new Priv();
			priv.setPid(Integer.parseInt(privs[i]));
			lp.add(priv);
		}
		Role role=new Role();
		role.setRname(rname);
		role.setLp(lp);
		boolean succ=roleService.insertRole(role);
		if(succ) {
			return "redirect:roleList.do";
		}else {
			return "/role/role_add";
		}
		
	}
	
	@RequestMapping("/listToUpdateRole")
	public String listToUpdateRole(HttpServletRequest request) {
		int rid=Integer.parseInt(request.getParameter("rid"));
		Role role=roleService.selectRoleByRid(rid);
		List<Priv> privs=privService.selectAllPrivs();
		List<Priv> lp=privService.selectPrivsByRid(rid);
		role.setLp(lp);
		request.setAttribute("privs", privs);
		request.setAttribute("role", role);
		return "/role/role_modi";
	}
	
	@RequestMapping("/updateRole")
	public String updateRole(HttpServletRequest request) {
		int rid=Integer.parseInt(request.getParameter("rid"));
		String rname=request.getParameter("rname");
		String[] privs=request.getParameterValues("privs");
		List<Priv> lp=new ArrayList();
		for(int i=0;i<privs.length;i++) {
			Priv priv=new Priv();
			priv.setPid(Integer.parseInt(privs[i]));
			lp.add(priv);
		}
		Role role=new Role();
		role.setRid(rid);
		role.setRname(rname);
		role.setLp(lp);
		boolean succ=roleService.updateRoleInfo(role);
		if(succ) 
		return "redirect:roleList.do";
		else return "/role/role_modi";
	}
	
	@RequestMapping("/deleteRole")
	public String deleteRole(HttpServletRequest request) {
		int rid=Integer.parseInt(request.getParameter("rid"));
		boolean succ =roleService.deleteRoleByRid(rid);
		if(succ)
			return "redirect:roleList.do";
		else
			return "";
	}
}
