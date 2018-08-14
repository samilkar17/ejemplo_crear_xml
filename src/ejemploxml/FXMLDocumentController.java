/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploxml;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Estudiante;

/**
 *
 * @author sebastian.murillo
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private TextField txtCarrera;

    @FXML
    private Label codigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private Label correo;

    @FXML
    private TextField txtTelefono;

    @FXML
    private TextField txtCodigo;

    @FXML
    private Label telefono;

    @FXML
    private Label carrera;

    @FXML
    private Label nombre;

    @FXML
    private TextField txtCorreo;
    
     LinkedList<Estudiante> listaEstudiantes;
     
      @FXML
    void agregar(ActionEvent event) {
    String nombre = txtNombre.getText();
    String telefono = txtTelefono.getText();
    String correo = txtCorreo.getText();
    String codigo = txtCodigo.getText();
    String carrera = txtCarrera.getText();
    
      Estudiante objE = new Estudiante(codigo, carrera, nombre, telefono, correo);
        listaEstudiantes.add(objE);
        
    txtNombre.setText(null);
    txtTelefono.setText(null);
    txtCorreo.setText(null);
    txtCodigo.setText(null);
    txtCarrera.setText(null);
    
    }

    @FXML
    void Guardar(ActionEvent event) {
//crear un arhivo XML
//descargar libreria que nos permite crear este tipo de archivos, y en la clase estudiantes lo creamos
//JDOM. extraerlo dar click en tools librerias primero añadir el primero,junit y contrib. en la otra pestaña ´poner el sources y asi sucesivamente.
//dar click en librerias al lado izquierdo de nuestro proyecto y añadimos las librerias.

 Estudiante objV = new Estudiante();
boolean Guardar = objV.crearArchivoXML(listaEstudiantes);

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listaEstudiantes = new LinkedList<>();
    }    
    
}
