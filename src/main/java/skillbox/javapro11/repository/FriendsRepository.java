package skillbox.javapro11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import skillbox.javapro11.model.entity.Friendship;
import skillbox.javapro11.model.entity.dto.FriendsIdDTO;

import java.util.List;

@Repository
public interface FriendsRepository extends JpaRepository<Friendship, Long> {

    @Query(value = "SELECT new skillbox.javapro11.model.entity.dto" +
            ".FriendsIdDTO(f.dstPerson.id, fs.code) FROM FriendshipStatus fs " +
            "INNER JOIN Friendship f ON f.status.id = fs.id " +
            "WHERE f.dstPerson.id = :dstId AND f.srcPerson.id IN :userIds  AND fs.code = 'FRIEND'")
    List<FriendsIdDTO> isFriends(@Param("dstId") long dstId, @Param("userIds") List<Long> userIds);

    Friendship findAllBySrcPersonIdAndDstPersonId(long srcPersonId, long dstPersonId);
}
