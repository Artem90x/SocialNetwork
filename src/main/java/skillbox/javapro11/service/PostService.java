package skillbox.javapro11.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import skillbox.javapro11.api.request.CommentRequest;
import skillbox.javapro11.api.request.PostRequest;
import skillbox.javapro11.api.response.CommonListResponse;
import skillbox.javapro11.api.response.CommonResponseData;
import skillbox.javapro11.model.entity.Post;

public interface PostService {
  CommonListResponse getPostSearch(String text,long dateFrom, long dateTo,
                                long offset, int limit);
  CommonResponseData getPostByID(long postId);
  CommonResponseData editPostById(long postId, long publishData, PostRequest postRequest);
  CommonResponseData deletePostById(long postId);
  CommonResponseData recoverPostById(long postId);
  CommonResponseData reportPost(long postId);

  CommonListResponse getComments(long postId, int limit, int offset);
  CommonResponseData editedComment(long postId, Long idComment, CommentRequest comment);
  CommonResponseData deleteComment(long postId, long idComment);
  CommonResponseData reportComment(long postId, long idComment);
  CommonResponseData recoverComment(long postId, long idComment);

    Page<Post> findAllByAuthorId(long id, Pageable page);
}
