package com.epam.mentoringportal.repository;

import com.epam.mentoringportal.Application;
import com.epam.mentoringportal.domain.MenteeEntity;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;


/**
 * @author Tim Ryzhov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootApplication
@ContextConfiguration(classes = {Application.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("/META-INF/dbtest/MenteeInitData.xml")
public class MenteeRepositoryTest {

    @Autowired
    MenteeRepository menteeRepository;

    @Test
    @ExpectedDatabase(value = "/META-INF/dbtest/MenteeAfterDelete.xml", table = "mentee", query = "select id, fullname, email from mentee")
    public void testDelete() throws Exception {
        menteeRepository.delete(1);
    }

    @Test
    public void testFindAll() throws Exception {
        List<MenteeEntity> all = menteeRepository.findAll();
        assertThat(all, is(notNullValue()));
        assertThat(all.size(), is(4));
    }

    @Test
    public void testFindOne() throws Exception {
        MenteeEntity expected = new MenteeEntity("ivan petrov", "ivan_petrov@mail.com");
        expected.setId(1);
        MenteeEntity one = menteeRepository.findOne(1);
        assertEquals(expected, one);
    }

    @Test
    @ExpectedDatabase(value = "/META-INF/dbtest/MenteeAfterAdd.xml", table = "mentee", query = "select id, fullname, email from mentee")
    public void testSave() throws Exception {
        MenteeEntity newMentee = menteeRepository.save(new MenteeEntity("kim kardashiyan", "kim_kardashiyan@yahoo.eu"));
        assertNotNull(newMentee);
    }


}