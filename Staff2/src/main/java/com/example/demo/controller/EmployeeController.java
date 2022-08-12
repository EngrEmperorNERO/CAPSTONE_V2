package com.example.demo.controller;

//import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//import com.example.demo.domain.UserLogin;
//import com.example.demo.domain.UserLogin;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.service.EmployeeService;
//@RestController
//@RequestMapping("/api/")
@Controller
public class EmployeeController {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepo projrepo;
	
	//@Autowired
	//EmployeeService employeeservice;
	
	Employee result = new Employee();
	
	////////////////////NEW CHANGES FOR THE STAFF SOLUTIONS////////////////////////////////
	//working already showing in website
	private EmployeeService employeeservice;
	
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	//handler methods to handle list OF ALL STAFF ------ 
	@GetMapping("")
	public String listStudents(Model model) {
		model.addAttribute("employeelist", employeeservice.getAllUser());
		return "employeelist";
	}
	
	
	//Searching query for username
	@GetMapping("/searchbyusername")
	public ModelAndView usernamePage() {
		  ModelAndView mav = new ModelAndView("searchbyusername");
		  return mav;
	}
	
	//POST MAPPING FOR QUERY USERNAME
	@PostMapping("/searchbyusername/{username}")
	public ResponseEntity<List<Employee>> getProjectByUsername(@PathVariable(value="username")
	String username)throws ResourceNotFoundException{
		List<Employee> employee = projrepo.findByUsername(username);
			return ResponseEntity.ok().body(employee);	
	}   
	
	//get mapping for reading user query
	@RequestMapping("/searchbyusername1{username}")
	public String searchByUser(@ModelAttribute("user") Employee user,Model model) {
		  ModelAndView mav = new ModelAndView("usernamelist");
		  model.addAttribute("id", result.getId());
		  model.addAttribute("first_name", result.getFirstName());
		  model.addAttribute("last_name_name", result.getLastName());
		  model.addAttribute("email", result.getEmail());
		  model.addAttribute("position", result.getPosition());
		  model.addAttribute("project", result.getProject());
		  model.addAttribute("username", result.getUsername());
		  return "redirect:/usernamelist";
	}
	
	
	
	
	

	//SEARCHING QUERY FOR PROJECT 
	@GetMapping("/searchbyproject")
	public ModelAndView projectPage() {
		  ModelAndView mav1 = new ModelAndView("searchbyproject");
		  return mav1;
	}
	
	//@PostMapping("/searchbyproject")
	
	//Searching query for project
	
//////////////////// END OF CHANGES FOR THE STAFF SOLUTIONS////////////////////////////////
	
	///////////////////////////// TRYING TO VIEW HTML INTO THE BROWSER //////////////////////////
	//for index page shit not working tho
/*	@GetMapping("/index")
	public String viewHomePage() {
		return "index";
	}   //CAN ALREADY SEE ON THE WEBSITE   */
	
	
	//SEE ALL USERS SHITS
/*	@GetMapping("/stafflist")
	public String viewStaff(Model model) {
		List<Employee> listStaff = employeeservice.getAllUser();
		model.addAttribute("stafflist", listStaff);
		return "staff";	
	}   */
	
	
	
	/*


	@GetMapping("/listofemployee")
	public String getlist(Model model) {
		List<Employee> employee = employeeservice.getAllUser();
		model.addAttribute("listUserAccount",employee);
		//System.out.println(employee);
		return "listofemployee";
		
	}  */
	

	
	
	
	
	
	
	
	
	
///////////////////////////// END OF TRYING TO VIEW HTML INTO THE BROWSER //////////////////////////
	
	
	
	//THIS IS WORKING DO NOT DELETE
	//CHANGES MADE: MOVE TO SERVICES THE PUBLIC FOR PROJECTLIST
	//getting the list of employees
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(Model model){    //change List<Employee> to String getStaffList
		//System.out.println(employeeRepository.findAll());
		return this.employeeRepository.findAll();
	 	//THIS IS WORKING DO NOT DELETE
	}

	//getting the list of projects
	/*@GetMapping("/projectlist")
	public List<Employee> getAllProject(String project){
		return this.employeeRepository.findAll();	
	}
	
	@GetMapping("/projectlist/{username}")
	public ResponseEntity<List<Employee>> getProjectByUsername(@PathVariable(value="username")
	String username)throws ResourceNotFoundException{
		List<Employee> employee = projrepo.findByUsername(username);
			return ResponseEntity.ok().body(employee);	
	} */ //move to services
	
	
	//THIS IS WORKING DO NOT DELETE
	
	//Get Employee by project
	@GetMapping("/employees/{project}")
	public ResponseEntity<List<Employee>> getEmployeeByProject(@PathVariable(value="project")
	String project){
		List<Employee> employee = employeeRepository.findByProject(project);
			return ResponseEntity.ok().body(employee);	
	}  
	
	
	
	
	
	// this is working do not delete
	//get username
	@GetMapping("/employeeuser")
	public List<Employee> getAllEmployeeuser(Employee employee,Model model){
		return this.employeeRepository.findAll();	 
	}      //this is working do not delete
	
	
	
	 //this is working
	//GET EMPLOYEE BY USERNAME
	@GetMapping("/employeeuser/{username}")
	public ResponseEntity<List<Employee>>getEmployeeByUsername(@PathVariable(value="username")
	String username)throws ResourceNotFoundException{
		List<Employee> employee = employeeRepository.findByUsername(username);
			return ResponseEntity.ok().body(employee);	
	}                      //this is working do not delete
	
	
	//GETTING THE LIST OF PROJECTS OF A SINGLE USER

	
	
	
	
	//GET EMPLOYEE BY PROJECT
 /*	@GetMapping("/employees/{project}")
	public ResponseEntity<Employee> getEmployeeByProject(@PathVariable(value="project") 
	String project)throws ResourceNotFoundException{
		Employee employee = employeeRepository.findByProject(project);
				//.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this project ::" + project));
				return ResponseEntity.ok().body(employee);	
	} */
	
	

	
////////////////////////////////WILL COMMENT THIS ONE---NOT NEEDED AS OF NOW////////////////////////////////////	
/*	
	//for saving employees
	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	
	//for updating employees
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
			Employee employee = employeeRepository.findById(employeeId)
			.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + employeeId));
			
			employee.setEmail(employeeDetails.getEmail());
			employee.setFirstName(employeeDetails.getEmail());
			employee.setLastName(employeeDetails.getEmail());
			
			return ResponseEntity.ok(this.employeeRepository.save(employee));
		
	}
	
	//for deletion of employee
	@DeleteMapping("employees/{id}")
	public Map<String,Boolean> deleteEmployee(@PathVariable(value="id") Long employeeId) throws ResourceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id ::" + employeeId));
		
		this.employeeRepository.delete(employee);
		Map<String,Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
		return response;
	}
	*/
	
	
}	

