package com.ftninformatika.jwd.modul3.sprint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.sprint.model.Sprint;

@Repository
public interface SprintRepository extends JpaRepository <Sprint, Long> {

	Sprint findOneById(Long id);
	
}
