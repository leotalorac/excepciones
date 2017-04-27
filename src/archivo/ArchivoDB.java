/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import modelo.*;

/**
 *
 * @author Estudiante
 */
public class ArchivoDB {
    
    public void guardarInformacion(Empresa e) throws FileNotFoundException{
        File archivo = new File("empresa.txt");
        PrintStream salida = new PrintStream(archivo);
            for (Trabajador t: e.getTrabajadores()) {
                if (t instanceof Consultor) {
                    Consultor c = (Consultor)t;
                    salida.print("C," + c.getId() + "," + c.getLabor() + ",");
                }
                else if (t instanceof LiderProyecto) {
                    LiderProyecto l = (LiderProyecto)t;
                    salida.print("L," + l.getId() + "," + l.getNombre() +","+ l.getSalario()+","+l.getLenguaje()+ ",");
                    salida.print(l.getProgramadores().size()+",");
                    for (Programador pr: l.getProgramadores() ) {
                        salida.print(pr.getId()+",");
                    }
                }
                else if (t instanceof Programador) {
                    Programador p = (Programador)t;
                    salida.print("P," + p.getId() + "," + p.getNombre() +","+ p.getSalario()+","+p.getLenguaje()+ ",");
                }
                else if(t instanceof Administrador){
                    Administrador a = (Administrador)t;
                    salida.print("A," + a.getId() + "," + a.getNombre() +","+ a.getSalario()+ ",");
                }
            }    
        salida.close();
        
        
    }
}
