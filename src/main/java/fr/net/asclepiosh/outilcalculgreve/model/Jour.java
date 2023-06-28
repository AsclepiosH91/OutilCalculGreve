package fr.net.asclepiosh.outilcalculgreve.model;


import javafx.beans.property.*;

import java.time.LocalDate;

/**
 * Model class for a Jour.
 *
 * @author Nicolas Torres
 */
public class Jour {
	private final StringProperty typeJour;
	private final IntegerProperty numJour;
	private final ObjectProperty<LocalDate> dateJour;

	/**
	 * Default constructor.
	 */
	public Jour() {
		this(null, null);
	}

	/**
	 * Constructor with some initial data.
	 *
	 * @param numJour
	 * @param typeJour
	 */
	public Jour(Integer numJour, String typeJour) {
		this.numJour = new SimpleIntegerProperty(numJour);
		this.typeJour = new SimpleStringProperty(typeJour);

		// Some initial dummy data, just for convenient testing.
		this.dateJour = new SimpleObjectProperty<LocalDate>(LocalDate.of(1980, 7, 31));
	}


	public void setTypeJour(String typeJour) {
		this.typeJour.set(typeJour);
	}

	public void setNumJour(int numJour) {
		this.numJour.set(numJour);
	}

	public void setDateJour(LocalDate dateJour) {
		this.dateJour.set(dateJour);
	}


	public String getTypeJour() {
		return typeJour.get();
	}

	public StringProperty typeJourProperty() {
		return typeJour;
	}

	public int getNumJour() {
		return numJour.get();
	}

	public IntegerProperty numJourProperty() {
		return numJour;
	}

	public LocalDate getDateJour() {
		return dateJour.get();
	}

	public ObjectProperty<LocalDate> dateJourProperty() {
		return dateJour;
	}
}
