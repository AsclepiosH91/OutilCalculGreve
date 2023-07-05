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
	private final StringProperty transportJour;
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
	 * @param transportJour
	 */
	public Jour(String nomJour, String transportJour) {
		this.nomJour = new SimpleStringProperty(nomJour);
		this.transportJour = new SimpleStringProperty(transportJour);


		// Some initial dummy data, just for convenient testing.
		this.dateJour = new SimpleObjectProperty<LocalDate>(LocalDate.of(2013, 1, 1));
	}


	public void setTransportJour(String transportJour) {
		this.transportJour.set(transportJour);
	}

	public void setNomJour(String nomJour) {
		this.nomJour.set(nomJour);
	}

	public void setDateJour(LocalDate dateJour) {
		this.dateJour.set(dateJour);
	}


	public String getTransportJour() {
		return transportJour.get();
	}

	public StringProperty transportJourProperty() {
		return transportJour;
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
