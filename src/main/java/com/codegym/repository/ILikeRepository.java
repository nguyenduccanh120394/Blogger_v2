package com.codegym.repository;

import com.codegym.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILikeRepository extends JpaRepository<Like,Long> {
@Query("select p from Like p where p.user.id =:idUser and p.post.id =:idPost")
    Iterable<Like> findAllByIdUserAndIdPost(Long idUser,Long idPost);
}
