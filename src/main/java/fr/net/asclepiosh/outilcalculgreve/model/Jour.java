package fr.net.asclepiosh.outilcalculgreve.model;


import fr.net.asclepiosh.outilcalculgreve.util.LocalDateAdapter;
import javafx.beans.property.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * Model class for a Jour.
 *
 * @author Nicolas Torres
 */
public class Jour {
	private final StringProperty typeJour;
	private final StringProperty nomJour;
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
	 * @param nomJour
	 * @param typeJour
	 */
	public Jour(String nomJour, String typeJour) {
		this.nomJour = new SimpleStringProperty(nomJour);
		this.typeJour = new SimpleStringProperty(typeJour);


		// Some initial dummy data, just for convenient testing.
		this.dateJour = new SimpleObjectProperty<LocalDate>(LocalDate.of(2000, 1, 1));
	}


	public void setTypeJour(String typeJour) {
		this.typeJour.set(typeJour);
	}

	public void setNomJour(String nomJour) {
		this.nomJour.set(nomJour);
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

	public String getNomJour() {
		return nomJour.get();
	}

	public StringProperty nomJourProperty() {
		return nomJour;
	}
	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	public LocalDate getDateJour() {
		return dateJour.get();
	}

	public ObjectProperty<LocalDate> dateJourProperty() {
		return dateJour;
	}
}
