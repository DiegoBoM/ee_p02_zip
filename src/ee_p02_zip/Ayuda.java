/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee_p02_zip;

/**
 *
 * @author Victor Hugo Bolaños
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Ayuda extends JFrame
{   
    public Ayuda()
    {
        JFrame ay= new JFrame("AYUDA Â¿?");
        JTextField tx= new JTextField();
        tx.setText("");
        tx.setSize(380,380);
        ay.add(tx);
        ay.setSize(600,600);
        ay.setLocation(400,150);
        ay.setVisible(true);
    }
}
