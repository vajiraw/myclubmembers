package com.managment.members.service;

import java.util.List;

import com.managment.members.domain.DivisionalSecretariat;
import com.managment.members.domain.GramaSewaWasam;
import com.managment.members.domain.LocalGovernment;
import com.managment.members.domain.PollingCenter;

public interface MemberService {
	
	public List<com.managment.members.domain.District> getAllDistricts();
	
	public List<com.managment.members.domain.Electorate> getElectorateforDistricts(int distrId);
	
	public List<DivisionalSecretariat> getDivisions(int elecorateId);
	
	public List<LocalGovernment> getLocalGovs(int dsId);
	
	public List<GramaSewaWasam> getGramaSewa(int localGovId);
	
	public List<PollingCenter> getPollingCenters(int gramId);
	
	public int addMember(com.managment.members.Member member);	

	public com.managment.members.domain.Member getMember(int memberId);
	
	public List<com.managment.members.domain.Member> getAllMembers();
	
	public int updateMember(com.managment.members.domain.Member member);
	

}
