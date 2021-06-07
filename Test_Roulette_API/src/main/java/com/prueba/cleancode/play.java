package com.prueba.cleancode;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.cleancode.controller.BetController;
import com.prueba.cleancode.controller.RouletteController;
import com.prueba.cleancode.controller.UserController;
import com.prueba.cleancode.model.Bet;
import com.prueba.cleancode.model.Roulette;
import com.prueba.cleancode.model.User;
import com.prueba.cleancode.model.result;


@RestController
public class play {
	
	private UserController userController = new UserController();
	private User User = new User(1, null, 0);
	private RouletteController RouletteController = new RouletteController();
	private Bet bet = new Bet(0, null, 0, 0);
	private BetController BetController = new BetController();
	ArrayList<Roulette> Roulettes = new ArrayList<Roulette>();
	
	@GetMapping("/User")
	public User SeeUser() {
		return userController.infoUser(User);
	}
	
	@PutMapping("/User")
	public User Edit(@RequestParam (value = "name", defaultValue = "Anon") String name,@RequestParam double balance){
		return userController.Edit(name, balance, User);
	}
	
	@PostMapping("/Ruleta")
	public Roulette Create() {
		return RouletteController.createRoulette(Roulettes);
	}
	
	@GetMapping("/Ruleta")
	public ArrayList<Roulette> seeRoulette(){
		return RouletteController.verRuletas(Roulettes);
		
	}
	
	@GetMapping("/Ruleta/opening/{id}")
	public Roulette Open(@PathVariable("id") long RouletteID){
		return RouletteController.openingRoulette(RouletteID, Roulettes);
	}
	
	@PostMapping("/bet/color")
	public Bet CreateBetColor(@RequestParam long RouletteID,@RequestParam String color,@RequestParam double moneybet,@RequestHeader int userID) {
		return BetController.createBetColor(bet, color,RouletteID,moneybet, BetController.rouletteValidator(Roulettes, RouletteID), BetController.validateplayerbalance(moneybet,User,userID),BetController.maxBetValidator(moneybet),User);
	}
	
	@PostMapping("/bet/number")
	public Bet CreateBetNumber(@RequestParam long RouletteID,@RequestParam int number,@RequestParam double moneybet,@RequestHeader int userID) {
		return BetController.CrearBetNumber(bet, number,RouletteID,moneybet, BetController.rouletteValidator(Roulettes, RouletteID), BetController.validateplayerbalance(moneybet,User,userID),BetController.maxBetValidator(moneybet),BetController.ValidateNumber(number),User);
	}
	
	@GetMapping("/Ruleta/closing/{id}")
	public result Closing(@PathVariable("id") long RouletteID) {
		RouletteController.rouletteSpin(RouletteID,Roulettes,BetController.rouletteValidator(Roulettes, RouletteID));
		return RouletteController.closingRoulette(RouletteID, Roulettes, bet, User);
	}
	

}
