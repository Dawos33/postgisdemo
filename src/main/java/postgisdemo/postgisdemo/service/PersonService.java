package postgisdemo.postgisdemo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import postgisdemo.postgisdemo.entities.Person;
import postgisdemo.postgisdemo.repo.PersonRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {


    private final PersonRepository personRepository;
    /*private final PersonRepository personRepository;


    public Person createPerson(Person person){
        final Person newPerson = personRepository.save( Person.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .emailId(person.getEmailId())
                .build());
        return newPerson;
    }*/
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public List<Person> getAllPeople(){
        return personRepository.findAll();
    }
    public void deleteById(Long id){
        personRepository.deleteById(id);
    }



}
