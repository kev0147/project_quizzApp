package quizzApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quizzApp.model.Answer;
import quizzApp.model.Question;
import quizzApp.repository.AnswerRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }

    public List<Answer> getAllAnswers(){
        return answerRepository.findAll();
    }

    public Answer getAnswerById(long id){
        return answerRepository.findById(id).get();
    }

    public Answer updateAnswer(Answer answer, Long id){
        answerRepository.updateAnswer(answer.getAnswer(), id);
        return answerRepository.findById(id).get();
    }

    public Answer addQuestion(Question question, Long id){
        Answer answer=answerRepository.findById(id).get();
        answer.getQuestions().add(question);
        answerRepository.addQuestions(answer, id);
        return answerRepository.findById(id).get();
    }

    public void deleteAnswer(Long id){
        Answer answer=answerRepository.getById(id);
        answerRepository.delete(answer);
    }
}
