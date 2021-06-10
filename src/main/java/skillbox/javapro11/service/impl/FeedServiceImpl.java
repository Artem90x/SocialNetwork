package skillbox.javapro11.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import skillbox.javapro11.api.response.CommonListResponse;
import skillbox.javapro11.api.response.PostResponse;
import skillbox.javapro11.model.entity.Post;
import skillbox.javapro11.repository.PostRepository;
import skillbox.javapro11.repository.util.Utils;
import skillbox.javapro11.service.AccountService;
import skillbox.javapro11.service.FeedService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static skillbox.javapro11.enums.FriendshipStatusCode.*;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {

    private final PostRepository postRepository;
    private final AccountService accountService;


    @Override
    public CommonListResponse getNewsList(String name, long offset, int itemPerPage) {
        long personId = accountService.getCurrentPerson().getId();
        Pageable page = Utils.getPageable(offset, itemPerPage, Sort.by(Sort.Direction.DESC, "time"));
        Page<Post> posts = postRepository.findAllNews(personId, FRIEND.name(), page);

        return new CommonListResponse("", LocalDateTime.now(), posts.getTotalElements(),
                offset, itemPerPage, new ArrayList<>(PostResponse.fromPostList(posts.getContent())));
    }
}
