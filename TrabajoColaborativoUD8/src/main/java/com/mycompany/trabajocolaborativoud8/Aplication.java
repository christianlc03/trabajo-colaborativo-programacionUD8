package com.mycompany.trabajocolaborativoud8;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Aplication {
    public static void main(String[] args) {
        ProductsDataAccessObject pda = new ProductsDataAccessObject();
        
        try{
            List<Products> lista = pda.selectAll();
        
            System.out.println("--NIVEL BAJO--");
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los nombres de los productos cuyo coste es mayor a 600");
            System.out.println("-----------------------------");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los nombres sin repetir de los productos cuyo coste es mayor a 600");
            System.out.println("-----------------------------");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .distinct()
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los 5 primeros productos con un coste mayor a 600 y se ordenan ascendentemente");
            System.out.println("-----------------------------");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .sorted()
                    .limit(5)
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Ordenamos todos los productos con coste mayor a 600");
            System.out.println("-----------------------------");
            
            lista.stream()
                    .sorted()
                    .filter(e -> e.getStandardCost() > 600)
                    .forEach(System.out::println);
            
            System.out.println("--NIVEL MEDIO--");
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos en un conjunto los id de las categorias de los productos con coste mayor a 600, al ser conjuntos, no hay id de categorias duplicados");
            System.out.println("-----------------------------");
            
            Set<Integer> setNombres = lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getCategoryId())
                    .collect(Collectors.toSet());
            
            setNombres.stream().forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos en una lista los nombres de los productos con coste mayor a 600");
            System.out.println("-----------------------------");
            
            List<String> listNombres = lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .collect(Collectors.toList());
            
            listNombres.stream().forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Sumamos los costes de los productos con un id par");
            System.out.println("-----------------------------");
            
            double sumaCostesIDPares = lista.stream()
                    .filter(e -> e.getProductId()%2 == 0)
                    .map(e -> e.getStandardCost())
                    .reduce(0.0, (suma, elem) -> suma + elem);
            
            System.out.println("Suma del coste de los productos con id par: "+sumaCostesIDPares);
            
            System.out.println("-----------------------------");
            System.out.println("Calculamos el precio promedio de todos los productos");
            System.out.println("-----------------------------");
            
            double precioPromedio = lista.stream()
                    .map(e -> e.getListPrice())
                    .reduce(0.0, (suma, elem) -> suma + elem);
            
            System.out.println("Precio promedio de los productos: "+(precioPromedio/lista.size()));
            
            System.out.println("--NIVEL ALTO--");
            
            //xxx.yyy.findFirst+Optional
            System.out.println("-----------------------------");
            System.out.println("");
            System.out.println("-----------------------------");
            
            
            
            //xxx.yyy.max+Optional
            System.out.println("-----------------------------");
            System.out.println("");
            System.out.println("-----------------------------");
            
            
        }catch(ProductDataAccessException e){
            System.out.println(e);
        }
        
        
    }
}
