package com.planmate.server.repository;

import com.planmate.server.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findByMemberId(Long ownerId,Pageable pageable);
    @Query("select p from Post p where p.postId = :postId " + "and p.memberId = :memberId")
    Optional<Post> findMemberPost(@Param("postId") Long postId,@Param("memberId") Long memberId);

    @Query("select p from Post p where p.type = :type")
    Page<Post> findPostByPage(@Param("type") Long type,Pageable pageable);
}
