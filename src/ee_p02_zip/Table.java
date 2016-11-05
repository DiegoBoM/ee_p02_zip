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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Table extends javax.swing.JFrame
{

    private String [] caracteres;
    private Integer[]frecuencias;
    String[] Names = {"Caracter","Frecuencia"};
    String [] codigos={"caracter","codigo de compresion"};
    Object carga[][];
    JFrame jf;
    JScrollPane jsp;

    public Table (String[]caracter, Integer [] frecuencias,String nombretabla){
        super(nombretabla);
        JFrame jf = new JFrame("Tabla De Frecuencias");
        jf.setLayout(null);
        JScrollPane jsp = new JScrollPane();
        this.caracteres=caracter;
        this.frecuencias=frecuencias;
        carga=new Object[caracteres.length][2];
        for(int i=0;i<caracter.length;i++){
            carga[i][0]=caracter[i];
            carga[i][1]= frecuencias[i]; 
        }
        DefaultTableModel dtm= new DefaultTableModel(carga,Names);
        JTable table = new JTable(dtm);
        table.setBounds(0,0,300, 775);
        table.setRowHeight(15);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.setFont(new java.awt.Font("Arial", 2, 11)); 
        jsp.setSize(400, 365);
        jsp.setViewportView( table );
        jf.add(jsp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.pack();
        jf.setSize(400,400);
        jf.getContentPane().setBackground(Color.gray); 
        jf.setLocation(400, 0);
        jf.setDefaultCloseOperation(1);
    }

    public Table (String[][]caracter){
        super("Arbol");
        JFrame jf = new JFrame("Arbol");
        jf.setLayout(null);
        JScrollPane jsp = new JScrollPane();
        carga=new Object[caracter.length][2];
        for(int i=0;i<caracter.length;i++){
            if(caracter[i][0].length()==1){
                carga[i][0]=caracter[i][0];
                carga[i][1]= caracter[i][1]; 
            }
        }
        DefaultTableModel dtm= new DefaultTableModel(carga,codigos);
        JTable table = new JTable(dtm);
        table.setBounds(0,0,300, 775);
        table.setRowHeight(15);
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(1).setPreferredWidth(5);
        table.setFont(new java.awt.Font("Arial", 2, 11)); 
        jsp.setSize(400, 365);
        jsp.setViewportView( table );
        jf.add(jsp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.pack();
        jf.setSize(400,400);
        jf.getContentPane().setBackground(Color.gray); 
        jf.setLocation(400, 0);
        jf.setDefaultCloseOperation(1);
    }

}
