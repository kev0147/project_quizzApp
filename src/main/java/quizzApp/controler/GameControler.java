package quizzApp.controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizzApp.model.Game;
import quizzApp.model.Player;
import quizzApp.service.GameService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/games")
@Slf4j
@AllArgsConstructor
public class GameControler {
    private final GameService gameService;

    @GetMapping
    ResponseEntity<List<Game>> getAnswers(){
        return new ResponseEntity<>(gameService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Game> getAnswerById(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(gameService.getGameById(id), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Game> createGame(){
        return new ResponseEntity<>(gameService.createGame(), HttpStatus.OK);
    }

    @PutMapping(value = "/setScore/{id}")
    ResponseEntity<Game> setGameScore(@PathVariable(value = "id") Long id, @RequestBody Game game){
        return new ResponseEntity<>(gameService.setScore(game.getScore(), id), HttpStatus.OK);
    }

    @PutMapping(value = "/setPlayer/{id}")
    ResponseEntity<Game> setGamePlayer(@PathVariable(value = "id") Long id, @RequestBody Player player){
        return new ResponseEntity<>(gameService.setPlayer(player, id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Game> deleteGame(@PathVariable(value = "id") Long id){
        return new ResponseEntity<>(gameService.deleteGame(id), HttpStatus.OK);
    }
}
