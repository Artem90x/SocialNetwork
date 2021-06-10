package skillbox.javapro11.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import skillbox.javapro11.model.entity.Person;
import skillbox.javapro11.model.entity.dto.FriendsIdDTO;

import java.util.List;

public interface FriendsService {

    List<FriendsIdDTO> isFriends(List<Long> userIds);

    void addFriend(long srcId);

    void deleteById(long srcId);

    Page<Person> getFriends(String name, String code, Pageable pageable);

    Page<Person> getRecommendations(Pageable pageable);
}
