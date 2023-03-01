package example.etse.backend.service;

import java.util.List;

import example.etse.backend.model.Volunteer;

public interface VolunteerService {
	Volunteer saveVolunteer(Volunteer volunteer);
	List<Volunteer> getAllVolunteer();
	Volunteer getVolunteerById(long id);
	Volunteer updateVolunteer(Volunteer volunteer, long id);
	void deleteVolunteer(long id);
}
