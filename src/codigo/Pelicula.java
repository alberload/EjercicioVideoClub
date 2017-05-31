/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.List;

/**
 *
 * @author alber
 */
public class Pelicula {
    
    int id;
    String titulo;
    int ano;
    String pais;
    String[] genero;
    String imdb;
    String clasificacion_imdb;
    String resumen;
    
    public Pelicula(int id, String titulo, int ano, String pais, String[] genero,
            String imdb, String clasificacion_imdb, String resumen){
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
        this.pais = pais;
        this.genero = genero.clone();
        this.imdb = imdb;
        this.clasificacion_imdb = clasificacion_imdb;
        this.resumen = resumen;
    }    
}
