
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mariogarsia
 */
public class CheckBoxTemas extends JFrame {
    JCheckBox b1, b2, b3;
        JButton boton;
       String tema; 
       
    public CheckBoxTemas() {
        setTitle("Selecciona tema:");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        
        
        b1 = new JCheckBox ("Naturaleza");
        b1.setBounds(30, 20, 150, 25);
        
        b2 = new JCheckBox ("Oficios");
        b2.setBounds(30, 50, 150, 25);
        
        b3 = new JCheckBox ("Objetos");
        b3.setBounds(30, 80, 150, 25);
        
        boton = new JButton ("Aceptar");
        boton.setBounds(100, 120, 100, 30);
        
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                String mensaje = "Seleccionaste:\n";
                boolean nadaSeleccionado = true;
                
                if (b1.isSelected()) {
                    mensaje += "-Naturaleza\n";
                    nadaSeleccionado = false;
                    tema = "Naturaleza";
                }
                if (b2.isSelected()) {
                    mensaje += "-Oficios\n";
                    nadaSeleccionado = false;
                    tema = "Oficios";
                }
                
                if (b3.isSelected()) {
                    mensaje += "-Objetos\n";
                    nadaSeleccionado = false;
                    tema = "Objetos";
                }
                if (b1.isSelected() && b2.isSelected() && b3.isSelected() || b1.isSelected() && b2.isSelected() || b2.isSelected() && b3.isSelected() || b1.isSelected() && b3.isSelected()) {
                    mensaje = "Solo puedes seleccionad un tema";
                }
                JOptionPane.showMessageDialog(CheckBoxTemas.this, mensaje);
            }
        });
        
        add(b1);
        add(b2);
        add(b3);
        add(boton);
        
        
        
        
    }

}
