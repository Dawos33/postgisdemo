package postgisdemo.postgisdemo.service;


import org.assertj.core.api.Assertions;
import org.junit.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import postgisdemo.postgisdemo.entities.Person;
import postgisdemo.postgisdemo.repo.PersonRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService bean;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        bean = new PersonService(personRepository);
    }

    @Test
    public void addPerson() {
        //given
        Person person = Person.builder()
                .id(1L)
                .firstName("Daniel")
                .lastName("Kot")
                .emailId("dk@gmail.com")
                .build();
        //when
        bean.addPerson(person);

        //then
        verify(personRepository, times(1)).save(person);


    }

    @Test
    public void getAllPeople() {
        //given
        Person person = Person.builder()
                .id(1L)
                .firstName("Daniel")
                .lastName("Kot")
                .emailId("dk@gmail.com")
                .build();

        Person person2 = Person.builder()
                .id(2L)
                .firstName("Daniel")
                .lastName("Kot")
                .emailId("dk@gmail.com")
                .build();

        List<Person> expectedPersons = Arrays.asList(person, person2);
        Mockito.doReturn(expectedPersons).when(personRepository).findAll();

        //when
        List<Person> actualPerson = bean.getAllPeople();

        //then
        Assertions.assertThat(actualPerson).isEqualTo(expectedPersons);
        assertEquals(2, expectedPersons.size());

    }
    @Ignore
    @Test
    public void deleteById() {
        Person person = Person.builder()
                .id(1L)
                .firstName("Daniel")
                .lastName("Kot")
                .emailId("dk@gmail.com")
                .build();

        bean.deleteById(person.getId());
        verify(bean, times(1)).deleteById(1L);
    }
}