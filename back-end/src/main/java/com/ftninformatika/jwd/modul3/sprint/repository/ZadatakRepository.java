package com.ftninformatika.jwd.modul3.sprint.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftninformatika.jwd.modul3.sprint.model.Zadatak;

@Repository
public interface ZadatakRepository extends JpaRepository<Zadatak, Long> {
	
	Zadatak findOneById(Long id);	
	
	Page<Zadatak> findByImeContainingAndSprintId(String ime, Long sprintId, Pageable pageable);
	
	Page<Zadatak> findByImeContaining(String ime, Pageable pageable);
	
	Page<Zadatak> findBySprintId(Long sprintId, Pageable pageable);
	
}
