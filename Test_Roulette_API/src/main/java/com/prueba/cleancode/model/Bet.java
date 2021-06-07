package com.prueba.cleancode.model;

import lombok.Data;

@Data
public class Bet {
	
	private double moneybet;
	private String typeofbet;
	private long RouletteID;
	private int Number;
	private String color;
	private String Message;
	private boolean status;
	
	public Bet(double moneybet,String typeofbet,long RouletteID,int number) {
		this.moneybet = moneybet;
		this.typeofbet = typeofbet;
		this.RouletteID= RouletteID;
		this.Number = number;
	}
	
	public double getMoneybet() {
		return moneybet;
	}
	public String getTypeofbet() {
		return typeofbet;
	}
	public void setMoneybet(double moneybet) {
		this.moneybet = moneybet;
	}
	public void setTypeofbet(String typeofbet) {
		this.typeofbet = typeofbet;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public int getNumber() {
		return Number;
	}
	public void setNumber(int Number) {
		this.Number = Number;
	}
	public void setRouletteID(long RouletteID) {
		this.RouletteID = RouletteID;
	}
	public long getRouletteID() {
		return RouletteID;
	}
	public void setMessage(String Message) {
		this.Message = Message;
	}
	public String getMessage() {
		return Message;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean getStatus() {
		return status;
	}
}
