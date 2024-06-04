package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Store {

    String jsonSchema;

    public int id;
    public String endpointPet = "/store";
    public String endpointInventory = "/store/inventory";
    public String endpointOrder = "/store/order/";
    public String validOrderJson = "src\\test\\resources\\schemas\\validOrder.json";

    // ACCEDER AL SCHEMA
    public String accessStoreSchema(){
        return this.jsonSchema;
    }

    // CREAR AL OBJETO
    public void createDefaultStoreObject(){
        try{
            jsonSchema = new String(Files.readAllBytes(Paths.get(validOrderJson)));
        } catch (IOException e){
            System.out.println("===== Error with Order Json Schema =====");
            e.printStackTrace();
        }
    }
    public void createfullPetObject(String id, String name, String category_id, String category_name, String photo_url, String tag_id, String tag_name, String status){
        jsonSchema = String.format(
                "{\"id\": %s, \"name\": \"%s\", \"category\": {\"id\": %s, \"name\": \"%s\"}, \"photoUrls\": [\"%s\"], \"tags\": [{\"id\": %s, \"name\": \"%s\"}], \"status\": \"%s\"}",
                id, name, category_id, category_name, photo_url, tag_id, tag_name, status
        );
    }

}
