/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public abstract class Empleado extends Trabajador{
     protected String nombre;
     protected double salario;

    public Empleado(String nombre, double salario, int id) throws ExepcionNombre, ExcepcionSalario {
        super(id);
        
        
        if (nombre.length() <10) 
            throw new ExepcionNombre();
        
        if(salario < 737000){
            throw new ExcepcionSalario();
        }
        this.nombre = nombre;
        this.salario = salario;
    }
   
}
