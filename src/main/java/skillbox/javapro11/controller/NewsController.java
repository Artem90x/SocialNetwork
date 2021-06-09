package skillbox.javapro11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skillbox.javapro11.api.response.CommonListResponse;
import skillbox.javapro11.api.response.PostResponse;
import skillbox.javapro11.model.entity.Person;
import skillbox.javapro11.model.entity.Post;
import skillbox.javapro11.repository.util.Utils;
import skillbox.javapro11.service.AccountService;
import skillbox.javapro11.service.PostService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NewsController {

    private final AccountService accountService;
    private final PostService postService;

    @Autowired
    public NewsController(AccountService accountService, PostService postService) {
        this.accountService = accountService;
        this.postService = postService;
    }

    @GetMapping("/feeds")
    public CommonListResponse getFeed(@RequestParam int offset,
                                      @RequestParam int itemPerPage,
                                      @RequestParam String name) {

        Person person = accountService.getCurrentPerson();
        Pageable page = Utils.getPageable(offset, itemPerPage, Sort.by("time").descending());
        Page<Post> posts = postService.findAllByAuthorId(person.getId(), page);
        List<PostResponse> postResponseList = PostResponse.fromPostList(posts.toList());
        return new CommonListResponse("", LocalDateTime.now(), new ArrayList<>(postResponseList));
    }
}
