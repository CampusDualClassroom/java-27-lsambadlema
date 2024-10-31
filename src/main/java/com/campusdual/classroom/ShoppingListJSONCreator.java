package com.campusdual.classroom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ShoppingListJSONCreator {

    public static void createDocument() throws IOException {
        JsonObject root = new JsonObject();
        JsonArray itemsArray = new JsonArray();
        itemsArray.add(createItem("Manzana", 2));
        itemsArray.add(createItem("Leche", 1));
        itemsArray.add(createItem("Pan", 3));
        itemsArray.add(createItem("Huevo", 2));
        itemsArray.add(createItem("Queso", 1));
        itemsArray.add(createItem("Cereal", 1));
        itemsArray.add(createItem("Agua", 4));
        itemsArray.add(createItem("Yogur", 6));
        itemsArray.add(createItem("Arroz", 2));

        root.add("items", itemsArray);

        String filePath = "src/main/resources/shoppingList.json";
        ensureDirectoryExists(filePath);

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(root.toString());
            writer.flush();

        }

        System.out.println("Archivo JSON creado exitosamente en " + filePath);
    }

    private static void ensureDirectoryExists(String filePath) {
    }

    private static JsonObject createItem(String text, int quantity) {
        JsonObject item = new JsonObject();
        item.addProperty("text", text);
        item.addProperty("quantity", quantity);
        return item;
    }

    }

