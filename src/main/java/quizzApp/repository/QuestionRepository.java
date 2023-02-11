package quizzApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import quizzApp.model.Answer;
import quizzApp.model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Transactional
    @Query("update Question q set q.question = :question where q.id= :id")
    @Modifying
    int updateQuestion(@Param(value = "question") String question, @Param(value = "id") Long id);

    @Transactional
    @Query("update Question q set q.correctResponse = :answer where q.id= :id")
    @Modifying
    int setCorrectAnswer(@Param(value = "answer") Answer answer, @Param(value = "id") Long id);

    @Transactional
    @Query("update Question q set q = :question where q.id= :id")
    @Modifying
    int setChoices(@Param(value = "question") Question question, @Param(value = "id") Long id);
}
