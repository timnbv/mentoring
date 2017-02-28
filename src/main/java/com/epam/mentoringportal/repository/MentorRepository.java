package com.epam.mentoringportal.repository;

import com.epam.mentoringportal.domain.MentorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tim Ryzhov
 */
@Repository
public interface MentorRepository extends JpaRepository<MentorEntity,Integer> {
}
