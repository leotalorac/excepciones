/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciotaler;

import Excepciones.ExcepcionSalario;
import modelo.*;
import Excepciones.*;
import archivo.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Estudiante
 */
public class EjercicioTaler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Empresa apple = new Empresa();
        Consultor c = new Consultor("ing",1);
        apple.agregarTrabajador(c);
        Administrador a = null;
        try{ 
            a = new Administrador("Javier Antonio",2);
        }catch(ExepcionNombre e){
            e.printStackTrace();
        }catch(ExcepcionSalario e){
            e.printStackTrace();
        }
        apple.agregarTrabajador(a);
        
        Programador p = null;
        try{ 
            p = new Programador("GO","Luis Edaurdo",2000000,3);
        }catch(ExepcionNombre e){
            e.printStackTrace();
        }catch(ExepcionLenguaje e){
            e.printStackTrace();
        }catch(ExcepcionSalario e){
            e.printStackTrace();
        }
        apple.agregarTrabajador(p);
                
        LiderProyecto l = null;
        try{ 
            l = new LiderProyecto("GO","Cristian Mantilla",2000000,4);
        }catch(ExepcionNombre e){
            e.printStackTrace();
        }catch(ExepcionLenguaje e){
            e.printStackTrace();
        }catch(ExcepcionSalario e){
            e.printStackTrace();
        }
        l.agregarProgramador(p);
        
        apple.agregarTrabajador(l);
        
        ArchivoDB imp = new ArchivoDB();
        try{
            imp.guardarInformacion(apple);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        
        
    }
    
}
