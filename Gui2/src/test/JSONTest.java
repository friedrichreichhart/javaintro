package test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import data.Person;

public class JSONTest {

	public static void main(String[] args) {
		try {
			//
			Writer writer = new FileWriter("C:\\temp\\output.json");
			Gson gson = new GsonBuilder().serializeNulls().create();
//			gson.toJson("Hallo", writer);
//			gson.toJson(12345, writer);
			//
			ArrayList<Person> personen = new ArrayList<>();
			//
			Person p = new Person();
			p.setVorname("Franz");
			//p.setPlz(1220);
			//
			personen.add(p);
			personen.add(p);
			personen.add(p);
			//
			for (Person p3 : personen)
				System.out.println(p3);
			//
			System.out.println("---------");
			//
			gson.toJson(personen, writer);
			//
			writer.flush();
			writer.close();
			//
			Reader r = new FileReader("C:\\temp\\output.json");
			//
			ArrayList<Person> personenRead = new ArrayList<>();
			//
			Type listType = new TypeToken <ArrayList<Person>>(){}.getType();
			personenRead = gson.fromJson(r, listType);
			//
			for (Person p2 : personenRead)
				System.out.println(p2);
			//
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
