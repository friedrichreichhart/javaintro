package data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person {
	private String vorname;
	private String nachname;
	//
	private static ArrayList<Person> personenListe = new ArrayList<>();
	//
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public static ArrayList<Person> getPersonenListe() {
		return personenListe;
	}
	public static void write2JSON() throws IOException {
		Writer writer = new FileWriter("C:\\temp\\output.json");
		Gson gson = new GsonBuilder().serializeNulls().create();
		gson.toJson(Person.getPersonenListe(), writer);
		writer.flush();
		writer.close();

	}
	

}
