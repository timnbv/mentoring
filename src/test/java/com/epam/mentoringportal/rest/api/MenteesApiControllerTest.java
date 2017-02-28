package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.service.MenteeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application_test.properties")
@AutoConfigureMockMvc
public class MenteesApiControllerTest {

    @Mock
    private MenteeService menteeService;

    @InjectMocks
    private MenteesApi controller = new MenteesApiController();

    private MockMvc mockMvc;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception{

    MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testAddMentee() throws Exception {
        Mentee dummy1 = new Mentee(1, "dummy", "dummy@mail.com");
        when(this.menteeService.save(any(NewPerson.class))).thenReturn(dummy1);
        when(this.menteeService.returnString()).thenReturn("DummyString");
        String postBody = mapper.writeValueAsString(new NewPerson().fullname("dummy123").email("dummy@mail.com123"));
        this.mockMvc.perform(post("/mentees").contentType(contentType).content(postBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullname", is("dummy")))
                .andExpect(jsonPath("$.email", is("dummy@mail.com")));
        verify(this.menteeService).save(any(NewPerson.class));
    }

    @Test
    public void testDeleteMentee() throws Exception {

    }

    @Test
    public void testFindMenteeById() throws Exception {

    }

    @Test
    public void testMenteesGet() throws Exception {

    }

    @Test
    public void testUpdateMentee() throws Exception {

    }

}