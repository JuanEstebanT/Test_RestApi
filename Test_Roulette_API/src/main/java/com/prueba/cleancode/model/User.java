package com.prueba.cleancode.model;
public class User {
	
	private final long id;
	private String nombre;
	private double balance;

	public User(long id, String nombre, double balance) {
		this.id = id;
		this.nombre = nombre;
		this.balance = balance;
	}
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setNombre(String name) {
		this.nombre = name;
	}

	
}
