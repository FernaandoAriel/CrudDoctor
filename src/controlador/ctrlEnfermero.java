
package controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.tbEnfermero;
import vista.frmEnfermeros;


public class ctrlEnfermero implements MouseListener, KeyListener{
    
    //1- Mandar a llamar a las otras capas (modelo y vista)
    private tbEnfermero modelo;
    private frmEnfermeros vista;
    
    //2- Crear el constructor
    public ctrlEnfermero(tbEnfermero modelo, frmEnfermeros vista){
        this.modelo = modelo;
        this.vista = vista;

        vista.btnAgregarEn.addMouseListener(this);   
        modelo.Mostrar(vista.jtbEnfermeros);
        vista.btnEliminarEn.addMouseListener(this);
        vista.jtbEnfermeros.addMouseListener(this);
        vista.btnActualizarEn.addMouseListener(this);
        vista.btnLimpiarEn.addMouseListener(this);
        vista.txtBuscarEn.addKeyListener(this);
    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == vista.btnAgregarEn){
            modelo.setNombre_Enfermero(vista.txtNombreEnfermero.getText());
            modelo.setEdad_Enfermero(Integer.parseInt(vista.txtEdadEnfermero.getText()));
            modelo.setPeso_Enfermero(Integer.parseInt(vista.txtPesoEnfermero.getText()));
            modelo.setCorreo_Enfermero(vista.txtCorreoEnfermero.getText());
            
            modelo.Guardar();
            modelo.Mostrar(vista.jtbEnfermeros);
        }
        
        if(e.getSource() == vista.btnEliminarEn){
            modelo.Eliminar(vista.jtbEnfermeros);
            modelo.Mostrar(vista.jtbEnfermeros);
        }
        
        if(e.getSource() == vista.jtbEnfermeros){
            modelo.cargarDatosTabla(vista);
        }
        
        if(e.getSource() == vista.btnActualizarEn){
            modelo.setNombre_Enfermero(vista.txtNombreEnfermero.getText());
            modelo.setEdad_Enfermero(Integer.parseInt(vista.txtEdadEnfermero.getText()));
            modelo.setPeso_Enfermero(Integer.parseInt(vista.txtPesoEnfermero.getText()));
            modelo.setCorreo_Enfermero(vista.txtCorreoEnfermero.getText());

            
            modelo.Actualizar(vista.jtbEnfermeros);
            modelo.Mostrar(vista.jtbEnfermeros);
        }
        
        if(e.getSource() == vista.btnLimpiarEn){
            modelo.Limpiar(vista);
        }
        
        String mensajeError = "";

        if (vista.txtNombreEnfermero.getText().isEmpty()) {
            mensajeError += "El campo 'Nombre_Enfermero' está vacío.\n";
        }
        if (vista.txtEdadEnfermero.getText().isEmpty()) {
            mensajeError += "El campo 'Edad_Enfermero' está vacío.\n";
        }
        if (vista.txtPesoEnfermero.getText().isEmpty()) {
            mensajeError += "El campo 'Peso_Enfermero' está vacío.\n";
        }
        if (vista.txtCorreoEnfermero.getText().isEmpty()) {
            mensajeError += "El campo 'Correo_Enfermero' está vacío.\n";
        }

        if (!mensajeError.isEmpty()) {
            JOptionPane.showMessageDialog(vista, mensajeError, "Alerta", JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
        if(e.getSource() == vista.txtBuscarEn){
            modelo.Buscar(vista.jtbEnfermeros, vista.txtBuscarEn);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
   
}
