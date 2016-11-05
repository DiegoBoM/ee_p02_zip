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
public class Pantallacomprimir extends JFrame implements ActionListener

{
    JTextPane txp;
    JScrollPane jsp;
    JFrame jf;
    String contenido="";
    JButton caracteres, comprimir,ayuda;
    String ruta,aux,rguarda;
    Comprimir c;
    public Pantallacomprimir(String ruta,String rguardar){
        c=new Comprimir();
        this.ruta=ruta;
        this.rguarda=rguardar;

        jf= new JFrame("visualizacionn de archivo"); 

        caracteres= new JButton("Caracteres");
        comprimir=new JButton("Comprimir");  
        ayuda= new JButton("Ayuda");
        
        jf.setLayout(null);

        txp = new JTextPane();

        JScrollPane jsp = new JScrollPane();

        jsp.setSize(430, 300);
        jsp.setViewportView( txp );

        getArchivo();

        caracteres.setBounds(0,310, 130, 50);
        comprimir.setBounds(130,310, 110, 50);
      
        ayuda.setBounds(250,310,75,50);

        caracteres.addActionListener(this);
        comprimir.addActionListener(this);
        ayuda.addActionListener(this);
        
        jf.setSize(450,400);

        jf.add(jsp);
        jf.add(caracteres);
        jf.add(comprimir);
        jf.add(ayuda);


        jf.setLocation(400,150);
        jf.setVisible(true);
    }

    private void getArchivo(  ){
        File n= new File(ruta);
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
        if(e.getSource()== caracteres)
        {
            c.contarcaracteres(ruta);
            c.TabladeFrecuencias();

        }
        else
        if(e.getSource()== comprimir){
            c.comprimir(ruta,rguarda); 
            c.tablaArbol();
        }
        else
        if(e.getSource()== ayuda){
            Ayuda a=new Ayuda();


        }
        
    }
}

