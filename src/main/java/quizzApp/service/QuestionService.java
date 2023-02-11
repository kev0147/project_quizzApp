package quizzApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quizzApp.model.Answer;
import quizzApp.model.Question;
import quizzApp.repository.AnswerRepository;
import quizzApp.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id){
        return questionRepository.findById(id).get();
    }

    public Question createQuestion(Question question){
        return questionRepository.save(question);
    }

    public Question updateQuestion(Long id, Question question){
        questionRepository.updateQuestion(question.getQuestion(), id);
        return questionRepository.findById(id).get();
    }

    public Question addChoiceToQuestion(Long id, Answer answer){
        Question question = questionRepository.findById(id).get();
        question.getChoices().add(answer);
        questionRepository.setChoices(question, id);

        //answerService.addQuestion(question, answer.getId());
        return questionRepository.findById(id).get();
    }

    public Question setCorrectAnswer(Long id, Answer answer){
        questionRepository.setCorrectAnswer(answer, id);
        return questionRepository.findById(id).get();
    }

    public Question deleteQuestion(Long id){
        questionRepository.delete(questionRepository.findById(id).get());
        return questionRepository.findById(id).get();
    }
}
