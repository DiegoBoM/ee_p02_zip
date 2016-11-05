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
public class Comprimir
{
    private String caracteres[]={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","Ã‘","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","Ã±","o","p","q","r","s","t","u","v","w","x","y","z",
            "1","2","3","4","5","6","7","8","9","0",".",","," ","?","Â¿","!","Â¡","{","}"};
    private Integer frecuencias[]= new Integer [caracteres.length];   
    private String [][]c;
    ColaPrioridad colap= new ColaPrioridad();
    String direccion;    
    public void contarcaracteres(String cadena){
        try{
            for(int i=0;i<caracteres.length;i++){
                FileReader fr=new FileReader(cadena);
                BufferedReader bf = new BufferedReader(fr);
                String primera = bf.readLine();
                Integer conta=0;
                String aux=caracteres[i];
                while(primera!= null ){
                    for(int j=0;j<primera.length();j++){
                        String l=""+  primera.charAt(j);
                        if(aux.equals(l)){
                            conta ++;
                        }
                    }
                    primera=bf.readLine();
                }
                frecuencias[i]=conta;
                conta=0;
            }
        }

        catch (IOException e){
            System.out.println("io");
        }

    }

    public void TabladeFrecuencias(){                
        Table tabla=new Table(caracteres,frecuencias,"tabla de frecuencias");
    }

    public void tablaArbol(){
        Table tabla= new Table(c);
    }

    private void cargarCola(){
        for (int i=0;i<caracteres.length;i++){
            if(frecuencias[i]>0){
                colap.insertar(caracteres[i],frecuencias[i]);
            }
        }
    }

    public void comprimir(String ruta,String rguardar){
        unir(ruta);
        escribirarchivo(ruta,rguardar);

    } 

    public void totalcaracteres(){
        int conta=0;
        for (int i=0;i<66;i++){
            conta=conta + frecuencias[i];
        }
        System.out.println(conta);
    }

    private void unir(String ruta){
        contarcaracteres(ruta);
        cargarCola();
        colap.unificar();
        c=colap.getCodigos();
     }

    public void imprimircodigos(){
        for (int i =0; i<colap.getHojas();i++){
            if (c[i][0].length()<=1){
                System.out.println(c[i][0] + "..." + c[i][1]);
            }
        }
    }

    public void escribirarchivo(String ruta,String rguardar){
        File n= new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        String valorizacion="Â¿";
        for(int i=0;i<c.length;i++)
        {
            valorizacion+= c[i][0] + "$" + c[i][1] +"#"; 
        }
        valorizacion +="?"; 
        String rutanueva=rguardar;
        String contenido = "";
        try
        {
            fr = new FileReader( n);
            br = new BufferedReader( fr );
            convertirarchivo(rutanueva,valorizacion);
            String linea="";
            while( ( linea = br.readLine() ) != null ){ 
                contenido = linea ;
                String con= convertir(contenido);
                convertirarchivo(rutanueva,con);
                contenido="";
            }
        }
        catch( Exception e ){  }

        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }

    }

    private void convertirarchivo(String ruta, String texto){
        File file = new File(ruta); 
        if(file.exists()){
            try{
                file.createNewFile();
                FileWriter fw =new FileWriter(file,true);
                fw.append("\n" + texto);
                fw.close();
            }
            catch (IOException ex){
            }
        }
        else
            try{
                file.createNewFile();
                FileWriter fw =new FileWriter(file,true);
                fw.append("\n" + texto);
                fw.close();
            }
            catch(IOException ex){
            }
    }

    private String convertir(String cadena){
        String convertido="";
        for (int i=0;i< cadena.length();i++){
            String aux="" + cadena.charAt(i);
            for(int j=0;j<c.length;j++){
                if(aux.equals(c[j][0])){
                    convertido += c[j][1] + "/";
                }
            }
        }
        return convertido;
    }

}

