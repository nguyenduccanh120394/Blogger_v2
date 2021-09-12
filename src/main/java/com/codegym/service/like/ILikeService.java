package com.codegym.service.like;

import com.codegym.model.Like;
import com.codegym.service.IGeneralService;
import org.springframework.stereotype.Repository;


public interface ILikeService extends IGeneralService<Like> {
    Iterable<Like> findAllByIdUserAndIdPost(Long idUser,Long idPost);
    Iterable<Like> findtop();
    Iterable<Like> findByIdPost(Long idPost);
    Boolean findByUser(Long idUser, Long idPost);
    Iterable<Like> findTop5();

}
