package com.example.demo.post.infrastructure;

import com.example.demo.post.service.port.PostRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class PostRepositoryImpl implements PostRepository {

    private final PostJpaRepository postJpaRepository;

    @Override
    public Optional<com.example.demo.post.domain.Post> findById(final long id) {
        return postJpaRepository.findById(id).map(PostEntity::toModel);
    }

    @Override
    public com.example.demo.post.domain.Post save(final com.example.demo.post.domain.Post post) {
        return postJpaRepository.save(PostEntity.fromModel(post)).toModel();
    }

}

