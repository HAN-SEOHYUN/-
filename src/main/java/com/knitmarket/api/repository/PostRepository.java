package com.knitmarket.api.repository;

import com.knitmarket.api.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {


}
