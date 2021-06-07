package com.prueba.cleancode.controller;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import com.prueba.cleancode.model.Bet;
import com.prueba.cleancode.model.Roulette;
import com.prueba.cleancode.model.User;
import com.prueba.cleancode.model.result;

public class RouletteController {
	private final AtomicLong counter = new AtomicLong();
	public Roulette createRoulette(ArrayList<Roulette> Roulettes) {
		Roulette roulette = new Roulette(counter.incrementAndGet(), 0, null, false);
		Roulette NewRoulette = null;
		Roulettes.add(roulette);
		for (Roulette ListRoulettes : Roulettes) {
			if(ListRoulettes.getId() == counter.longValue()) {
				NewRoulette = ListRoulettes;
			}
		}
		 return NewRoulette;
	}
	
	public Roulette findRoulette(ArrayList<Roulette> ruletas, long id) {
		Roulette rulletaFound = null;
		for (Roulette rulteRulleta : ruletas) {
			if(rulteRulleta.getId() == id) {
				rulletaFound = rulteRulleta;
			}
		}
		return rulletaFound;
	}

	public Roulette openingRoulette(long id, ArrayList<Roulette> Roulettes){
		
		Roulette newStateRoulette = null;
		for (Roulette listRoulette : Roulettes) {
			if(listRoulette.getId() == id) {
				listRoulette.setStatus(true);
				listRoulette.setMessage("Ruleta abierta");
				newStateRoulette=listRoulette;
				System.out.println("Roulette opening was successful");
			}else {
				System.err.println("The roulette wheel was opened incorrectly"); 
				}
		}
		return newStateRoulette;
	}
	
	public boolean rouletteSpin(long id, ArrayList<Roulette> roulettes,boolean validator) {
		boolean Spinsuscces = false;
		if(validator == true) {
			for (Roulette listRoulette : roulettes) {
				if (listRoulette.getId() == id) {
					listRoulette.setNumber(RandomNumber());
					listRoulette.setColor(Color(listRoulette.getNumber()));
					Spinsuscces = true;
				}
			}
		}else {
			System.err.println("Mesa cerrada");
			Spinsuscces = false;
		}
		return Spinsuscces;
	}
	
	public int winningNumber(ArrayList<Roulette> Roulettes, long id) {
		int winningNumber = 0;
		for (Roulette listRoulette : Roulettes) {
			if (listRoulette.getId() == id) {
				winningNumber = listRoulette.getNumber();
			}
		}
		return winningNumber;
	}
	
	public String WinnigColor(ArrayList<Roulette> roulettes, long id) {
		String winningColor = "";
		for (Roulette listRoulette: roulettes) {
			if (listRoulette.getId() == id) {
				winningColor = listRoulette.getColor();
			}
		}
		return winningColor;
	}
	
	public void gameRoulette(Bet bet, User user, ArrayList<Roulette> Roulettes, long id) {
		if(bet.getStatus()== true) {
		switch (bet.getTypeofbet()) {
		case "number":
			if(winningNumber(Roulettes, id) == bet.getNumber()) {
				user.setBalance(user.getBalance() + bet.getMoneybet()*5);
				bet.setMessage("bet won");
			}else {
				bet.setMessage("lost bet");
			}
			break;
		case "color":
			if(WinnigColor(Roulettes, id).equals(bet.getColor())) {
				user.setBalance(user.getBalance() + bet.getMoneybet()*1.8);
				bet.setMessage("bet won");
			}else {
				bet.setMessage("lost bet");
			}
			break;
		default:
			System.err.println("Bet Error");
			break;
		}
		}else {
			System.err.println("Error en la apuesta estado"+bet.getStatus());
		}
	}
	
	public result closingRoulette(long id, ArrayList<Roulette> Roulette,Bet bet, User user){
		result results = null;
		for (Roulette listRoulette: Roulette) {
			if(listRoulette.getId() == id) {
				listRoulette.setStatus(false);
				listRoulette.setMessage("Ruleta cerrada");
				gameRoulette(bet, user, Roulette, id);
				results = new result(user, bet, findRoulette(Roulette, id));
				System.out.println("The closing of the roulette has been carried out correctly");
			}else {
				System.err.println("The roulette has been closed incorrectly"); 
				}
		}
		return results;
	}
	
	public ArrayList<Roulette> verRuletas(ArrayList<Roulette> ruletas) {
		return ruletas;
	
	}
	
	public int RandomNumber () {
		int randomNumber = (int) Math.floor(Math.random()*37);
		return randomNumber;
	}
	
	public String Color(int number) {
		String color;
		if(number % 2 == 0) {
			color = "red";
		}else {
			color = "black";
		}
		return color;
	}
	
	
	
}
