package com.example.demo.post.domain;

import com.example.demo.user.domain.User;
import java.time.Clock;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private Long id;
    private String content;
    private Long createdAt;
    private Long modifiedAt;
    private User writer;

    @Builder
    public Post(final Long id, final String content, final Long createdAt, final Long modifiedAt,
                final User writer) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.writer = writer;
    }

    public static Post from(final User writer, final PostCreate postCreateDto) {
        return Post.builder()
                .content(postCreateDto.getContent())
                .writer(writer)
                .createdAt(Clock.systemUTC().millis())
                .build();
    }

    public Post update(final PostUpdate postUpdate) {
        return Post.builder()
                .id(id)
                .content(postUpdate.getContent())
                .createdAt(createdAt)
                .modifiedAt(Clock.systemUTC().millis())
                .writer(writer)
                .build();
    }

}
