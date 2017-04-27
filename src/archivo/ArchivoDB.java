/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

//import com.sun.istack.internal.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
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
    
    public void imprimirInformacion(){
        File archivo = new File("empresa.txt");
        String tipo ="";
        try{
            Scanner lectura = new Scanner(archivo);
            lectura.useDelimiter(",");
            while(lectura.hasNext()){
                tipo = lectura.next();
                if (tipo.equals("C")) {
                    System.out.println("Consultor");
                    System.out.println("ID: " + lectura.nextInt());
                    System.out.println("Labor: " + lectura.next());
                }else if(tipo.equals("A")){
                    System.out.println("Administrador");
                    System.out.println("ID: " +lectura.nextInt());
                    System.out.println("Nombre: " +lectura.next());
                    System.out.println("Salario: " +lectura.next());
                }
                else if(tipo.equals("P")){
                    System.out.println("Programador");
                    System.out.println("ID: " +lectura.nextInt());
                    System.out.println("Nombre: " +lectura.next());
                    System.out.println("Salario: " +lectura.next());
                    System.out.println("Lenguaje: " +lectura.next());
                }
                else if(tipo.equals("L")){
                    System.out.println("Lider de proyecto");
                    System.out.println("ID: " +lectura.nextInt());
                    System.out.println("Nombre: " +lectura.next());
                    System.out.println("Salario: " +lectura.next());
                    System.out.println("Lenguaje: " +lectura.next());
                    int w = lectura.nextInt();
                    System.out.println(w);
                    for (int i = 0; i < w; i++) {
                        System.out.println("ID" +w +":"+ lectura.nextInt());
                    }
                    
                }
                    
                    
                //temporal
                //System.out.println(lectura.next());
            }
            lectura.close();
        }catch(FileNotFoundException ex){
            //Logger.getLogger(ArchivoDB.class.getName()).log(Levi);
            ex.printStackTrace();
            
        }
    }
}
