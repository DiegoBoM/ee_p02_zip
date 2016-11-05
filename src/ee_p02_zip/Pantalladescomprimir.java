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
import java.io.*;
import java.util.*;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;
public class Pantalladescomprimir extends JFrame implements ActionListener
{
    JTextPane txp;
    JScrollPane jsp;
    JFrame jf;
    String contenido="";
    JButton descomprimir,ayuda;
    String ruta,aux,rguarda;
    Descomprimir d; 
    public Pantalladescomprimir(String ruta,String rguardar){
        d= new Descomprimir();
        this.ruta=ruta;
        this.rguarda=rguardar;
        jf= new JFrame("visualizacionn de archivo"); 
        
        descomprimir=new JButton("Descomprimir");  
        ayuda= new JButton("Ayuda");
        jf.setLayout(null);
        txp = new JTextPane();
        JScrollPane jsp = new JScrollPane();
        jsp.setSize(430, 300);
        jsp.setViewportView( txp );
       
        descomprimir.setBounds(90,310, 150, 50);
        ayuda.setBounds(250,310,75,50);
       
        descomprimir.addActionListener(this);
        ayuda.addActionListener(this);
        jf.setSize(450,400);
        jf.add(jsp);
       
        jf.add(descomprimir);
        jf.add(ayuda);
        jf.setLocation(400,150);
        jf.setVisible(true);
    }

    private void getArchivo( ){
        File n= new File(rguarda);
        FileReader fr = null;
        BufferedReader br = null;
        String contenido = "";
        try
        {
            fr = new FileReader( n);
            br = new BufferedReader( fr );
            String linea="";
            while( ( linea = br.readLine() ) != null ){ 
                contenido += linea + "\n";
            }
            txp.setText( contenido );
        }catch( Exception e ){  }
        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }
    } 

    public void actionPerformed( ActionEvent e ){
       
        if(e.getSource()== descomprimir){
            d.tablaa(ruta,rguarda);
            d.tabladescompresion();
            getArchivo();
        }
        else
        if(e.getSource()== ayuda){
            Ayuda ay= new Ayuda();
        }
    }
}

