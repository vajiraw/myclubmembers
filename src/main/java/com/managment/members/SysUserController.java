package com.managment.members;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.managment.members.domain.SysUser;
import com.managment.members.service.UserService;

@Controller
@RequestMapping(value = "/systemusers")
public class SysUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	UserService userService;
	
	
	// create user
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView getUserCreate(Model model){
		
		SysUser user =  new SysUser();
		model.addAttribute("user", user);	
		ModelAndView mav  = new ModelAndView();
		mav.addObject(model);
		mav.setViewName("addSystemUser");
		return mav;
	}
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute("user")SysUser sysUser ){
		logger.warn("Get user name : "+sysUser.getFirstName());
		userService.createSysUser(sysUser);
		return getAllUsers();
		
	}
	
	@RequestMapping(value="/getAllUsers",method = RequestMethod.GET)
	public ModelAndView getAllUsers(){
		ModelAndView mav  = new ModelAndView();
		List <SysUser> users = userService.getAllUsers();	 
		logger.warn("Get user list size : "+users.size());
		mav.setViewName("allMobileAgents");
		mav.addObject("users", users);
		return mav;
		
	}
	
	
	// update user

}
