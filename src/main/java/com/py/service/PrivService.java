package com.py.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.py.entity.Priv;

public interface PrivService {
	/**
	 * 查询所有的权限信息
	 * @return
	 */
	public List<Priv> selectAllPrivs();
	/**
	 * 通过角色id查询角色权限
	 * @param rid
	 * @return
	 */
	public List<Priv> selectPrivsByRid(int rid);
	/**
	 * 通过角色id删除角色权限
	 * @param rid
	 * @return
	 */
	public int deteltePrivsByRid(int rid);
}
