package com.codegym.service.post;

import com.codegym.model.Post;
import com.codegym.service.IGeneralService;

public interface IPostService extends IGeneralService<Post> {
    Iterable<Post>findAllByStatus();
    Iterable<Post>findAllByTitle(String title);
    Iterable<Post>findAllByIdUser(Long id);
    Iterable<Post>findAllByHashtagId(Long top);
    Iterable<Post>findTopByDate(Long top);

    Iterable<Post>findAllByTitleContaining(String title);

    Iterable<Post>findByOtherUser(Long id);
    Iterable<Post>findMyPostByTitle(Long id, String title);
    Iterable<Post>findMyPostByHashtag(Long userId, Long hashtagId);
    Iterable<Post>findAllByHashtagIdAndOrderByUsername(Long id);
    Iterable<Post>findAllByHashtagIdAndOrderByTitle(Long id);

}
