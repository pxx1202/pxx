package com.py.entity;

import java.sql.Date;
import java.util.List;

public class Admin {
	private int aid;
	private String aname;
	private String acname;
	private String apwd;
	private String atel;
	private String aemail;
	private String aimg;
	private String by001;//启用 用作头像地址
	private String by002;
	private int by003;
	private Date by004;
	private Date createtime;
	private String createuser;
	private Date updatetime;
	private String updateuser;
	private List<Role> lr;
	private List<Priv> lp;
	
	public String getLr_rolename() {
		String rolename="";
		for(int i=0;i<lr.size();i++) {
			if(i==lr.size()-1)
				rolename+=lr.get(i).getRname();
			else
				rolename+=lr.get(i).getRname()+",";
		}
		return rolename;
	}
	public String getLp_privname() {
		String privname="";
		for(int i=0;i<lp.size();i++) {
			if(i==lp.size()-1)
				privname+=lp.get(i).getBy001();
			else
				privname+=lp.get(i).getBy001()+",";
		}
		return privname;
	}
	public List<Role> getLr() {
		return lr;
	}

	public void setLr(List<Role> lr) {
		this.lr = lr;
	}
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int aid, String aname, String acname, String apwd, String atel, String aemail, String aimg,
			String by001, String by002, int by003, Date by004, Date createtime, String createuser, Date updatetime,
			String updateuser, List<Priv> lp) {
		this.aid = aid;
		this.aname = aname;
		this.acname = acname;
		this.apwd = apwd;
		this.atel = atel;
		this.aemail = aemail;
		this.aimg = aimg;
		this.by001 = by001;
		this.by002 = by002;
		this.by003 = by003;
		this.by004 = by004;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.lp = lp;
	}

	public Admin(String acname, String apwd) {
		// TODO Auto-generated constructor stub
		this.acname = acname;
		this.apwd = apwd;
	}
	public Admin(int aid, String aname, String atel, String aemail) {
		// TODO Auto-generated constructor stub
		this.aid=aid;
		this.aname=aname;
		this.atel=atel;
		this.aemail=aemail;
		
	}

	public List<Priv> getLp() {
		return lp;
	}
	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAimg() {
		return aimg;
	}
	public void setAimg(String aimg) {
		this.aimg = aimg;
	}
	public String getBy001() {
		return by001;
	}
	public void setBy001(String by001) {
		this.by001 = by001;
	}
	public String getBy002() {
		return by002;
	}
	public void setBy002(String by002) {
		this.by002 = by002;
	}
	public int getBy003() {
		return by003;
	}
	public void setBy003(int by003) {
		this.by003 = by003;
	}
	public Date getBy004() {
		return by004;
	}
	public void setBy004(Date by004) {
		this.by004 = by004;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public String getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}
}
