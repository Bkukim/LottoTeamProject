package org.example.routtoproject.repository.shop;

import org.example.routtoproject.model.entity.shop.Faq;
import org.example.routtoproject.model.entity.shop.Qna;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * packageName : org.example.routtoproject.repository.shop
 * fileName : QNARepository
 * author : hayj6
 * date : 2024-05-13(013)
 * description :
 * 요약 :
 * <p>
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-05-13(013)         hayj6          최초 생성
 */
@Repository
public interface QnaRepository extends JpaRepository<Qna, Integer> {


//    전체 조회 + 페이지
<<<<<<< Updated upstream
@Query(value = "SELECT * FROM LOTTO_QNA WHERE PROD_ID=:prodId"
        ,countQuery = "SELECT count (*) FROM LOTTO_QNA  WHERE PROD_ID=:prodId"
        ,nativeQuery = true)

=======
    @Query(value = "SELECT * FROM LOTTO_QNA WHERE PROD_ID:prodId"
            ,countQuery = "SELECT count (*) FROM LOTTO_QNA WHERE PROD_ID:prodId"
            ,nativeQuery = true)
>>>>>>> Stashed changes
    Page<Qna> findByProdId(int prodId, Pageable pageable);

//    userId가 작성한 글 보기
    @Query(value = "SELECT * FROM LOTTO_QNA\n" +
            "WHERE WRITER_ID LIKE '%'||:writerId||'%'"
            ,countQuery = "SELECT count (*) FROM LOTTO_QNA\n" +
            "WHERE WRITER_ID LIKE '%'|| :writerId ||'%'"
            ,nativeQuery = true)
    Page<Qna> findAllByWriterIdContaining(@Param("writerId") String writerId,
                                        Pageable pageable);

    //    관리자 전체 조회 + 페이지
    @Query(value = "SELECT * FROM LOTTO_QNA"
            ,countQuery = "SELECT count (*) FROM LOTTO_QNA"
            ,nativeQuery = true)

    Page<Qna> findAllByQnaContent(Pageable pageable);

}
