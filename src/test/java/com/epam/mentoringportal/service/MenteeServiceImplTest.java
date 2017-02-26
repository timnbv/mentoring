package com.epam.mentoringportal.service;

import com.epam.mentoringportal.domain.MenteeEntity;
import com.epam.mentoringportal.repository.MenteeRepository;
import com.epam.mentoringportal.rest.dto.Mentee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenteeServiceImplTest {

    @MockBean
    MenteeRepository menteeRepository;


    @Test
    public void findAll() throws Exception {
        List<MenteeEntity> menteeEntityList = Arrays.asList(new MenteeEntity("dummy", "dummy@mail.com"),
                new MenteeEntity("dummy1", "dummy1@mail.com"));
        List<Mentee> menteeList = Arrays.asList(new Mentee("dummy", "dummy@mail.com"),
                new Mentee("dummy1", "dummy1@mail.com"));

        when(menteeRepository.findAll()).thenReturn(menteeEntityList);
        MenteeService service = new MenteeServiceImpl();
        List<Mentee> result = service.findAll();
        assertEquals(menteeList, result);

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

}