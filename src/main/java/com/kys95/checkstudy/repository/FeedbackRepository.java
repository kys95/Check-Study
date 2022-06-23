package com.kys95.checkstudy.repository;

import com.kys95.checkstudy.model.Feedback;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends org.springframework.data.jpa.repository.JpaRepository<Feedback, Long> {

    @Modifying
    @Query(value = "INSERT INTO reply(userId, taskId, content, createDate) VALUES(?1, ?2, ?3, now())",nativeQuery = true)
    long createReply(long userId, long boardId, String content);
}
