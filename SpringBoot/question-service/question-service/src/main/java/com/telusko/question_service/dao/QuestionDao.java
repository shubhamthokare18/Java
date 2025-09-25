package com.telusko.queston_service.dao;

import com.telusko.queston_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
    List<Question> findByCategory(String category);
    @Query(value = "SELECT q.id FROM question q WHERE q.category = :category ORDER BY DBMS_RANDOM.VALUE FETCH FIRST :numQ ROWS ONLY",
            nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(@Param("category") String category,
                                                 @Param("numQ") int numQ);

}