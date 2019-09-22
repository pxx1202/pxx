package com.py.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.py.dao.PrivDao;
import com.py.entity.Priv;
import com.py.service.PrivService;

@Service("privService")
public class PrivServiceImpl implements PrivService {
	@Autowired(required=true)
	PrivDao privDao;
	@Override
	public List<Priv> selectAllPrivs() {
		// TODO Auto-generated method stub
		return privDao.selectAllPrivs() ;
	}
	@Override
	public List<Priv> selectPrivsByRid(int rid) {
		// TODO Auto-generated method stub
		return privDao.selectPrivByRid(rid);
	}
	@Override
	public int deteltePrivsByRid(int rid) {
		// TODO Auto-generated method stub
		return privDao.deletePrivsByRid(rid);
	}

}
