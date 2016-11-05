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

public class Descomprimir
{
    public String [][] tablaletra;
    String valores;
    String letrasc="";
    String adeco="";
    ArrayList <String>p= new ArrayList<String>();
    ArrayList <String> sepa= new ArrayList<String>();

    private void generarletras(String ruta){
        try{
            FileReader fr=new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            String primera = bf.readLine();
            String auxiliar="";
            while(primera!= null ){
                auxiliar+=primera;

                primera=bf.readLine();
            }
            String letrasc="";
            int xy=0;
            while(xy<auxiliar.length() &&auxiliar.charAt(xy)!='?'){
                this.letrasc+=""+auxiliar.charAt(xy); 
                xy++; 
            }
            adeco=auxiliar.substring(xy+1,auxiliar.length());
        }
        catch (IOException e){
            System.out.println("io");
        }
        String cs="";
        for(int i=1;i<letrasc.length();i++){
            if(letrasc.charAt(i)!='#'){
                cs+=""+ letrasc.charAt(i); 
            }
            else {
                if(letrasc.charAt(i)=='#'){
                    p.add(cs);
                    cs="";
                }
            }
        }

    }

    private void tabla(){
        tablaletra= new String[p.size()][2];
        String ayu="";
        String letra="";
        String valor="";
        for (int i=0;i<p.size();i++){
            ayu=p.get(i);
            if(ayu!=null){
                for (int x=0;x<ayu.length();x++){
                    if(ayu.charAt(x)!= '$' ){

                    }
                    else
                    if(ayu.charAt(x)=='$'){
                        letra=ayu.substring(0,(x));   
                        valor=ayu.substring((x+1),(ayu.length())); 
                    }
                }
            }
            tablaletra[i][0]=letra;
            tablaletra[i][1]=valor;
            letra="";
            valor="";
        }
    }

    public void tablaa(String ruta,String rutaaguardar){
        generarletras(ruta);
        tabla();
        descomprimir(rutaaguardar);
    }

    public void tabladescompresion(){
        Table t= new Table(tablaletra);
    }

    private void descomprimir(String rutaaguardar){
        String guardar="";
        for (int i=0;i<adeco.length();i++){
            if(adeco.charAt(i)!='/'){
                guardar+=""+ adeco.charAt(i); 
            }
            else {
                if(adeco.charAt(i)=='/'){
                    sepa.add(guardar);
                    guardar="";
                }
            }
        }
        int y=0;
        String texto="";
        String codigo="";
        String dec="";
        for (int i=0;i<sepa.size();i++){
            codigo=sepa.get(i);
            for (int k=0;k<tablaletra.length;k++){
                dec=tablaletra[k][1];
                if(codigo.equals(dec)){
                    texto+= tablaletra[k][0];
                    break;
                }
            }

        }
        escribirarchivo(rutaaguardar,texto);
    }

    private void escribirarchivo(String ruta,String texto){
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
}

