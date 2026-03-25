package com.mycompany.trabajocolaborativoud8;

import java.util.List;

public class Aplication {
    public static void main(String[] args) {
        ProductsDataAccessObject pda = new ProductsDataAccessObject();
        
        try{
            List<Products> lista = pda.selectAll();
        
            System.out.println("--NIVEL BAJO--");
            
            //filter.map.forEach
            
            //map.filet.distinct.forEach
            
            //filter.sorted.limit.forEach
            
            //sorted.filter.forEach
            
            System.out.println("--NIVEL MEDIO--");
            
            //xxx.yyy.collect(Collectors.toSet)
            
            //xxx.yyy.collect(Collectors.toList)
            
            //xxx.yyy.reduce(...)
            
            //xxx.yyy.reduce(...)
            
            System.out.println("--NIVEL ALTO--");
            
            //xxx.yyy.findFirst+Optional
            
            //xxx.yyy.max+Optional
            
            
        }catch(ProductDataAccessException e){
            System.out.println(e);
        }
        
        
    }
}
