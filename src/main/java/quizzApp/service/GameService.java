package quizzApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quizzApp.model.Game;
import quizzApp.model.Player;
import quizzApp.model.Question;
import quizzApp.repository.GameRepository;
import quizzApp.repository.PlayerRepository;
import quizzApp.repository.QuestionRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;
    private final QuestionService questionService;

    public Game createGame(){
        Game game = new Game();
        List<Question> questionsList = questionService.getAllQuestions();
        Collections.shuffle(questionsList);
        if(questionsList.size() > 5){
            game.setQuestions(questionsList.subList(0,4));
        }else{
            game.setQuestions(questionsList);
        }
        gameRepository.save(game);
        return game;
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    public Game getGameById(Long id){
        return gameRepository.findById(id).get();
    }

    public Game setPlayer(Player player, Long id){
        Game game = gameRepository.findById(id).get();
        game.setPlayer(player);
        gameRepository.updateGame(game, id);
        return gameRepository.findById(id).get();
    }

    public Game setScore(int score, Long id){
        Game game = gameRepository.findById(id).get();
        game.setScore(score);
        gameRepository.updateGame(game, id);
        return gameRepository.findById(id).get();
    }

    public Game deleteGame(Long id){
        Game game = gameRepository.findById(id).get();
        gameRepository.delete(gameRepository.findById(id).get());
        return game;
    }
}
