package com.py.entity;

import java.sql.Date;

public class Priv {
	private int pid;
	private String pclass;
	private String purl;
	private String by001;//启用，代表权限名字
	private String by002;
	private String by003;
	private int by004;
	private Date by005;
	private Date createtime;
	private String createuser;
	private Date updatetime;
	private String updateuser;
	
	public Priv() {
		// TODO Auto-generated constructor stub
	}
	
	public Priv(int pid, String pclass, String purl, String by001, String by002, String by003, int by004, Date by005,
			Date createtime, String createuser, Date updatetime, String updateuser) {
		super();
		this.pid = pid;
		this.pclass = pclass;
		this.purl = purl;
		this.by001 = by001;
		this.by002 = by002;
		this.by003 = by003;
		this.by004 = by004;
		this.by005 = by005;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
	}

	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPclass() {
		return pclass;
	}
	public void setPclass(String pclass) {
		this.pclass = pclass;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
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
	public String getBy003() {
		return by003;
	}
	public void setBy003(String by003) {
		this.by003 = by003;
	}
	public int getBy004() {
		return by004;
	}
	public void setBy004(int by004) {
		this.by004 = by004;
	}
	public Date getBy005() {
		return by005;
	}
	public void setBy005(Date by005) {
		this.by005 = by005;
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
