package com.epam.mentoringportal.service;

import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;

import java.util.List;

/***
 * @author Tim Ryzhov
 */
public interface MenteeService {
    List<Mentee> findAll();

    Mentee findById(int id);

    Mentee save(NewPerson mentee) throws  ApplicationException;

    void delete(int id);

    Mentee update(Mentee mentee) throws ApplicationException;
}
