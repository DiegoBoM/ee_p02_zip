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

public class Nodo
{
    String valor,codificacion;

    public Nodo(String valor,String codificacion)
    {
        this.valor=valor;
        this.codificacion=codificacion;
    }

    public String getCodigo(){
        return codificacion;
    }

    public void setCodigo(String c){
        this.codificacion=c;
    }

    public String getValor(){
        return valor;
    }
}

