package com.prueba.cleancode.model;

import lombok.Data;

@Data
public class result {
	
	private User user;
	private Bet bet;
	private Roulette rulleta;
	
	public result(User user, Bet bet, Roulette rulleta) {
		this.bet = bet;
		this.rulleta = rulleta;
		this.user = user;
	}
	public Bet getBet() {
		return bet;
	}
	public Roulette getRulleta() {
		return rulleta;
	}
	public User getUser() {
		return user;
	}
}
