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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.Image; 
import javax.swing.Icon; 
import javax.swing.ImageIcon; 
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class AbrirparaComprimir extends JFrame implements ActionListener
{
    private JButton boton; 
    JFrame jf;
    String path,nombre;
    public AbrirparaComprimir(){
        jf= new JFrame();
        jf.setLayout(null);
        boton = new JButton("Explorador archivos");
        boton.setBounds(0,0,280,70);
        boton.setBackground(java.awt.Color.gray);
        jf.add(boton);
        jf.setDefaultCloseOperation(1);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.pack();
        jf.setSize(290, 105);
        jf.getContentPane().setBackground(Color.white); 
        jf.setLocation(400, 100);
        boton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        JFileChooser elegir = new JFileChooser();
        elegir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        int opcion = elegir.showOpenDialog(boton);
        if(opcion == JFileChooser.APPROVE_OPTION){
            path = elegir.getSelectedFile().getPath(); 
            nombre = elegir.getSelectedFile().getName(); 
            int u=0;         
            String l=path;
            String direc="";
            String w="";
            direc=l.substring(0,(path.length()-4));
            w=direc +"" + "textzip.ito";
            Pantallacomprimir pc= new Pantallacomprimir(path,w);
        }
    }
}


