/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Excepciones;

/**
 *
 * @author Estudiante
 */
public class ExepcionNombre extends Exception{
    public ExepcionNombre(){
        super("el nombre es muy largo");
    }
}
