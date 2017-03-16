package com.managment.members;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.managment.members.service.MemberService;

/**
 * This class method is used by andriod client only.
 * @author KARCH
 *
 */


@RestController
@RequestMapping(value = "/members")
public class MembersController {		

	private static final Logger logger = LoggerFactory.getLogger(MembersController.class);	
	
	@Autowired
	MemberService memberService;	
	
	
	/**
	 * The following method is used by the android device to create members
	 * @param member
	 * @return
	 */
	@RequestMapping(value = "/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createUser(@RequestBody Member member){		
		
		logger.warn("Creating User gender "+member.getGender());			
		memberService.addMember(member);		
		HttpHeaders headers = new HttpHeaders();	   
		return new String("success");
	}
	
	
}
