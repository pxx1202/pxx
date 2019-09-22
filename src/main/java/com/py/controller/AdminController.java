package com.py.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.py.entity.Admin;
import com.py.entity.Role;
import com.py.service.AdminService;
import com.py.service.RoleService;
import com.py.service.impl.AdminServiceImpl;
import com.py.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/admin")
@SessionAttributes("admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	@Autowired
	RoleService roleService;
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "login";
	}
	@RequestMapping("/adminLogin")
	/*
	 * public String adminLogin(Admin admin,Model model) {
	 * admin=adminService.selectAdmin(admin); if(admin!=null) {
	 * model.addAttribute("admin", admin); return "index"; }else {
	 * model.addAttribute("msg", "用户名或密码错误!"); return "login"; } }
	 */
	public String adminLogin(String acname,String apwd,HttpServletRequest request) {
		Admin admin=adminService.selectAdmin(new Admin(acname,apwd)); 
		if(admin!=null) {
			request.getSession().setAttribute("admin", admin); 
			return "index";
		}else {
			request.setAttribute("msg", "用户名或密码错误!");
			return "login";
		}
	}
	 
	@RequestMapping("/index")
	public String toIndex() {
		return "index";
	}
	
	//修改密码
	@RequestMapping("/toUpdatePsw")
	public String toUpdatePsw() {
		return "/user/user_modi_pwd";
	}
	@RequestMapping("/updateAdminPwd")
	public String updateAdminPwd(Admin admin,String oldpwd,String newpwd,String newpwdcheck,Model model,HttpSession session) {
		if(oldpwd.equals(admin.getApwd())) {
			if(!newpwd.equals(newpwdcheck)) {
				model.addAttribute("msg", "两次输入的密码不相同");
				return "/user/user_modi_pwd";
			}else {
				admin.setApwd(newpwd);
				boolean succ=adminService.updateAdminPwd(admin);
				if(succ) {
					session.invalidate();
					return "redirect:login.do";
				}
				return "/user/user_modi_pwd";
			}
		}else {
			model.addAttribute("msg", "旧密码错误");
			return "/user/user_modi_pwd";
		}
	}
	
	//修改用户信息
	@RequestMapping("/toUserInfo")
	public String toUserInfo() {
		return "/user/user_info";
	}
	@RequestMapping("/updateAdminInfo")
	public String updateAdminInfo(Admin admin) {
		boolean succ=adminService.updateAdminInfo(admin);
		if(succ) 
			return "/user/user_info";
		else 
			return "/user/user_info";
	}
	
	@RequestMapping("/adminList")
	public String adminList(HttpServletRequest request) {
		List<Admin> admins=adminService.selectAllAdmins();
		request.setAttribute("admins", admins);
		return "/admin/admin_list";
	}
	
	//添加管理员
	@RequestMapping("/listToAddAdmin")
	public String listToAddAdmin(HttpServletRequest request) {
		List<Role> roles =roleService.selectAllRoles();
		request.setAttribute("roles", roles);
		return "/admin/admin_add";
	}
	@RequestMapping(value="/addAdmin",method=RequestMethod.POST)
	public String addAdmin(HttpServletRequest request) throws IOException, ServletException {
		String path=request.getServletContext().getContextPath();
		String aname=request.getParameter("aname");
		String acname=request.getParameter("acname");
		String apwd=request.getParameter("apwd");
		String apwdcheck=request.getParameter("apwdcheck");
		Part imgurl=request.getPart("userimg");
		//String by001="/upload/"+imgurl.getSubmittedFileName();
		System.out.println(apwd);
		System.out.println(apwdcheck);
		if(!apwd.equals(apwdcheck)) {
			request.setAttribute("msg", "两次密码不同");
			return "/admin/admin_add";
		}
		String atel=request.getParameter("atel");
		String aemail=request.getParameter("aemail");
		String[] roles=request.getParameterValues("roles");
		List<Role> lr=new ArrayList();
		for(int i=0;i<roles.length;i++) {
			Role role=new Role();
			role.setRid(Integer.parseInt(roles[i]));
			lr.add(role);
		}
		Admin admin=new Admin();
		admin.setAname(aname);
		admin.setAcname(acname);
		admin.setApwd(apwd);
		admin.setAtel(atel);
		admin.setAemail(aemail);
		admin.setLr(lr);
		//admin.setBy001(by001);
		boolean succ=adminService.insertAdmin(admin);
		if(succ) {
			return "redirect:adminList.do";
		}
		return "";
	}
	
	//修改管理员信息
	@RequestMapping("/listToUpdateAdmin")
	public String listToUpdateAdmin(HttpServletRequest request) {
		int aid=Integer.parseInt(request.getParameter("aid"));
		Admin admin=adminService.selectAdminInfo(aid);
		List<Role> roles=roleService.selectAllRoles();
		request.setAttribute("roles", roles);
		request.setAttribute("adminInfo", admin);
		return "/admin/admin_modi";
	}
	@RequestMapping("/updateAdmin")
	public String updateAdmin(HttpServletRequest request) {
		String aid=request.getParameter("aid");
		String aname=request.getParameter("aname");
		String atel=request.getParameter("atel");
		String aemail=request.getParameter("aemail");
		String[] roles=request.getParameterValues("roles");
		List<Role> lr=new ArrayList();
		for(int i=0;i<roles.length;i++) {
			Role role =roleService.selectRoleByRid(Integer.parseInt(roles[i]));
			lr.add(role);
		}
		Admin admin=new Admin(Integer.parseInt(aid),aname,atel,aemail);
		admin.setLr(lr);
		boolean succ=adminService.updateAdmin(admin);
		if(succ) {
			return "redirect:adminList.do";
		}else {
			return "";
		}
	}
	
	@RequestMapping("deleteAdmin")
	public String deleteAdmin(HttpServletRequest request) {
		int aid=Integer.parseInt(request.getParameter("aid"));
		boolean succ=adminService.deleteAdmin(aid);
		if(succ) {
			return "redirect:adminList.do";
		}else {
			return "";
		}
	}
}
