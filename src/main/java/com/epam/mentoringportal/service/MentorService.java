package com.epam.mentoringportal.service;

import com.epam.mentoringportal.rest.dto.Mentor;
import com.epam.mentoringportal.rest.dto.NewPerson;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tim Ryzhov
 */
@Service
public interface MentorService {

    List<Mentor> findAll();

    Mentor findById(int id);

    Mentor save(NewPerson mentee) throws  ApplicationException;

    void delete(int id);

    Mentor update(Mentor mentee) throws ApplicationException;

    Mentor addMentee(int mentorId, int menteeId)  throws ApplicationException;
}
