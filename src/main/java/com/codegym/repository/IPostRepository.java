package com.codegym.repository;

import com.codegym.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends PagingAndSortingRepository<Post, Long> {

    @Query("select p from Post p where p.status = 'public' order by p.date desc")
    Iterable<Post>findAllByStatus();

    Iterable<Post>findAllByTitleContaining(String title);

    @Query(value = "select * from post where post.user_id =:id and post.title like  :title order by post.date desc ", nativeQuery = true)
    Iterable<Post>findAllMyPostByTitle(Long id,String title);

    @Query("select p from Post p where p.user.id =:id order by p.date desc ")
    Iterable<Post>findAllByIdUser(Long id);

    @Query("select p from Post p where p.user.id =:id  and  p.status = 'public'")
    Iterable<Post>findAllByIdUserOther(Long id);

    Iterable<Post>findAllByHashtagId(Long id);

    @Query(value = "select * from post order by post.date desc limit :top" , nativeQuery = true)
    Iterable<Post>findTopByDate(Long top);




}
