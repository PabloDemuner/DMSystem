package com.dmsystem.vendasdeprodutos.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	/*
	 * Método que percorre todos os Enums, caso não seja
	 * ele lança uma excessão.
	 */
	public static OrderStatus valueOf(int code) {
		
		for (OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Valor digitado não correspondente");
	}
}
