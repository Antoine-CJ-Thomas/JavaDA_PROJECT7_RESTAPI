package com.nnk.springboot.controller;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import com.nnk.springboot.service.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceInterface userServiceInterface;
		
/*	
    @Autowired
    private UserRepository userRepository;
*/
	
	public UserController() {
		
		userServiceInterface = new UserService();
	}
	
    @RequestMapping("/user/list")
    public String home(Model model) {
/*    	
        model.addAttribute("users", userRepository.findAll());
*/            	
    	model.addAttribute("userList", userServiceInterface.readUserList());
    	
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User user) {
    	
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {
 /*   	
        if (!result.hasErrors()) {
        	
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            model.addAttribute("users", userRepository.findAll());
            
            return "redirect:/user/list";
        }
 */       
    	userServiceInterface.createUser(user);
    	
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
/*    	
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        user.setPassword("");
        model.addAttribute("user", user);
*/        

    	model.addAttribute("user", userServiceInterface.readUser(id));
    	
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user, BindingResult result, Model model) {
 /*      
    	if (result.hasErrors()) {
            return "user/update";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
*/        
    	userServiceInterface.updateUser(id, user);
    	
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
/*    	
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
*/        
    	userServiceInterface.deleteUser(id);
    	
        return "redirect:/user/list";
    }
}
