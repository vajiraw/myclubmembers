package com.managment.members.service;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.managment.members.Member;
import com.managment.members.domain.DivisionalSecretariat;
import com.managment.members.domain.Electorate;
import com.managment.members.domain.GramaSewaWasam;
import com.managment.members.domain.LocalGovernment;
import com.managment.members.domain.PollingCenter;


@Service
@Transactional
public class MemberServiceImpl implements MemberService{
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	byte[] imageBase = null;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	SessionFactory sf;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	public List<com.managment.members.domain.District> getAllDistricts(){
		logger.info("get all districts");
		Session session = sf.openSession();
		Query query = session.createQuery("from District as districts");
		List<com.managment.members.domain.District> districts = query.list();
		return districts;		
	}
	
	@Override
	public int addMember(Member member){
		logger.info("received member info "+member.getFulName());
		String query = "insert into Pone ( fullName,nic,address,mobileNumber,homeNumber,email,facebook,date_of_birth,age,gender,marital_status,postions_held,device_id,mem_image) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		imageBase = Base64.getMimeDecoder().decode(member.getImgBase().getBytes(StandardCharsets.UTF_8));
		logger.warn("Decoded  Image "+imageBase);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date d = null;;
		try {
			d = sdf.parse("21/12/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {member.getFulName(),member.getNicNo(),member.getAddress(),member.getMobileNo(), member.getContactNo(),member.getEmialId(),member.getFaceBook(),/*member.getDateOfBirth()*/d,member.getAge(),member.getGender(),member.getMartialStaus(),member.getPostioninUNP(),member.getDeviceName(),imageBase};
		int out = jdbcTemplate.update(query, args);
		return out;

	}
	
	@Override
	@Transactional
	public com.managment.members.domain.Member getMember(int memberId){		
		
		Session session = sf.openSession();
		Query query = session.createQuery("from Member as mem where mem.id = :memId ");
		query.setParameter("memId", memberId);
		com.managment.members.domain.Member member = (com.managment.members.domain.Member)query.list().get(0);
		
		logger.warn("retrive member image "+member.getImage());		
		return member;
	}
	

	@Override
	public List<com.managment.members.domain.Member> getAllMembers() {
		Session session = sf.openSession();
		Query query = session.createQuery("from Member as members ");
		List<com.managment.members.domain.Member> memberLst= query.list();
		session.clear();
		session.close();
		return memberLst;
	}
	
	
	public int updateMember(com.managment.members.domain.Member member){
		logger.info("uodate member getId  "+member.getId());
		logger.info("uodate member executing address  "+member.getAddress());
		logger.info("uodate member executing image name "+member.getImageName());
		logger.info("uodate member executing image  "+member.getImage());
		try {
			Session session = sf.openSession();	            
			com.managment.members.domain.Member member2 =  (com.managment.members.domain.Member) session.get(com.managment.members.domain.Member.class, member.getId());
			logger.info("update member toString  "+member2.toString());
			member2.setFullName(member.getFullName());
			session.update(member2);
			session.flush();
			session.close();
		} catch(Exception e){
				e.printStackTrace();
		}
		return 1;
	}


	@Override
	public List<Electorate> getElectorateforDistricts(int distrId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from Electorate as electorate where electorate.districtId = :distrId ");
		query.setParameter("distrId", distrId);
		List<com.managment.members.domain.Electorate> electorateLst= query.list();
		session.clear();
		session.close();
		return electorateLst;
	}


	@Override
	public List<DivisionalSecretariat> getDivisions(int elecorateId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from DivisionalSecretariat as ds where ds.electorateId = :elecorateId ");
		query.setParameter("elecorateId", elecorateId);
		List<com.managment.members.domain.DivisionalSecretariat> dsLst= query.list();
		session.clear();
		session.close();
		return dsLst;
	}


	@Override
	public List<LocalGovernment> getLocalGovs(int dsId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from LocalGovernment as localgov where localgov.dsId = :dsId ");
		query.setParameter("dsId", dsId);
		List<com.managment.members.domain.LocalGovernment> localGovLst= query.list();
		session.clear();
		session.close();
		return localGovLst;
	}


	@Override
	public List<GramaSewaWasam> getGramaSewa(int localGovId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from GramaSewaWasam as grams where grams.localGovId = :localGovId ");
		query.setParameter("localGovId", localGovId);
		List<com.managment.members.domain.GramaSewaWasam> gramasLst= query.list();
		session.clear();
		session.close();
		return gramasLst;
	}
	
	
	@Override
	public List<PollingCenter> getPollingCenters(int gramId) {
		Session session = sf.openSession();
		Query query = session.createQuery("from PollingCenter as polls where polls.gramasewaId = :gramId ");
		query.setParameter("gramId", gramId);
		List<PollingCenter> gramasLst= query.list();
		session.clear();
		session.close();
		return gramasLst;
	}
	
	
	/*@Override
	public int addMember(Member member){
		logger.info("received member info "+member.getFulName());
		String query = "insert into persons ( fullName, contactNumber,address,mem_image) values (?,?,?,?)";
		
		imageBase = Base64.getMimeDecoder().decode(member.getImgBase().getBytes(StandardCharsets.UTF_8));
		logger.warn("Decoded  Image "+imageBase);
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {member.getFulName(), member.getContactNo(),member.getAddress(),imageBase};
		int out = jdbcTemplate.update(query, args);
		return out;

	}*/
	
	

}
