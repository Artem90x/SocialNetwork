package skillbox.javapro11.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import skillbox.javapro11.model.entity.Friendship;
import skillbox.javapro11.model.entity.FriendshipStatus;
import skillbox.javapro11.model.entity.Person;
import skillbox.javapro11.model.entity.dto.FriendsIdDTO;
import skillbox.javapro11.repository.FriendsRepository;
import skillbox.javapro11.repository.PersonRepository;
import skillbox.javapro11.service.AccountService;
import skillbox.javapro11.service.FriendsService;

import java.time.LocalDateTime;
import java.util.List;

import static skillbox.javapro11.enums.FriendshipStatusCode.*;

@Service
public class FriendsServiceImpl implements FriendsService {

    private final FriendsRepository friendsRepository;
    private final AccountService accountService;
    private final PersonRepository personRepository;

    public FriendsServiceImpl(FriendsRepository friendsRepository, AccountService accountService, PersonRepository personRepository) {
        this.friendsRepository = friendsRepository;
        this.accountService = accountService;
        this.personRepository = personRepository;
    }

    @Override
    public List<FriendsIdDTO> isFriends(List<Long> userIds) {
        long dstId = accountService.getCurrentPerson().getId();
        List<FriendsIdDTO> friends = friendsRepository.isFriends(dstId, userIds);
        return friends;
    }

    @Override
    public void deleteById(long srcId) {
        long dstId = accountService.getCurrentPerson().getId();
        friendsRepository.deleteById(srcId, dstId);
    }

    @Override
    public void addFriend(long srcId) {
        long dstPersonId = accountService.getCurrentPerson().getId();
        long srcPersonId = personRepository.findById(srcId).getId();
        Friendship friendship = friendsRepository.findAllBySrcPersonIdAndDstPersonId(srcPersonId, dstPersonId);
        FriendshipStatus status = friendship.getStatus();
        status.setCode(FRIEND.name());
        status.setName(FRIEND.name());
        status.setTime(LocalDateTime.now());
        friendsRepository.save(friendship);
    }

    @Override
    public Page<Person> getFriends(String name, String code, Pageable pageable) {
        long id = accountService.getCurrentPerson().getId();
        return personRepository.findAllFriends(id, code, pageable);
    }

    @Override
    public Page<Person> getRecommendations(Pageable pageable) {
        long id = accountService.getCurrentPerson().getId();
        Page<Person> recommendations = personRepository.getRecommendations(id, pageable);
        return recommendations;
    }
}
