package skillbox.javapro11.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import skillbox.javapro11.api.request.FriendsIdRequest;


import skillbox.javapro11.api.response.CommonListResponse;
import skillbox.javapro11.api.response.FriendResponse;
import skillbox.javapro11.api.response.StatusMessageResponse;
import skillbox.javapro11.api.response.CommonResponseIsFriends;
import skillbox.javapro11.api.response.CommonResponseData;
import skillbox.javapro11.api.response.PersonResponse;
import skillbox.javapro11.model.entity.Person;
import skillbox.javapro11.model.entity.dto.FriendsIdDTO;
import skillbox.javapro11.repository.util.Utils;
import skillbox.javapro11.service.FriendsService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static skillbox.javapro11.enums.FriendshipStatusCode.*;

@RestController
public class FriendsController {

    private final FriendsService friendsService;

    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping("/friends")
    public CommonListResponse getFriends(@RequestParam(required = false) Integer offset,
                                         @RequestParam(required = false) Integer perPage,
                                         @RequestParam(required = false) String name) {

        if (offset == null && perPage == null) {
            offset = 0;
            perPage = 20;
        }

        PageRequest pageable = PageRequest.of(getPage(offset, perPage), perPage);
        Page<Person> persons = friendsService.getFriends(name, FRIEND.name(), pageable);

        return new CommonListResponse(
                "",
                Utils.getLongFromLocalDateTime(LocalDateTime.now()),
                persons.getTotalElements(),
                pageable.getOffset(),
                pageable.getPageSize(),
                new ArrayList<>(PersonResponse.fromPersonList(persons.getContent())));
    }

    @DeleteMapping("/friends/{id}")
    public CommonResponseData deleteFriend(@PathVariable Long id) {
        friendsService.deleteById(id);
        return new CommonResponseData(
                "",
                Utils.getLongFromLocalDateTime(LocalDateTime.now()),
                new StatusMessageResponse("ok")
        );
    }

    @PostMapping("/friends/{id}")
    public CommonResponseData addFriend(@PathVariable Long id) {
        friendsService.addFriend(id);
        return new CommonResponseData(
                "",
                Utils.getLongFromLocalDateTime(LocalDateTime.now()),
                new StatusMessageResponse("ok")
        );
    }

    @GetMapping("/friends/request")
    public CommonListResponse getFriendsRequest(@RequestParam(required = false) Integer offset,
                                                @RequestParam(required = false) Integer perPage,
                                                @RequestParam(required = false) String name) {

        if (offset == null && perPage == null) {
            offset = 0;
            perPage = 20;
        }

        PageRequest pageable = PageRequest.of(getPage(offset, perPage), perPage);
        Page<Person> persons = friendsService.getFriends(name, REQUEST.name(), pageable);

        return new CommonListResponse(
                "",
                Utils.getLongFromLocalDateTime(LocalDateTime.now()),
                persons.getTotalElements(),
                pageable.getOffset(),
                pageable.getPageSize(),
                new ArrayList<>(PersonResponse.fromPersonList(persons.getContent())));
    }

    @GetMapping("/friends/recommendations")
    public CommonListResponse getRecommendations(@RequestParam(required = false) Integer offset,
                                                 @RequestParam(required = false) Integer perPage) {

        if (offset == null && perPage == null) {
            offset = 0;
            perPage = 20;
        }

        PageRequest pageable = PageRequest.of(getPage(offset, perPage), perPage);
        Page<Person> recommendations = friendsService.getRecommendations(pageable);

        return new CommonListResponse(
                "",
                Utils.getLongFromLocalDateTime(LocalDateTime.now()),
                recommendations.getTotalElements(),
                pageable.getOffset(),
                pageable.getPageSize(),
                new ArrayList<>(PersonResponse.fromPersonList(recommendations.getContent())));
    }

    @PostMapping("/is/friends")
    public CommonResponseIsFriends isFriends(@RequestBody FriendsIdRequest friendsIdRequest) {
        List<FriendsIdDTO> friendsDTO = friendsService.isFriends(friendsIdRequest.getUserIds());
        return new CommonResponseIsFriends(friendsDTO.stream()
                .map(dto -> new FriendResponse(dto.getUserId(), dto.getStatus()))
                .collect(Collectors.toList()));
    }

    private int getPage(int offset, int perPage) {
        return offset / perPage;
    }
}
