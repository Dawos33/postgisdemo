package postgisdemo.postgisdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import postgisdemo.postgisdemo.dto.PersonDto;
import postgisdemo.postgisdemo.dto.PersonMapper;
import postgisdemo.postgisdemo.entities.Person;
import postgisdemo.postgisdemo.exception.ResourceNotFoundException;
import postgisdemo.postgisdemo.repo.PersonRepository;
import postgisdemo.postgisdemo.service.PersonService;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api1")
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;
    private final PersonMapper personMapper;


    @GetMapping("/people")
    public ResponseEntity< List<PersonDto> > getAllPeople(){
        return ResponseEntity.ok(personMapper.toPersonDto(personService.getAllPeople()));
    }

    @PostMapping("/people")
    public Person createPerson(@Valid @RequestBody Person person){
        return personService.addPerson(person);
    }

    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
                                                 @Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + personId));;


        person.setEmailId(personDetails.getEmailId());
        person.setLastName(personDetails.getLastName());
        person.setFirstName(personDetails.getFirstName());
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/people/{id}")
    public ResponseEntity deletePerson(@PathVariable(value = "id") Long personId){
        personService.deleteById(personId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
