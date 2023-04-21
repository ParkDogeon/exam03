package org.koreait.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member extends BaseEntity{
    @Id @GeneratedValue
    private Long userNo;

    @Column(length = 45, unique = true, nullable = false)
    private String userId;

    @Column(length = 65, nullable = false)
    private String userPw;

    @Column(length = 45, nullable = false)
    private String userNm;

    @Column(length = 100)
    private String email;

    @Column(length = 11)
    private String mobile;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE) // 회원이 작성한 정보를 조회 (Many 쪽이 주인)
    private List<BoardData> boardData = new ArrayList<>();

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY) // 글로벌 전략으로 좋다
    @JoinColumn(name = "addressId")
    private MemberAddress address;

}
