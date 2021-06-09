package skillbox.javapro11.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import skillbox.javapro11.model.entity.Person;
import skillbox.javapro11.model.entity.Post;

import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	Page<Post> findAllByPerson(Person person, Pageable pageable);

	@Query(value = "SELECT * \n" +
			"FROM post \n" +
			"WHERE lower(post_text) LIKE lower('%'||?2||'%') \n" +
			" and time between ?3 and ?4 \n" +
			" and is_deleted = false", nativeQuery = true)
	Page<Post> findAllPostsBySearch(Pageable page, String text, LocalDateTime dateFrom, LocalDateTime dateTo);

	@Query("SELECT p FROM Post p WHERE p.person.id = :id")
    Page<Post> findAllByAuthorId(@Param("id") long id, Pageable page);
}
