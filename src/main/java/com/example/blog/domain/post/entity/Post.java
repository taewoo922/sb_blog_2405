package com.example.blog.domain.post.entity;

import com.example.blog.domain.member.entity.Member;
import com.example.blog.global.security.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;



@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post extends BaseEntity {
    private String title;
    private String content;
    private String thumbnailImg;
}
