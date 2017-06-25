/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;
import funciones.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author buba
 */
public class f_empleado {
    conectar cc = new conectar();
    Connection cn= cc.conexion();
    
     public void registrar_empleado(String nombre, String apellido, String rut, String telefono,String correo,String usuario,String contrasenia,String cargo){
           
          
           this.registrar_usuario(usuario, contrasenia,cargo);
           this.registrar_empleado(nombre, apellido, rut, correo, telefono);
            
        
       
        }
     
    public void registrar_cargo(String nombre){
          String sql_1="call ingresar_tipo_cargo(?)";
          
          try{
              CallableStatement ps= cn.prepareCall(sql_1);
                ps.setString(1,nombre);
                ps.executeQuery();
              
          }
          catch(SQLException e){
               System.out.println(sql_1);
          }
          
     }
     
     public void registrar_usuario(String usu , String pass , String cargo){
         String sql_2="call ingresar_usuario(?,?,?)";
         
         try{
             CallableStatement p= cn.prepareCall(sql_2);
             p.setString(1, usu);
             p.setString(2, pass);
             p.setString(3, cargo);
             p.executeQuery();
             
         }
         catch(SQLException e){
                System.out.println(sql_2);
          }
     }
     
    public void registrar_empleado(String nombre , String apellido , String rut, String correo, String telefono)
     {
          String sql_0=" call ingresar_empleado(?,?,?,?,?)";
           
        try{
             CallableStatement pst=cn.prepareCall(sql_0);
             
             
             
           
             
             pst.setString(1, nombre);
             pst.setString(2, apellido);
             pst.setString(3, rut);
             pst.setString(4, telefono);
             pst.setString(5, correo);
          
             pst.executeQuery();
             
     
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println(sql_0);
            
           
            
          
            
        }
     }
}
     

        
        
    
   

    




