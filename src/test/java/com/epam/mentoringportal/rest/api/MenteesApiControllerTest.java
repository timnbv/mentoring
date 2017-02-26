package com.epam.mentoringportal.rest.api;

import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.NewPerson;
import com.epam.mentoringportal.service.MenteeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MenteesApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MenteeService menteeService;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void testAddMentee() throws Exception {
        Mentee dummy = new Mentee(1, "dummy", "dummy@mail.com");
        given(this.menteeService.save(any(NewPerson.class))).willReturn(dummy);
        String postBody = mapper.writeValueAsString(new NewPerson().fullname("dummy").email("dummy@mail.com"));
        this.mockMvc.perform(post("/mentees").contentType(contentType).content(postBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullname", is("dummy")))
                .andExpect(jsonPath("$.email", is("dummy@mail.com")));
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