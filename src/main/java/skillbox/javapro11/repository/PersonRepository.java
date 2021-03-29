package skillbox.javapro11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import skillbox.javapro11.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByEmail(String email);
}