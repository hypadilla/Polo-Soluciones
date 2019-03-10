/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.File;

/**
 *
 * @author cdap_
 */
public class FileManager {

    public static boolean Existe(String path) {
        File archivo = new File(path);
        return archivo.exists();
    }
    
    public static void Crear (String path){
        if (!Existe(path)) {
            File archivo = new File(path);
            archivo.mkdirs();
        }
    }
}
