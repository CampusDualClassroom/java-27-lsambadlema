package com.campusdual.classroom;

import com.campusdual.classroom.ShoppingListJSONCreator;
import com.campusdual.xml.ShoppingListXMLCreator;

public class Exercise27 {
    public static void main(String[] args) {
        try {
            ShoppingListXMLCreator.createDocument();
            System.out.println("Archivo XML creado exitosamente.");

            ShoppingListJSONCreator.createDocument();
            System.out.println("Archivo JSON creado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al crear los archivos: " + e.getMessage());
        }
    }
}
