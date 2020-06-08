package com.mvcpattern;

import java.util.*;

public class ModelViewControllerConsole {

	public static void main(String[] args) {
		// connect to database with a Person table
		Database.createDataset("Person");

		// create Model, View, and Controller instance
		PersonModel model = new PersonModel();
		PersonView view = new PersonView();
		PersonController controller = new PersonController(model, view);

		// update view
		controller.updateView();

		// update model data
		controller.addPerson("Fatih", "Nar", 100);
		controller.addPerson("Serap", "Nar", 101);
		controller.addPerson("Asya", "Nar", 102);
		controller.addPerson("Murat", "Nar", 105);
		controller.addPerson("Tunak", "Nar", 103);

		// update view
		controller.updateView("showEveryone");

		controller.updatePerson(103, "Tuna", "Nar");

		// update view
		controller.updateView("showPerson", 103);

		controller.deletePerson(105);

		// update view
		controller.updateView("showEveryone");
	}

}

// Model View Controller (MVC) pattern for Person table
class PersonModel {

	Dataset getPersondataset() {
		return Database.getDataset("Person");
	}

}

class PersonView {

	void showMenu() {
		System.out.println("Menu is shown on the screen");
	}

	void showDataset(Dataset dataset) {
		System.out.println(dataset);
	}

	void showDatarow(Datarow datarow) {
		System.out.println(datarow);
	}

}

class PersonController {
	private final PersonModel model;
	private final PersonView view;

	public PersonController(PersonModel model, PersonView view) {
		this.model = model;
		this.view = view;
	}

	public Dataset getEveryone() {
		System.out.println(" > MODEL : retrieve everyone ");

		return model.getPersondataset();
	}

	public Datarow getPerson(int identityNumber) {
		System.out.println(" > MODEL : retrieve person with identityNumber = " + identityNumber);

		return Database.getDataset("Person").select(identityNumber);
	}

	public void addPerson(String name, String surname, int identityNumber) {
		System.out.println(" > MODEL : add person (" + name + " " + surname + ", " + identityNumber + ")");

		Database.getDataset("Person").insert(new PersonDatarow(name, surname, identityNumber));
	}

	public void deletePerson(int identityNumber) {
		System.out.println(" > MODEL : delete person with identityNumber = " + identityNumber);

		Database.getDataset("Person").delete(identityNumber);
	}

	public void updatePerson(int identityNumber, String name, String surname) {
		System.out.println(" > MODEL : update person with identityNumber = " + identityNumber + " as (" + name + " "
				+ surname + ")");

		Database.getDataset("Person").update(new PersonDatarow(name, surname, identityNumber));
	}

	public void updateView() {
		updateView(null, null);
	}

	public void updateView(String parameterName) {
		updateView(parameterName, null);
	}

	public void updateView(String parameterName, Object parameterValue) {
		System.out.println();

		String messageToView = " > VIEW : updateView(" + parameterName + ", " + parameterValue + ")";
		System.out.println(messageToView);
		System.out.println(String.join("", Collections.nCopies(messageToView.length(), "-")));

		if (parameterName == null) {
			view.showMenu();
		} else {
			switch (parameterName) {
			case "showPerson":
				int identityNumber = (Integer) parameterValue;
				view.showDatarow(getPerson(identityNumber));
				break;
			case "showEveryone":
				view.showDataset(getEveryone());
				break;
			}
		}

		System.out.println();
	}
}

// third-party database server (simple simulation)
class Database {
	private static final Map<String, Dataset> datasets = new HashMap<String, Dataset>();

	private Database() {

	}

	static void createDataset(String datasetName) {
		datasets.put(datasetName, new Dataset());
	}

	static void dropDataset(String datasetName) {
		datasets.remove(datasetName);
	}

	static Dataset getDataset(String datasetName) {
		return datasets.get(datasetName);
	}

}

class Dataset {
	private final Map<Integer, Datarow> data = new HashMap<Integer, Datarow>();

	int getRowCount() {
		return data.size();
	}

	List<Datarow> selectAll() {
		List<Datarow> rows = new ArrayList<Datarow>();

		for (Map.Entry<Integer, Datarow> entry : data.entrySet()) {
			rows.add(entry.getValue());
		}

		return rows;
	}

	Datarow select(int identityNumber) {
		return data.get(identityNumber);
	}

	boolean delete(int key) {
		return (data.remove(key) != null);
	}

	boolean insert(Datarow datarow) {
		return (data.put(datarow.getKey(), datarow) != null);
	}

	boolean update(Datarow datarow) {
		if (data.containsKey(datarow.getKey())) {
			return (data.put(datarow.getKey(), datarow) != null);
		} else
			return false;
	}

	@Override
	public String toString() {
		if (data.size() > 0) {
			StringBuilder sb = new StringBuilder();

			boolean fetchFieldNames = true;
			for (Map.Entry<Integer, Datarow> entry : data.entrySet()) {
				Datarow datarow = entry.getValue();

				if (fetchFieldNames) {
					for (int i = 0; i < datarow.fieldCount(); i++) {
						sb.append(datarow.getColumnName(i) + "\t");
					}
					sb.append("\n");

					fetchFieldNames = false;
				}

				for (int i = 0; i < datarow.fieldCount(); i++) {
					sb.append(datarow.getFieldData(i) + "\t");
				}
				sb.append("\n");
			}

			return sb.toString();
		} else {
			return "No data.";
		}
	}

}

class Person {
	final String name;
	final String surname;
	final int identityNumber;

	Person(String name, String surname, int identityNumber) {
		this.name = name;
		this.surname = surname;
		this.identityNumber = identityNumber;
	}
}

interface Datarow {
	int fieldCount();

	int getKey();

	String getColumnName(int index);

	Object getFieldData(int index);
}

class PersonDatarow implements Datarow {
	public final Person person;

	PersonDatarow(String name, String surname, int identityNumber) {
		person = new Person(name, surname, identityNumber);
	}

	PersonDatarow(Person person) {
		this.person = person;
	}

	Person get() {
		return person;
	}

	@Override
	public int fieldCount() {
		return 3;
	}

	@Override
	public int getKey() {
		return person.identityNumber;
	}

	@Override
	public String getColumnName(int index) {
		switch (index) {
		case 0:
			return "Name";
		case 1:
			return "Surname";
		case 2:
			return "IdentityNumber";
		default:
			return null;
		}
	}

	@Override
	public Object getFieldData(int index) {
		switch (index) {
		case 0:
			return person.name;
		case 1:
			return person.surname;
		case 2:
			return person.identityNumber;
		default:
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < fieldCount(); i++) {
			sb.append(getColumnName(i) + "\t");
		}
		sb.append("\n");

		for (int i = 0; i < fieldCount(); i++) {
			sb.append(getFieldData(i) + "\t");
		}
		sb.append("\n");

		return sb.toString();
	}

}