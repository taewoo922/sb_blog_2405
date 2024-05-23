package com.example.blog.domain.post.entity;

import com.example.blog.global.security.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
public class Post extends BaseEntity {
    private String title;
    private String content;
}
