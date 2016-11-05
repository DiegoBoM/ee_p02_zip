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
public class NodoF
{
    Frecuencia frecuencia;
    NodoF izq,der,siguiente;
    Nodo valor;
    public NodoF(Frecuencia frecuencia)
    {
        this.frecuencia=frecuencia;
        izq=null;
        der=null;
        siguiente=null;
        valor=null;
    }

    public void setsiguiente(NodoF  siguiente){
        this.siguiente=siguiente;
    }

    public void setvalor(Nodo nodo){
        this.valor=nodo;
    }

    public Nodo getValor(){
        return valor;
    }

    public NodoF getsiguiente(){
        return siguiente;
    }

    public Frecuencia getFrecuencia(){
        return frecuencia;
    }

    public void setFrecuencia(Frecuencia frecuencia){
        this.frecuencia=frecuencia;
    }

    public NodoF getIzq(){
        return izq;
    }

    public void setIzq(NodoF izq){
        this.izq=izq;
    }

    public NodoF getDer(){
        return der;
    }

    public void setDer(NodoF der){
        this.der=der;
    }

}
