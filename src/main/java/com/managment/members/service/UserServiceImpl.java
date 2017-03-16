package com.managment.members.service;

import java.util.List;

import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managment.members.domain.SysUser;


@Service
@Transactional
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	SessionFactory sessionFactory;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	@Override
	public void createSysUser(SysUser sysUser) {
		logger.warn("create user "+sysUser.getFirstName());
		Session session = sessionFactory.openSession();	   
		session.save(sysUser);
		session.flush();
		session.close();		
	}


	@Override
	public List<SysUser> getAllUsers() {
		logger.warn("getAllUsers ");
		Session session = sessionFactory.openSession();
		org.hibernate.Query query = session.createQuery("from SysUser as sysUser ");
		List<SysUser> memberLst= query.list();
		session.clear();
		session.close();
		return memberLst;
	}
	
	

}
