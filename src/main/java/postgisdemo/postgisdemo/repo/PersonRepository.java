package postgisdemo.postgisdemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import postgisdemo.postgisdemo.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {



}
