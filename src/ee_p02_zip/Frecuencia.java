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
public class Frecuencia{
    private String caracter;
    private Integer frecuencia;
    public Frecuencia(String caracter,Integer frecuencia){
        this.caracter=caracter;
        this.frecuencia=frecuencia;
    }

    public Integer getFrecuencia(){
        return frecuencia;
    }

    public String getCaracter(){
        return caracter;
    }

    public void setFrecuencia(Integer f){
        this.frecuencia=f;
    }

    public void setCaracter(String c){
        this.caracter=caracter;
    }
}
