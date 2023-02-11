package quizzApp.controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizzApp.model.Answer;
import quizzApp.service.AnswerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/answers")
@Slf4j
@AllArgsConstructor
public class AnswerControler {
    private final AnswerService answerService;

    @GetMapping
    ResponseEntity<List<Answer>> getAnswers(){
        return new ResponseEntity<>(answerService.getAllAnswers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Answer> getAnswerById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(answerService.getAnswerById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        return new ResponseEntity<>(answerService.createAnswer(answer), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer, @PathVariable(value = "id")Long id){
        return new ResponseEntity<>(answerService.updateAnswer(answer, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Answer> deleteAnswer(@PathVariable(value = "id") Long id){
        answerService.deleteAnswer(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
