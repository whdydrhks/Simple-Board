package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import com.codingrecipe.board.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    // select * from comment_table where board_id=? order by id desc;
    List<CommentEntity> findAllByBoardEntityOrderByIdDesc(BoardEntity boardEntity); // 매개변수로 Long 타입의 ID가 아닌,
    // save를 할 때도, Entity를 기준으로 했으므로, Entity를 넘겨준다.
}
