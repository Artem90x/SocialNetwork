package skillbox.javapro11.service;

import skillbox.javapro11.api.response.CommonListResponse;

/**
 * Created by User on 10.06.2021.
 */
public interface FeedService {

    CommonListResponse getNewsList (String name, long offset, int itemPerPage);
}
