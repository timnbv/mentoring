package com.epam.mentoringportal;

import com.epam.mentoringportal.rest.api.MenteesApi;
import com.epam.mentoringportal.rest.api.MentorsApi;
import com.epam.mentoringportal.rest.dto.Mentee;
import com.epam.mentoringportal.rest.dto.Mentor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author Tim Ryzhov
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application_test.properties")
@AutoConfigureMockMvc
public class LinkMenteeToMentorIT {

    @Autowired
    private MenteesApi menteesApiController;

    @Autowired
    private MentorsApi mentorsApiController;

    private MockMvc mockMvcMentees;
    private MockMvc mockMvcMentors;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    private ObjectMapper mapper;

    @Before
    public void setUp() throws Exception {
        this.mockMvcMentees = standaloneSetup(menteesApiController).build();
        this.mockMvcMentors = standaloneSetup(mentorsApiController).build();
    }

    @Test
    public void testLinkMenteeToMentor() throws Exception {
        addMentor("mentor1", "mentor1@mail.com");
        addMenteeAndLink("mentee1", "mentee1@mail.com", 0);
        addMenteeAndLink("mentee2", "mentee2@mail.com", 1);
    }

    private void addMenteeAndLink(String name, String email, int index) throws Exception {
        Mentee mentee = new Mentee(name, email);
        String postBody = mapper.writeValueAsString(mentee);
        this.mockMvcMentees.perform(post("/mentees").contentType(contentType).content(postBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullname", is(name)))
                .andExpect(jsonPath("$.email", is(email)));
        mentee.setId(index + 1);
        postBody = mapper.writeValueAsString(mentee);
        this.mockMvcMentors.perform(post("/mentors/1/mentee").contentType(contentType).content(postBody))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath(String.format("$.mentees[%d].fullname", index), is(name)))
                .andExpect(jsonPath(String.format("$.mentees[%d].email", index), is(email)));

    }

    private void addMentor(String name, String email) throws Exception {
        Mentor mentor = new Mentor(name, email);
        String postBody = mapper.writeValueAsString(mentor);
        this.mockMvcMentors.perform(post("/mentors").contentType(contentType).content(postBody))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.fullname", is(name)))
                .andExpect(jsonPath("$.email", is(email)));
    }
}
