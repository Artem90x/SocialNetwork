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
import java.util.NoSuchElementException;
import java.util.Optional;

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
        Friendship friendship = friendsRepository
                .findAllBySrcPersonIdAndDstPersonId(srcId, dstId)
                .orElseThrow(NoSuchElementException::new);
        friendsRepository.delete(friendship);
    }

    @Override
    public void addFriend(long srcId) {
        Person dstPerson = accountService.getCurrentPerson();
        Person srcPerson = personRepository.findById(srcId);
        Friendship friendship = friendsRepository
                .findAllBySrcPersonIdAndDstPersonId(srcPerson.getId(), dstPerson.getId())
                .orElse(new Friendship());

        FriendshipStatus status;

        if (friendship.getStatus() == null) {
            status = new FriendshipStatus();
            status.setCode(REQUEST.name());
            status.setName(REQUEST.name());
            status.setTime(LocalDateTime.now());
            friendship.setStatus(status);
            friendship.setDstPerson(dstPerson);
            friendship.setSrcPerson(srcPerson);
        } else {
            status = friendship.getStatus();
            status.setCode(FRIEND.name());
            status.setName(FRIEND.name());
            status.setTime(LocalDateTime.now());
        }
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
