package example.etse.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.etse.backend.model.Volunteer;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{

}
