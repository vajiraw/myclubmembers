package com.managment.members;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.managment.members.domain.District;
import com.managment.members.domain.Electorate;
import com.managment.members.domain.GramaSewaWasam;
import com.managment.members.domain.LocalGovernment;
import com.managment.members.domain.PollingCenter;
import com.managment.members.domain.DivisionalSecretariat;
import com.managment.members.service.MemberService;

@Controller

public class MemberDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberDetailsController.class);
	
	private List<District> lstDistricts ;
	private List<Electorate> lstElectorates = new ArrayList<Electorate>() ;
	private List<DivisionalSecretariat> lstDivision = new ArrayList<DivisionalSecretariat>() ;
	private List<LocalGovernment> lstLocalGovs = new ArrayList<LocalGovernment>() ;
	private List<GramaSewaWasam> lstGramms = new ArrayList<GramaSewaWasam>() ;
	private List<PollingCenter> lstPollingCenter = new ArrayList<PollingCenter>() ;
	
	@Autowired
	MemberService memberService;		
	
	@RequestMapping(value="/getMember/{memberId}",method = RequestMethod.GET)
	public String getMemberById(@PathVariable String memberId,Model model){
		ModelAndView mav  = new ModelAndView();
		
		com.managment.members.domain.Member member = memberService.getMember(Integer.parseInt(memberId));
		logger.info("method caled getMemberById "+member.getImage());		
		String encodedImage = Base64.getEncoder().encodeToString(member.getImage());
		member.setImageName(encodedImage);		
		//Instrumentation.
		mav.setViewName("memberView");
		model.addAttribute("member", member);		
		return "memberView";
	}
	
	@RequestMapping(value="/getAllMembers",method = RequestMethod.GET)
	public ModelAndView getAllMembers(){
		return getMemberViews();
	}
	
	@RequestMapping(value="/getInitMembers",method = RequestMethod.GET)
	public String getDistricts(Model model){
		lstDistricts = memberService.getAllDistricts();		
		model.addAttribute("districts",lstDistricts);
		model.addAttribute("eletorates",lstElectorates);
		
		model.addAttribute("divisions",lstDivision);
		model.addAttribute("locals",lstLocalGovs);
		
		model.addAttribute("gramasewas",lstGramms);
		model.addAttribute("pollingCenter",lstPollingCenter);
		return "allMembers";
	}
	
	@RequestMapping(value="/getElectorates",method = RequestMethod.POST)
	@ResponseBody
	public List getElectorats(@RequestParam(value = "val", required = true) String distriId){
		logger.warn("get electorates "+distriId);
		lstElectorates = memberService.getElectorateforDistricts(Integer.parseInt(distriId));
		logger.warn("electorate list "+lstElectorates.size());
		return lstElectorates;
	}
	
	
	@RequestMapping(value="/getDSs",method = RequestMethod.POST)
	@ResponseBody
	public List getProvSecretariat(@RequestParam(value = "val", required = true) String elecorateId){
		logger.warn("get getDSs "+elecorateId);
		lstDivision = memberService.getDivisions(Integer.parseInt(elecorateId));
		logger.warn("getDSs list "+lstElectorates.size());
		return lstDivision;
	}
	
	
	@RequestMapping(value="/getLocals",method = RequestMethod.POST)
	@ResponseBody
	public List getLocalGovs(@RequestParam(value = "val", required = true) String divSecId){
		logger.warn("get getDSs "+divSecId);
		lstLocalGovs = memberService.getLocalGovs(Integer.parseInt(divSecId));
		logger.warn("get local govs "+lstElectorates.size());
		return lstLocalGovs;
	}
	
	@RequestMapping(value="/getGramas",method = RequestMethod.POST)
	@ResponseBody
	public List getGramas(@RequestParam(value = "val", required = true) String localGovId){		
		lstGramms = memberService.getGramaSewa(Integer.parseInt(localGovId));
		logger.warn("Grama list "+lstGramms.size());
		return lstGramms;
	}
	
	@RequestMapping(value="/getPollingCenter",method = RequestMethod.POST)
	@ResponseBody
	public List getPollinCenters(@RequestParam(value = "val", required = true) String gramaId){		
		lstPollingCenter = memberService.getPollingCenters(Integer.parseInt(gramaId));
		logger.warn("pollin centers list "+ lstPollingCenter.size());
		for(PollingCenter ps:lstPollingCenter)
			logger.warn("polling center "+ps.getPollingCenterName());
		return lstPollingCenter;
	}
	
	
	
	@RequestMapping(value="/updateMember",method = RequestMethod.POST)
	public ModelAndView updateMember(@ModelAttribute("member")com.managment.members.domain.Member member,BindingResult result, Model model){
		logger.info("update member id "+member.getId());		
		memberService.updateMember(member);
		return getMemberViews();
	}


	private ModelAndView getMemberViews() {
		ModelAndView mav  = new ModelAndView();
		List <com.managment.members.domain.Member> members = memberService.getAllMembers();	    	
		mav.setViewName("allMembers");
		mav.addObject("members", members);
		return mav;
	}
	
	
	

}
