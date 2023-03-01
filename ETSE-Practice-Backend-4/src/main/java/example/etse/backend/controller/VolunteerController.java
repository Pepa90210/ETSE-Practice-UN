package example.etse.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import example.etse.backend.model.Volunteer;
import example.etse.backend.service.VolunteerService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

	@Autowired
	private VolunteerService volunteerService;

	public VolunteerController(VolunteerService volunteerService) {
		super();
		this.volunteerService = volunteerService;
	}

	@PostMapping()
	public ResponseEntity<Volunteer> saveEmployee(@RequestBody Volunteer volunteer) {
		return new ResponseEntity<Volunteer>(volunteerService.saveVolunteer(volunteer), HttpStatus.CREATED);
	}

	@GetMapping
	public List<Volunteer> getAllEmployees() {
		return volunteerService.getAllVolunteer();
	}

	@GetMapping("{id}")
	public ResponseEntity<Volunteer> getEmployeeById(@PathVariable("id") long employeeId) {
		return new ResponseEntity<Volunteer>(volunteerService.getVolunteerById(employeeId), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Volunteer> updateEmployee(@PathVariable("id") long id, @RequestBody Volunteer volunteer) {
		return new ResponseEntity<Volunteer>(volunteerService.updateVolunteer(volunteer, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id) {

		volunteerService.deleteVolunteer(id);
		return new ResponseEntity<String>("Employee deleted successfully!.", HttpStatus.OK);
	}

}
