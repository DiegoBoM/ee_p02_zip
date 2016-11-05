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
import java.util.*;
public class ColaPrioridad
{
    NodoF inicio;
    Integer contadordehojas=0;
    String [][] codigos;
    ArrayList<NodoF> arraycodigos= new ArrayList<NodoF>();
    public ColaPrioridad()
    {
        this.inicio=null;
    }

    public NodoF getinicio(){
        return inicio;
    }

    private boolean insertaralinicio(String caracter,Integer dato){
        Frecuencia f = new Frecuencia(caracter,dato); 
        NodoF nodo =new NodoF (f);    
        if (inicio == null){
            inicio=nodo;
            return true;
        }

        else
        if(inicio != null){
            nodo.setsiguiente(inicio);
            inicio=nodo;
            return true;
        }
        else 

            return false;
    }

    private boolean insertaralfinal(String cadena, Integer dato){
        if(inicio==null){
            insertaralinicio(cadena,dato);
            return true;
        }
        else 
        if (inicio != null){
            Frecuencia f = new Frecuencia(cadena,dato);
            NodoF nodo = new NodoF (f);
            NodoF aux=inicio;
            while(aux.getsiguiente()!=null){
                aux=aux.getsiguiente();
            }
            aux.setsiguiente(nodo);
            return true;
        }
        else 
            return false;
    }

    private boolean insertardespuesde(String cadena,Integer dato,Integer despuesde){
        if(buscar(despuesde)!= null){
            NodoF aux=buscar(despuesde);
            Frecuencia f=new Frecuencia(cadena,dato); 
            NodoF nodo= new NodoF(f);
            nodo.setsiguiente(aux.getsiguiente());
            aux.setsiguiente(nodo);
            return true;
        }
        else 
            return false;
    }

    private NodoF buscar(Integer caracter){
        NodoF aux=inicio;
        if(aux!=null){ 
            while(aux!=null){
                if(aux.getFrecuencia().getFrecuencia ()==caracter){
                    break;
                }
                else 
                    aux=aux.getsiguiente();
            }
            while(aux.getsiguiente().getFrecuencia().getFrecuencia()== aux.getFrecuencia().getFrecuencia()){
                aux=aux.getsiguiente();
            }
        }
        return aux;
    }

    public NodoF buscarString(String caracter){
        NodoF aux=inicio;
        while(aux!=null){
            if(aux.getFrecuencia().getCaracter().equals(caracter)){
                break;
            }
            else 
                aux=aux.getsiguiente();
        }
        return aux;
    }

    public boolean insertar(String cadena,Integer dato){
        NodoF aux=inicio;
        if(inicio==null){
            insertaralinicio(cadena,dato);    
            return true;
        }
        else
        if(inicio.getFrecuencia().getFrecuencia() > dato){
            insertaralinicio(cadena,dato);
            return true;
        }
        if(inicio.getFrecuencia().getFrecuencia() == dato){
            insertardespuesde(cadena,dato,inicio.getFrecuencia().getFrecuencia());
        }
        else
        if(inicio!=null){
            while(aux!=null){
                if(aux.getFrecuencia().getFrecuencia() <=dato && aux.getsiguiente()==null){
                    insertaralfinal(cadena,dato);
                    return true;
                }
                else
                if(aux.getFrecuencia().getFrecuencia() <= dato && aux.getsiguiente().getFrecuencia().getFrecuencia()> dato){
                    insertardespuesde(cadena,dato,aux.getFrecuencia().getFrecuencia());
                    return true;
                }
                else
                    aux=aux.getsiguiente();
            }
        }
        return false;
    }

    public NodoF eliminar(){
        NodoF aux=inicio;
        if(aux!=null){
            inicio=aux.getsiguiente();
            aux.setsiguiente(null);
        }
        return aux;
    }

    public void unificar(){
        NodoF aux=getinicio();
        while( aux!= null&&aux.getsiguiente() != null){
            Integer fR=inicio.getFrecuencia().getFrecuencia() + inicio.getsiguiente().getFrecuencia().getFrecuencia();
            String  n=inicio.getFrecuencia().getCaracter() + "" + inicio.getsiguiente().getFrecuencia().getCaracter();
            insertar(n,fR);
            NodoF ayudante = buscarString(n);
            ayudante.setIzq(inicio);
            ayudante.setDer((inicio.getsiguiente()));
            contadordehojas=contadordehojas + 2;
            eliminar();
            eliminar();
            aux=inicio;
        }
        Nodo no=new Nodo("valor","");
        inicio.setvalor(no);
        codificar(inicio);
        cargarcodigos();
    }

    void codificar(NodoF n){
        if(n!= null && n.getIzq()!=null){
            Nodo nod= new Nodo("valor",n.getValor().getCodigo()+"0"); 
            n.getIzq().setvalor(nod);
            arraycodigos.add(n.getIzq());
            codificar(n.getIzq());
        }
        if(n!= null &&n.getDer()!=null){
            Nodo na= new Nodo("valor",n.getValor().getCodigo()+"1"); 
            n.getDer().setvalor(na);
            arraycodigos.add(n.getDer());
            codificar(n.getDer());
        }
    }

    private void cargarcodigos(){
        codigos=new String [contadordehojas][2];
        for(int i=0;i<arraycodigos.size();i++){
            NodoF f=arraycodigos.get(i);
            codigos[i][0]="" + f.getFrecuencia().getCaracter();
            codigos[i][1]=f.getValor().getCodigo();  
        }
    }

    public String[][] getCodigos(){
        return codigos;
    }

    public Integer getHojas(){
        return contadordehojas;
    }

}
