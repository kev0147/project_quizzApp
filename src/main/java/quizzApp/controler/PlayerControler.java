package quizzApp.controler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quizzApp.model.Game;
import quizzApp.model.Player;
import quizzApp.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/players")
@Slf4j
@AllArgsConstructor
public class PlayerControler {
    private final PlayerService playerService;

    @PostMapping
    ResponseEntity<Player> createPlayer(@RequestBody Player player){
        return new ResponseEntity<>(playerService.createPlayer(player), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Player> getPlayerById(@PathVariable Long id){
        return new ResponseEntity<>(playerService.getPlayerById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/games/{id}")
    ResponseEntity<List<Game>> getGamesFromPlayerById(@PathVariable Long id){
        return new ResponseEntity<>(playerService.getGamesFromPlayer(id), HttpStatus.OK);
    }
}
