package quizzApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import quizzApp.model.Game;
import quizzApp.model.Player;
import quizzApp.model.Question;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Transactional
    @Query("update Game g set g = :game where g.id= :id")
    @Modifying
    int updateGame(@Param(value = "game") Game game, @Param(value = "id") Long id);
}
