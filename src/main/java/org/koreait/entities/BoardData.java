package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseEntity{
    @Id @GeneratedValue
    private Long id; // 게시글 번호

    @Column(nullable = false)
    private String subject; // 제목

    @Lob @Column(nullable = false)
    private String content; // 내용

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member; // id_userNo
}
