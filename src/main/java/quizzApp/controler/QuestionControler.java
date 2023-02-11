package quizzApp.controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizzApp.model.Answer;
import quizzApp.model.Question;
import quizzApp.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/questions")
@Slf4j
@AllArgsConstructor
public class QuestionControler {
    private final QuestionService questionService;

    @GetMapping
    ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Question> getQuestionById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(questionService.getQuestionById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Question> createQuestion(@RequestBody Question question){
        return new ResponseEntity<>(questionService.createQuestion(question), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Question> updateQuestion(@PathVariable(value = "id") Long id, @RequestBody Question question){
        return new ResponseEntity<>(questionService.updateQuestion(id, question), HttpStatus.OK);
    }

    @PutMapping(value = "/addChoices/{id}")
    ResponseEntity<Question> addChoiceToQuestion(@PathVariable(value = "id")Long id, @RequestBody Answer answer){
        return new ResponseEntity<>(questionService.addChoiceToQuestion(id, answer), HttpStatus.OK);
    }

    @PutMapping(value = "/setCorrectAnswer/{id}")
    ResponseEntity<Question> setCorrectAnswer(@PathVariable(value = "id")Long id, @RequestBody Answer answer){
        return new ResponseEntity<>(questionService.setCorrectAnswer(id, answer), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Question> deleteQuestion(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(questionService.deleteQuestion(id), HttpStatus.OK);
    }
}
