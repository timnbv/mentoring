package com.epam.mentoringportal.service;

import com.epam.mentoringportal.domain.MenteeEntity;
import com.epam.mentoringportal.domain.MentorEntity;
import com.epam.mentoringportal.repository.MenteeRepository;
import com.epam.mentoringportal.repository.MentorRepository;
import com.epam.mentoringportal.rest.dto.Mentor;
import com.epam.mentoringportal.rest.dto.NewPerson;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tim Ryzhov
 */
@Service
@Transactional
public class MentorServiceImpl implements MentorService {

    private ModelMapper dtoMapper = new ModelMapper();

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private MenteeRepository menteeRepository;
    
    @Override
    public List<Mentor> findAll() {
        return null;
    }

    @Override
    public Mentor findById(int id) {
        MentorEntity one = mentorRepository.findOne(id);
        return one == null ? null: dtoMapMentor(one);
    }

    @Override
    public Mentor save(NewPerson newMentor) throws ApplicationException {
        MentorEntity mentor = dtoMapper.map(newMentor, MentorEntity.class);

        mentor.setCreatedAt(new DateTime());
        mentor.setUpdatedAt(new DateTime());
        MentorEntity newMentorEntity = mentorRepository.saveAndFlush(mentor);
        return dtoMapMentor(newMentorEntity);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Mentor update(Mentor mentor) throws ApplicationException {
        return null;
    }

    @Override
    public Mentor addMentee(int mentorId, int menteeId) throws ApplicationException {
        MentorEntity mentor = mentorRepository.findOne(mentorId);
        if (mentor == null) {
            throw new ApplicationException("Mentor not found");
        }
        MenteeEntity mentee = menteeRepository.findOne(menteeId);
        if (mentee == null) {
            throw new ApplicationException("Mentee not found");
        }
        mentee.setMentor(mentor);
        mentee.setUpdatedAt(new DateTime());
        menteeRepository.saveAndFlush(mentee);
        mentor = mentorRepository.findOne(mentorId);
        return dtoMapMentor(mentor);
    }

    protected Mentor dtoMapMentor(MentorEntity entity) {
        Mentor result = dtoMapper.map(entity, Mentor.class);
        return result;
    }
}
