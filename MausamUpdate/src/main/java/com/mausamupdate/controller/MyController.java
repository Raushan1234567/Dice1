package com.mausamupdate.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mausamupdate.model.Admin;
import com.mausamupdate.repository.AdminRepository;
import com.mausamupdate.service.AdminServiceInterface;

import jakarta.servlet.http.HttpServletRequest;




@RequestMapping("/admin")
@RestController
public class MyController {
	
	
	
	 
	@Autowired
    private AdminServiceInterface adminService;
    
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
	private PasswordEncoder PasswordEncoder;
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
    	admin.setPassword( PasswordEncoder.encode(admin.getPassword()));
        Admin registeredAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<>(registeredAdmin, HttpStatus.CREATED);
    }


    
    
    @GetMapping("/logini")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		 Admin opt= adminRepository.findByEmail(auth.getName());
		 if(opt==null) throw new RuntimeException("No user found") ;
		 Admin user = opt;
		 return new ResponseEntity<>(user.getUsername()+" Logged In Successfully", HttpStatus.ACCEPTED);
	}       
	
    
  

}
