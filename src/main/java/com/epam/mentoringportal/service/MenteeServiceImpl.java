package com.epam.mentoringportal.service;

import com.epam.mentoringportal.domain.MenteeEntity;
import com.epam.mentoringportal.repository.MenteeRepository;
import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tim Ryzhov
 */
@Service
@Transactional
public class MenteeServiceImpl implements MenteeService {

    private ModelMapper dtoMapper = new ModelMapper();

    @Autowired
    private MenteeRepository menteeRepository;

    @Override
    public List<Mentee> findAll() {
        List<MenteeEntity> all = menteeRepository.findAll();
        List<Mentee> dtoMentee = new ArrayList<>();
        for (MenteeEntity menteeEntity : all) {
            dtoMentee.add(dtoMapper.map(menteeEntity, Mentee.class));
        }
        return dtoMentee;
    }

    @Override
    public Mentee findById(int id) {
        MenteeEntity one = menteeRepository.findOne(id);
        return one == null ? null: dtoMapper.map(one, Mentee.class);
    }

    @Override
    public Mentee save(NewPerson newMentee) throws ApplicationException {

        MenteeEntity mentee = dtoMapper.map(newMentee, MenteeEntity.class);
        MenteeEntity exists = menteeRepository.findByEmail(mentee.getEmail());
        if (exists != null) {
            throw new ApplicationException("Mentee with such email already exists");
        }

        mentee.setCreatedAt(new DateTime());
        mentee.setUpdatedAt(new DateTime());
        MenteeEntity newMenteeEntity = menteeRepository.saveAndFlush(mentee);
        return dtoMapper.map(newMenteeEntity, Mentee.class);
    }

    @Override
    public void delete(int id) {
        menteeRepository.delete(id);
    }

    @Override
    public Mentee update(Mentee mentee) {
        MenteeEntity menteeEntity = dtoMapper.map(mentee, MenteeEntity.class);
        menteeEntity.setUpdatedAt(new DateTime());
        MenteeEntity newMenteeEntity = menteeRepository.saveAndFlush(menteeEntity);
        return dtoMapper.map(newMenteeEntity, Mentee.class);
    }
}
