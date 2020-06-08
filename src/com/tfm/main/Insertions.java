package com.tfm.main;

import java.sql.Statement;



import java.sql.Connection;
import java.sql.DriverManager;

public class Insertions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Connection conexion;
			Statement stmt;
			try {
				// 1 cargar el driver de la bbdd
				System.out.println("1");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("2");
				// 2 conexion con la bbdd
				conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tfm?user=root&password=Hontanares10&allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
				System.out.println("3");
				
				
				
				for (int i=1;i<=10;i++) {
					String sql = "INSERT INTO almacenes(id_almacen,nombre,ubicacion) VALUES ("+i+",'PRODUCTO_"+i+"','UBICACION_"+i+"');";
					stmt=conexion.createStatement();
					stmt.executeUpdate(sql);
					System.out.println("Almacén insertado");
				}
				
				for (int i=1;i<=100;i++) {
					int l=(int)(Math.random()*99+1);
					int s=(int)(Math.random()*9+1);
					int id_a=(int)(Math.random()*9+1);
					String sql = "INSERT INTO productos(id_producto,nombre,precio) VALUES ("+i+",'PRODUCTO_"+i+"',"+l+");";
					String sql2 = "INSERT INTO products_almacen (id_producto,id_almacen,stock,id) VALUES ("+i+","+id_a+","+s+","+i+");";
					stmt=conexion.createStatement();
					stmt.executeUpdate(sql);
					stmt.executeUpdate(sql2);
					System.out.println("Producto insertado");
				}
				
				for (int i=1;i<=1000;i++) {
					
					int anio=2014+(int)(Math.random()*6+1);
					int mes=(int)(Math.random()*11+1);
					int dia;
					if(mes!=2) {
						dia=(int)(Math.random()*29+1);
					} else {
						dia=(int)(Math.random()*28+1);
					}
					
				
					int l=(int)(Math.random()*99+1);
					int s=(int)(Math.random()*9+1);
					int id_a=(int)(Math.random()*9+1);
					System.out.print(anio+"-"+mes+"-"+dia);
					String sql2 = "INSERT INTO ventas(id_venta,id_producto,id_almacen,fecha_venta) VALUES ("+i+","+l+","+id_a+",'"+anio+"-"+mes+"-"+dia+"');";
					stmt=conexion.createStatement();
					stmt.executeUpdate(sql2);
					System.out.println("Producto insertado");
				}
				
				
				
				
				
				
				conexion.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
			   System.out.println(e);
			}

		
	}

}
