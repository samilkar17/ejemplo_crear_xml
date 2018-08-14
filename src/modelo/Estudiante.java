/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.FileWriter;
import java.util.LinkedList;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author juan_esteban.garcia
 */
public class Estudiante extends Persona{
    
    private String codigo;
    private String carrera;

   
    public Estudiante(String codigo, String carrera, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.codigo = codigo;
        this.carrera = carrera;
    }

    public Estudiante() {
        
    }

   
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Estudiante = {" + super.toString() + "codigo=" + codigo + ", carrera=" + carrera ;
    }

    public boolean crearArchivoXML(LinkedList<Estudiante> listaEstudiantes) {
        boolean g = false;
        try {
            Element universidad = new Element ("universidad"); // ctrl+ espacio y bucar jdom2
            Document  doc = new Document (universidad);
            
            for (int i = 0; i < listaEstudiantes.size(); i++) {
                Element Estudiante = new Element("Estudiante");
                Estudiante.addContent(new Element("nombre").setText(listaEstudiantes.get(i).getNombre()));
                Estudiante.addContent(new Element("telefono").setText(listaEstudiantes.get(i).getTelefono()));
                Estudiante.addContent(new Element("Correo").setText(listaEstudiantes.get(i).getCorreo()));
                Estudiante.addContent(new Element("Codigo").setText(listaEstudiantes.get(i).getCodigo()));
                Estudiante.addContent(new Element("Carrera").setText(listaEstudiantes.get(i).getCarrera()));
                
                doc.getRootElement().addContent(Estudiante);
            }
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc,new FileWriter("universidad.xml"));
            g = true;
         
        } catch (Exception e) {
               System.out.println(e.getMessage());
               g = false;
        }
        
        
        
        return g;
    }
  
    
    
}
