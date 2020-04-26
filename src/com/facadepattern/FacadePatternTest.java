package com.facadepattern;

import java.util.*;

public class FacadePatternTest {

	public static void main(String[] args) {

		String username = "john";
		String password = "doe";

		String cardNumber = "4241-8923-1979-1398-6983";
		Date lastUsage = null;
		int CVC = 678;
		String itemName = "XBox";
		double purchaseAmount = 2;
		double unitPrice = 100;
		double shippingPrice = 10;

		withoutFacade(username, password, cardNumber, lastUsage, CVC, itemName, purchaseAmount, unitPrice,
				shippingPrice);
		System.out.println();

		withFacade(username, password, cardNumber, lastUsage, CVC, itemName, purchaseAmount, unitPrice, shippingPrice);
	}

	static void withoutFacade(String username, String password, String cardNumber, Date lastUsage, int CVC,
			String itemName, double purchaseAmount, double unitPrice, double shippingPrice) {
		Database database = new Database();
		Connection connection = database.getConnection(username, password);
		Warehouse warehouse = connection.getWarehouse();
		CreditCardTransaction cct = new CreditCardTransaction();
		if (cct.checkCard(cardNumber, lastUsage, CVC)) {
			connection.startTransaction();

			double moneyAmount = purchaseAmount * unitPrice + shippingPrice;
			if (cct.witdrawMoney(cardNumber, lastUsage, CVC, moneyAmount)) {
				System.out.println(warehouse.getAmount(itemName) + " units " + itemName + " are in warehouse");
				warehouse.retrieve(itemName, purchaseAmount);
				System.out.println(purchaseAmount + " units " + itemName + " are purchased");
				System.out.println(warehouse.getAmount(itemName) + " units " + itemName + " remains in the warehouse");
				connection.commitTransaction();
			} else
				connection.rollbackTransaction();
		}
		connection.close();
	}

	static void withFacade(String username, String password, String cardNumber, Date lastUsage, int CVC,
			String itemName, double purchaseAmount, double unitPrice, double shippingPrice) {
		ShoppingFacade shoppingFacade = new ShoppingFacade(username, password);
		shoppingFacade.buyItem(cardNumber, lastUsage, CVC, itemName, purchaseAmount, unitPrice, shippingPrice);
	}

}

class ShoppingFacade {
	private String username;
	private String password;

	ShoppingFacade(String username, String password) {
		this.username = username;
		this.password = password;
	}

	void buyItem(String cardNumber, Date lastUsage, int CVC, String itemName, double purchaseAmount, double unitPrice,
			double shippingPrice) {
		Database database = new Database();
		Connection connection = database.getConnection(username, password);
		Warehouse warehouse = connection.getWarehouse();
		CreditCardTransaction cct = new CreditCardTransaction();
		if (cct.checkCard(cardNumber, lastUsage, CVC)) {
			connection.startTransaction();

			double moneyAmount = purchaseAmount * unitPrice + shippingPrice;
			if (cct.witdrawMoney(cardNumber, lastUsage, CVC, moneyAmount)) {
				System.out.println(warehouse.getAmount(itemName) + " units " + itemName + " are in warehouse");
				warehouse.retrieve(itemName, purchaseAmount);
				System.out.println(purchaseAmount + " units " + itemName + " are purchased");
				System.out.println(warehouse.getAmount(itemName) + " units " + itemName + " remains in the warehouse");
				connection.commitTransaction();
			} else
				connection.rollbackTransaction();
		}
		connection.close();
	}

}

class Connection {
	Warehouse getWarehouse() {
		Warehouse warehouse = new Warehouse();
		warehouse.add("XBox", 5);
		warehouse.add("PS4", 4);
		warehouse.add("Nintendo", 15);
		warehouse.add("XBox", 4);

		return warehouse;
	}

	void startTransaction() {

	}

	void commitTransaction() {

	}

	void rollbackTransaction() {

	}

	void close() {

	}
}

class Database {

	Connection getConnection(String userName, String password) {
		// dummy get connection code
		return new Connection();
	}

}

class CreditCardTransaction {
	boolean checkCard(String cardNumber, Date lastUsage, int CVC) {
		// dummy get connection code
		return true;
	}

	boolean witdrawMoney(String cardNumber, Date lastUsage, int CVC, double amount) {
		if (checkCard(cardNumber, lastUsage, CVC)) {
			// dummy get connection code
			return true;
		} else
			return false;
	}
}

class Warehouse {
	private final Map<String, Double> items = new HashMap<String, Double>();

	void add(String itemName, double amount) {
		Double itemAmount = items.get(itemName);
		if (itemAmount == null)
			items.put(itemName, amount);
		else
			items.put(itemName, itemAmount + amount);
	}

	boolean retrieve(String itemName, double amount) {
		Double itemAmount = items.get(itemName);
		if (itemAmount == null || itemAmount < amount)
			return false;
		else {
			items.put(itemName, itemAmount - amount);
			return true;
		}
	}

	double getAmount(String itemName) {
		Double itemAmount = items.get(itemName);
		if (itemAmount == null)
			return 0.0;
		else
			return itemAmount;
	}

}