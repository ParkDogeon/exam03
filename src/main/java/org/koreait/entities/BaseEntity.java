package org.koreait.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass // 공통속성이자 상위클래스라는 것을 알려준다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity { // 공통처리 -> 추상

    @CreatedDate
    @Column(updatable = false) // @CreatedDate 가 추가할때만 들어가도록 하기 위해서
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime regDt;

    @LastModifiedDate
    @Column(insertable = false) // @LastModifiedDate 가 바뀔때만
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modDt;
}
