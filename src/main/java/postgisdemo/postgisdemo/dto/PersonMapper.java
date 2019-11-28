package postgisdemo.postgisdemo.dto;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import postgisdemo.postgisdemo.controller.PersonController;
import postgisdemo.postgisdemo.entities.Person;

import java.util.List;

@Mapper( componentModel = "spring",
        uses = PersonController.class,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR )
public interface PersonMapper {

    Person mapToPerson(PersonDto personDto);
    PersonDto toPersonDto(Person person);
    List<PersonDto> toPersonDto(List<Person> person);
}
