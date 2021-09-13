package com.codegym.service.like;

import com.codegym.model.Like;
import com.codegym.repository.ILikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements ILikeService {
    @Autowired
    private ILikeRepository likeRepository;

    @Override
    public Iterable<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Optional<Like> findById(Long id) {
        return likeRepository.findById(id);
    }

    @Override
    public Like save(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void remove(Long id) {
        likeRepository.deleteById(id);
    }

    @Override
    public Optional<Like> findByIdUserAndIdPost(Long idUser, Long idPost) {
        return likeRepository.findByIdUserAndIdPost(idUser, idPost);
    }

    @Override
    public Iterable<Like> findtop() {
        return likeRepository.findtop();
    }

    @Override
    public List<Like> findByIdPost(Long idPost) {
        return likeRepository.findByIdPost(idPost);
    }

    @Override
    public Boolean findByUser(Long idUser, Long idPost) {
        boolean a = true;
        List<Like> likes = likeRepository.findAll();
        for (int i = 0; i < likes.size(); i++) {
            if (likes.get(i).getUser().getId() == idUser && likes.get(i).getPost().getId() == idPost ) {
                a = false;
            }
        }
        return a;
    }



    @Override
    public Iterable<Like> findTop5() {
        return likeRepository.findTop5();
    }

}
