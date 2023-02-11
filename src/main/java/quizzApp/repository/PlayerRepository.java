package quizzApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import quizzApp.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Transactional
    @Query("update Player p set p = :player where p.id= :id")
    @Modifying
    int addGame(@Param(value = "player") Player player, @Param(value = "id")Long id);

    @Query("select Game from Player p where p.id= :id")
    int getGames(@Param(value = "id")Long id);
}
