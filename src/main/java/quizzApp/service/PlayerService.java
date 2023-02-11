package quizzApp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import quizzApp.model.Game;
import quizzApp.model.Player;
import quizzApp.repository.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PlayerService {
    private final PlayerRepository playerRepository;

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id){
        return playerRepository.findById(id).get();
    }

    public Player addGame(Game game, Long id){
        Player player = playerRepository.findById(id).get();
        player.getGames().add(game);
        playerRepository.addGame(player, id);
        return playerRepository.findById(id).get();
    }

    public List<Game> getGamesFromPlayer(Long playerId){
        return playerRepository.findById(playerId).get().getGames();
    }
}
