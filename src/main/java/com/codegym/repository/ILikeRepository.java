package com.codegym.repository;

import com.codegym.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ILikeRepository extends JpaRepository<Like,Long> {


@Query("select p from Like p where p.user.id =:idUser and p.post.id =:idPost")
    Iterable<Like> findAllByIdUserAndIdPost(Long idUser,Long idPost);
@Query(value = " select *  from likes group by post_id order by count(post_id)desc ; ",nativeQuery = true)
    Iterable<Like> findtop();
}
