package example.etse.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import example.etse.backend.exception.ResourceNotFoundException;
import example.etse.backend.model.Volunteer;
import example.etse.backend.repository.VolunteerRepository;
import example.etse.backend.service.VolunteerService;

@Service
public class VolunteerServiceImpl implements VolunteerService {

	private VolunteerRepository volunteerRepository;

	public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
		super();
		this.volunteerRepository = volunteerRepository;
	}

	@Override
	public Volunteer saveVolunteer(Volunteer volunteer) {
		return volunteerRepository.save(volunteer);
	}

	@Override
	public List<Volunteer> getAllVolunteer() {
		return volunteerRepository.findAll();
	}

	@Override
	public Volunteer getVolunteerById(long id) {
//		Optional<Volunteer> volunteer = volunteerRepository.findById(id);
//		if(volunteer.isPresent()) {
//			return volunteer.get();
//		}else {
//			throw new ResourceNotFoundException("Volunteer", "Id", id);
//		}
		return volunteerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Volunteer", "Id", id));

	}

	@Override
	public Volunteer updateVolunteer(Volunteer volunteer, long id) {

		Volunteer existingVolunteer = volunteerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Volunteer", "Id", id));

		existingVolunteer.setFirstName(volunteer.getFirstName());
		existingVolunteer.setLastName(volunteer.getLastName());
		existingVolunteer.setEmail(volunteer.getEmail());

		volunteerRepository.save(existingVolunteer);
		return existingVolunteer;
	}

	@Override
	public void deleteVolunteer(long id) {

		volunteerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Volunteer", "Id", id));
		volunteerRepository.deleteById(id);
	}

}
