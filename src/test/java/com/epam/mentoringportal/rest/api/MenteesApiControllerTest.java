package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.service.ApplicationException;
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
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application_test.properties")
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
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testAddMentee() throws Exception {
        Mentee dummy = new Mentee(1, "dummy", "dummy@mail.com");
        when(this.menteeService.save(any(NewPerson.class))).thenReturn(dummy);
        String postBody = mapper.writeValueAsString(new NewPerson());
        this.mockMvc.perform(post("/mentees").contentType(contentType).content(postBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullname", is("dummy")))
                .andExpect(jsonPath("$.email", is("dummy@mail.com")));
    }

    @Test
    public void testAddMentee_noBody() throws Exception {
        this.mockMvc.perform(post("/mentees").contentType(contentType))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testAddMentee_alreadyExists() throws Exception {
        when(this.menteeService.save(any(NewPerson.class))).thenThrow(ApplicationException.class);
        this.mockMvc.perform(post("/mentees").contentType(contentType))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testDeleteMentee() throws Exception {
        doNothing().when(this.menteeService).delete(anyInt());
        this.mockMvc.perform(delete("/mentees/1").contentType(contentType))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteMentee_error() throws Exception {
        doThrow(ApplicationException.class).when(this.menteeService).delete(anyInt());
        this.mockMvc.perform(delete("/mentees/1").contentType(contentType))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("")));
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