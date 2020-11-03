package com.devops.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devops.springboot.demo.model.RedRockUser;
import com.devops.springboot.demo.repository.RRUserRepository;

@Controller
@RequestMapping("/rrUsers/")
public class RRUserController {
	private final  RRUserRepository rrUserRepository; 

	@Autowired
    public RRUserController(RRUserRepository rrUserRepository) {
        this.rrUserRepository = rrUserRepository;
    }
	
	@RequestMapping("/")
    public String index() {
        return "index";
    }
	
	@GetMapping("signup")
    public String showSignUpForm(RedRockUser rrUser,Model model) {
		 model.addAttribute("rrUser",rrUser);
        return "addUser";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("rrUsers", rrUserRepository.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addRedRockUser(@Validated RedRockUser rrUser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addUser";
        }

        rrUserRepository.save(rrUser);
        model.addAttribute("rrUser",rrUser);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        RedRockUser rrUser = rrUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid rrUser Id:" + id));
        model.addAttribute("rrUser", rrUser);
        return "updateUser";
    }

    @PostMapping("update/{id}")
    public String updateRedRockUser(@PathVariable("id") long id, @Validated RedRockUser rrUser, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            rrUser.setId(id);
            return "updateUser";
        }

        rrUserRepository.save(rrUser);
        model.addAttribute("rrUsers", rrUserRepository.findAll());
        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteRedRockUser(@PathVariable("id") long id, Model model) {
      RedRockUser rrUser = rrUserRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Red rock user Id:" + id));
        if (rrUser!=null)
        rrUserRepository.delete(rrUser);
        model.addAttribute("rrUsers", rrUserRepository.findAll());
        return "index";
    }
}
/*
	
	
	
	
	
	
	
	
	
	
	
	
	
	*//**Controller method to retrieve all RedRock users
	 * @return list of all RedRockUsers
	 *//*
	@GetMapping
	public String getAllRRUsers() {
		List<RedRockUser> list = service.getAllRRUsers();

		return "index";
	}

	*//**Controller method to retrieve RedRockUser based on the ID
	 * @param id
	 * @return RedRockUser
	 *//*
	@GetMapping("/{id}")
	public ResponseEntity<RedRockUser> getRRUserById(@PathVariable("id") Long id) {
		RedRockUser entity = service.getRRUserById(id);

		return new ResponseEntity<RedRockUser>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	*//**Controller method to create new RedRockUser or update the RedRockUser based on ID 
	 * @param rrUser
	 * @return RedRockUser
	 *//*
	@PostMapping
	public ResponseEntity<RedRockUser> createOrUpdateRRUser(@RequestBody RedRockUser rrUser) {
		RedRockUser updated = service.createOrUpdateRRUser(rrUser);
		
		return new ResponseEntity<RedRockUser>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	*//**Controller method to delete the RedRockUser based on ID 
	 * @param id
	 * @return HttpStatus ACCEPTED
	 *//*
	@DeleteMapping("/{id}")
	public HttpStatus deleteRRUserById(@PathVariable("id") Long id) {
		service.deleteRRUserById(id);
		return HttpStatus.ACCEPTED;
	}

}*/