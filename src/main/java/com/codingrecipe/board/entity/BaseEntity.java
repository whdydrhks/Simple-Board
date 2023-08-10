package com.codingrecipe.board.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
    @CreationTimestamp // 생성 시간을 만들어준다.
    @Column(updatable = false) // 수정시에 반영을 안한다
    private LocalDateTime createdTime;

    @UpdateTimestamp // 업데이트 시간을 지정
    @Column(insertable = false) // 입력시 반영을 안한다
    private LocalDateTime updatedTime;
}
