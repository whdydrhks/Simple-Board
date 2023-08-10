package com.codingrecipe.board.repository;

import com.codingrecipe.board.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    // update board_table set board_hits=board_hits+1 where id=?
    @Modifying // update나 delete 쿼리를 실행할 때 사용
    @Query(value = "update BoardEntity b set b.boardHits=b.boardHits+1 where b.id=:id") // Entity가 기준일땐, b 처럼 약어를 사용한다. 컬럼은 Entity에서 지정한 값으로.
    void updateHits(@Param("id") Long id); // @Param의 id가 위 where b.id=:id 의 두번째 id에 해당
}