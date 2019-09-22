package com.py.entity;

import java.sql.Date;
import java.util.List;

public class Role {
	private int rid;
	private String rname;
	private String by001;
	private String by002;
	private String by003;
	private int by004;
	private Date by005;
	private Date createtime;
	private String createuser;
	private Date updatetime;
	private String updateuser;
	private List<Priv> lp;
	
	public Role(int rid, String rname, String by001, String by002, String by003, int by004, Date by005, Date createtime,
			String createuser, Date updatetime, String updateuser, List<Priv> lp) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.by001 = by001;
		this.by002 = by002;
		this.by003 = by003;
		this.by004 = by004;
		this.by005 = by005;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updatetime = updatetime;
		this.updateuser = updateuser;
		this.lp = lp;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLr_privname() {
		String privname="";
		for(int i=0;i<lp.size();i++) {
			if(i==lp.size()-1)
				privname+=lp.get(i).getBy001();
			else
				privname+=lp.get(i).getBy001()+"、";
		}
		return privname;
	}
	public List<Priv> getLp() {
		return lp;
	}
	public void setLp(List<Priv> lp) {
		this.lp = lp;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
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
