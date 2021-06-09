package skillbox.javapro11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import skillbox.javapro11.model.entity.Person;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    Person findByEmail(String email);

    Person findById(long id);

    Person findByPassword(String passwordNew);

    @Query(value = "select p.*\n" +
        "from person p, person2dialog d\n" +
        "where  d.person_id = p.id and  d.dialog_id = ?1",nativeQuery = true)
    List<Person> findPersonByDialog(long dialogId);
}