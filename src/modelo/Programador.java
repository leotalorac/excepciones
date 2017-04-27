/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Excepciones.ExcepcionSalario;
import Excepciones.ExepcionLenguaje;
import Excepciones.ExepcionNombre;

/**
 *
 * @author Estudiante
 */
public class Programador extends Empleado{
    protected String lenguaje;

    public Programador(String lenguaje, String nombre, double salario, int id) throws ExepcionNombre, ExepcionLenguaje, ExcepcionSalario {
        super(nombre, salario, id);
        if(!"GO".equals(lenguaje))
            throw new ExepcionLenguaje();
        
        this.lenguaje = lenguaje;
    }
    
    @Override
    public double calcularSalario() {
       double salarioTotal = this.salario;
       if(this.lenguaje.equals("java"))
           salarioTotal+=(this.salario*0.2);
       return salarioTotal;
    }

    @Override
    public String listarInformacion() {       
     return "Programador " + this.id + " " + this.nombre;   
    }

    public String getLenguaje() {
        return lenguaje;
    }
    
    
}
