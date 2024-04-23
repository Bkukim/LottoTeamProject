package org.example.routtoproject.model.entity.member;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * packageName : org.example.simpledms.model.common
 * fileName : BaseTimeEntity2
 * author : GGG
 * date : 2024-04-04
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-04         GGG          최초 생성
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity2 {

    private String insertTime;

    private String updateTime;
    //    TODO: 삭제여부 필드 : Y, N (soft delete 용 == update 문 실행)
//     select * from tb_dept where delete_yn = 'N';
    private String withdrawYn;
    //    TODO: 삭제시 시간 필드 (soft delete 용)
    private String withdrawTime;

    @PrePersist
    void OnPrePersist() {
//        insert 하기전에 현재날짜를 넣기 : 날짜포맷(yyyy-MM-dd HH:mm:ss)
        this.insertTime = LocalDateTime.now()
                .format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.withdrawYn = "N";
    }

    @PreUpdate
    void OnPreUpdate() {
//        update 하기전에 현재날짜를 넣기
        this.updateTime = LocalDateTime.now()
                .format(DateTimeFormatter
                        .ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.insertTime = this.updateTime;
        this.withdrawYn = "N";
    }
}

