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
public class Menu extends JFrame implements ActionListener
{
    JButton comprimir,descomprimir,ayuda;
    JFrame jf;
    public Menu(){        
        JFrame jf = new JFrame("COMPRESOR DE ARCHIVOS");
        jf.setLayout(null);
        comprimir= new JButton("COMPRIMIR");
        descomprimir= new JButton("DESCOMPRIMIR");
        ayuda= new JButton("AYUDA");
        comprimir.setBounds(0,0, 140, 70);
        descomprimir.setBounds(140,0, 180, 70);
        ayuda.setBounds(320,0,100 ,70 );
        comprimir.setBackground(java.awt.Color.white);
        descomprimir.setBackground(java.awt.Color.white);
        ayuda.setBackground(java.awt.Color.white);  
        jf.add(comprimir);
        jf.add(descomprimir);
        jf.add(ayuda);       
        comprimir.addActionListener(this);
        descomprimir.addActionListener(this);
        ayuda.addActionListener(this);        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.pack();
        jf.setSize(490, 140);
        jf.getContentPane().setBackground(Color.gray); 
        jf.setLocation(400, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== ayuda){
            Ayuda ayuda= new Ayuda();
        }
        else
        if(e.getSource()==comprimir){
            AbrirparaComprimir ac= new AbrirparaComprimir();
        }
        else
        if(e.getSource()==descomprimir){
            AbrirparaDescomprimir ad= new AbrirparaDescomprimir();
        }                 
     }
}

