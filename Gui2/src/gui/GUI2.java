package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import data.Person;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;

public class GUI2 {

	protected Shell shell;
	private Text nachname;
	private Text vorname;
	private List guiListe;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI2 window = new GUI2();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 395);
		shell.setText("SWT Application");
		
		nachname = new Text(shell, SWT.BORDER);
		nachname.setBounds(32, 27, 76, 21);
		
		vorname = new Text(shell, SWT.BORDER);
		vorname.setBounds(32, 66, 76, 21);
		
		Label lblNachname = new Label(shell, SWT.NONE);
		lblNachname.setBounds(135, 33, 55, 15);
		lblNachname.setText("Nachname");
		
		Label lblVorname = new Label(shell, SWT.NONE);
		lblVorname.setBounds(135, 66, 55, 15);
		lblVorname.setText("Vorname");
		
		Button btnFgeListeHinzu = new Button(shell, SWT.NONE);
		btnFgeListeHinzu.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//
				Person p = new Person();
				p.setNachname(getNachname().getText());
				p.setVorname(getVorname().getText());
				//
				Person.getPersonenListe().add(p);
				getGuiListe().add(p.toString());
			}
		});
		btnFgeListeHinzu.setBounds(43, 127, 147, 25);
		btnFgeListeHinzu.setText("f\u00FCge liste hinzu");
		
		Button btnWriteJson = new Button(shell, SWT.NONE);
		btnWriteJson.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Person.write2JSON();
					//
					MessageBox mb = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
					mb.setText("JSON geschrieben");
					mb.setMessage(Person.getPersonenListe().size() + " Einträge erfolgreich geschrieben");
					mb.open();
				} catch (IOException e1) {
					MessageBox mb = new MessageBox(shell, SWT.ICON_ERROR | SWT.OK);
					mb.setText("Fehler bei JSON");
					mb.setMessage(e1.getMessage());
					mb.open();

				}
			}
		});
		btnWriteJson.setBounds(54, 171, 75, 25);
		btnWriteJson.setText("write 2 json");
		
		guiListe = new List(shell, SWT.BORDER);
		guiListe.setBounds(43, 221, 261, 125);

	}
	public Text getNachname() {
		return nachname;
	}
	public Text getVorname() {
		return vorname;
	}
	public List getGuiListe() {
		return guiListe;
	}
}
