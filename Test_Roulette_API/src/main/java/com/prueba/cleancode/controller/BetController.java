package com.prueba.cleancode.controller;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.cleancode.model.Bet;
import com.prueba.cleancode.model.Roulette;
import com.prueba.cleancode.model.User;

@RestController
public class BetController {
	
	public boolean ValidateNumber(int numberbet) {
		boolean answer = false;
		if (numberbet>=0 && numberbet <=36) {
			answer=true;
		}else {
			answer=false;
		}
		return answer;
	}
	
	public boolean validateplayerbalance(double moneybet,User user, int idUser) {
		boolean answer = false;
		if (user.getId()==idUser) {
			if(user.getBalance() >= moneybet) {
				answer = true;
			}else {
				answer = false;
			}
		}
		return answer;
	}
	
	
	public boolean rouletteValidator(ArrayList<Roulette> roulettes, long RouletteID) {
		boolean answer = false;
		for (Roulette listRoulette : roulettes) {
			if(listRoulette.getId() == RouletteID) {
				answer = listRoulette.getStatus();
			}
		}
		return answer;
	}
	
	public boolean maxBetValidator(double moneyBet) {
		boolean answer = false;
		if (moneyBet <= 10000) {
			answer = true;
		}
		return answer;
	}
	
	public Bet createBetColor(Bet bet,String color,long RouletteID, double moneybet,boolean validator1,boolean validator2,boolean validator3,User user){
		
		if(validator1 == true && validator2 == true && validator3 == true) {
			user.setBalance(user.getBalance()-moneybet);
			bet.setMoneybet(moneybet);
			bet.setColor("color");
			bet.setRouletteID(RouletteID);
			bet.setColor(color);
			bet.setMessage("Apuesta en proceso");
			
		}else {
			bet.setMoneybet(0);
			bet.setTypeofbet("NULL");
			bet.setRouletteID(RouletteID);
			bet.setNumber(0);
			bet.setMessage("Apuesta incorrecta");
		}

		return bet;
	}
	public Bet CrearBetNumber(Bet bet,int number,long RouletteID, double moneybet,boolean validator1,boolean validator2,boolean validator3, boolean validator4 ,User user){
		if(validator1 == true && validator2 == true && validator3==true && validator4==true) {
			user.setBalance(user.getBalance()-moneybet);
			bet.setMoneybet(moneybet);
			bet.setTypeofbet("number");
			bet.setRouletteID(RouletteID);
			bet.setNumber(number);
			bet.setColor(null);
			bet.setMessage("Apuesta en proceso");
		}else {
			bet.setMoneybet(0);
			bet.setTypeofbet("NULL");
			bet.setRouletteID(0);
			bet.setNumber(0);
			bet.setMessage("Apuesta incorrecta");
		}
		return bet;
	}
	
}
