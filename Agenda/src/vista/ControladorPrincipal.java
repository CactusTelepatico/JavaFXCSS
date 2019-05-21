package vista;

import controlador.Main;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Persona;

public class ControladorPrincipal extends Main {

	@FXML
	private TableView<Persona> tblViewPersonas;

	@FXML
	private TableColumn<Persona, String> nombres;

	@FXML
	private TableColumn<Persona, String> apellidos;

	@FXML
	private TableColumn<Persona, String> edades;

	@FXML
	private Button btnNuevo;

	@FXML
	private Button btnEditar;

	@FXML
	private Button btnBorrar;

	@FXML
	private TextField txtNombre;

	@FXML
	private TextField txtApellido;

	@FXML
	private TextField txtEdad;

	@FXML
	private Button btnOk;

	@FXML
	public void initialize() {

		// enlazar columnas con fxId
		nombres.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
		apellidos.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellido"));
		edades.setCellValueFactory(new PropertyValueFactory<Persona, String>("edad"));
		setPerson();
		
	}

	public void setPerson() {

		try {
			// enlazar listas con tableview
			tblViewPersonas.setItems(data.getPersonData());
		} catch (Exception e) {
		}

	}

	public void newPerson(ActionEvent event) {
		if (!(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtEdad.getText().equals(""))) {
			
				data.addPersona(new Persona(txtNombre.getText(), txtApellido.getText(), txtEdad.getText()));
				txtNombre.setText("");
				txtApellido.setText("");
				txtEdad.setText("");
			
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in text fields");
			alert.setContentText("You have to fill the text field");
			alert.show();
		}
	}

	public void deletePerson() {
		if (!tblViewPersonas.getSelectionModel().isEmpty()) {
			data.deletePerson(tblViewPersonas.getSelectionModel().getSelectedIndex());
			tblViewPersonas.getSelectionModel().clearSelection();
			setPerson();
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in table");
			alert.setContentText("You have to select a person, if the table is empty please enter a new person");
			alert.show();
		}
	}
	public void guardar(ActionEvent event) {
		if (!(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtEdad.getText().equals(""))) {
			if (editPerson) {
				data.getPersonData().set(editPosition,
						new Persona(txtNombre.getText(), txtApellido.getText(), txtEdad.getText()));
				editPerson = false;
				editPosition = -1;
			} else
				data.addPersona(new Persona(txtNombre.getText(), txtApellido.getText(), txtEdad.getText()));
			vistaPrincipal(event);
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("No content in text fields");
			alert.setContentText("You have to fill the text field");
			alert.show();
		}

	}

	

	public String getTxtNombre() {
		return txtNombre.getText();
	}

	public void setTxtNombre(String txtNombre) {
		this.txtNombre.setText(txtNombre);
	}

	public String getTxtApellido() {
		return txtApellido.getText();
	}

	public void setTxtApellido(String txtApellido) {
		this.txtApellido.setText(getTxtApellido());
	}

	public String getTxtEdad() {
		return txtEdad.getText();
	}

	public void setTxtEdad(String txtTelefono) {
		this.txtEdad.setText(txtTelefono);
	}

}
