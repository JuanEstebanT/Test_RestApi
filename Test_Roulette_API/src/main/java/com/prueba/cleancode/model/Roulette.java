package com.prueba.cleancode.model;

public class Roulette {

	private final long id;
	private int Number;
	private String Color;
	private boolean Status;
	private String Message = "roulette closed";
	
	public Roulette(long id,int numero,String colorString,boolean status) {
		this.id =id;
		this.Number=numero;
		this.Color = colorString;
		this.Status = status;
		}
	public int getNumber() {
		return Number;
	}
	public String getColor() {
		return Color;
	}
	public long getId() {
		return id;
	}
	public boolean getStatus() {
		return Status;
	}
	
	public void setNumber(int Number) {
		this.Number = Number;
	}
	public void setStatus(boolean status) {
		this.Status=status;
	}
	public void setMessage(String Message) {
		this.Message = Message;
	}
	public String getMessage() {
		return Message;
	}
	public void setColor(String Color) {
		this.Color = Color;
	}

}
