package academy.learnprogramming.controller;

import academy.learnprogramming.service.GameService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.GameMappings;
import academy.learnprogramming.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        if(gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String reset(){
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String guess(@RequestParam int guess){
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }
}
