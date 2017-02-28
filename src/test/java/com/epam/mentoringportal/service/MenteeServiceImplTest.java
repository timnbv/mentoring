package com.epam.mentoringportal.service;

import com.epam.mentoringportal.domain.MenteeEntity;
import com.epam.mentoringportal.repository.MenteeRepository;
import com.epam.mentoringportal.rest.dto.Mentee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application_test.properties")
public class MenteeServiceImplTest {

    @Mock
    MenteeRepository menteeRepository;

    @InjectMocks
    MenteeService menteeService = new MenteeServiceImpl();

    @Before
    public void setUp() {
        initMocks(this);
    }


    @Test
    public void testFindAll() throws Exception {
        List<MenteeEntity> menteeEntityList = Arrays.asList(new MenteeEntity("dummy", "dummy@mail.com"),
                new MenteeEntity("dummy1", "dummy1@mail.com"));
        List<Mentee> menteeList = Arrays.asList(new Mentee("dummy", "dummy@mail.com"),
                new Mentee("dummy1", "dummy1@mail.com"));
        when(menteeRepository.findAll()).thenReturn(menteeEntityList);
        List<Mentee> result = menteeService.findAll();
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