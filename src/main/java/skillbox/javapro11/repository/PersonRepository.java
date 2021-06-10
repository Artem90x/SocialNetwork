package skillbox.javapro11.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skillbox.javapro11.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

    Person findByEmail(String email);

    Person findById(long id);

    Person findByPassword(String passwordNew);

    @Query("SELECT p FROM Person p LEFT JOIN Friendship f ON f.srcPerson.id = p.id " +
            "INNER JOIN FriendshipStatus fs ON f.status.id = fs.id " +
            "INNER JOIN Person t ON f.dstPerson.id = t.id WHERE t.id = :id AND fs.code = :code")
    Page<Person> findAllFriends(@Param("id") long id, @Param("code") String code, Pageable pageable);

    @Query("SELECT c FROM Person a " +
            "INNER JOIN Friendship f ON f.dstPerson.id = a.id " +
            "INNER JOIN Person b ON f.srcPerson.id = b.id " +
            "INNER JOIN FriendshipStatus fs ON fs.id = f.status.id " +
            "INNER JOIN Friendship ff ON ff.dstPerson.id = b.id " +
            "INNER JOIN Person c ON ff.srcPerson.id = c.id " +
            "INNER JOIN FriendshipStatus ffs ON ffs.id = ff.status.id " +
            "WHERE a.id = :id AND a.id != c.id GROUP BY c.id HAVING COUNT(c.id) >= 2 ")
    Page<Person> getRecommendations(@Param("id") long id, Pageable pageable);
}
