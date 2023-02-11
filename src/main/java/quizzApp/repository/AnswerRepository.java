package quizzApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import quizzApp.model.Answer;
import quizzApp.model.Question;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Transactional
    @Query("update Answer a set a.answer = :answer where a.id = :id")
    @Modifying
    int updateAnswer(@Param(value = "answer") String answer, @Param(value = "id") Long id);

    @Transactional
    @Query("update Answer a set a = :answer where a.id = :id")
    @Modifying
    int addQuestions(@Param(value = "answer") Answer answer, @Param(value = "id") Long id);
}
