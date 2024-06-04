package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pet {

    String jsonSchema;
    public String endpointPet = "/pet";
    public String endpointFindByStatus = "/pet/findByStatus";
    public String endpointFindByTags = "/pet/findByTags";
    public String endpointPetid = "/pet/";
    public String validPetJson = "src\\test\\resources\\schemas\\validPet.json";

    // CREATE OBJECT
    public void createDefaultPetObject(){
        try{
            jsonSchema = new String(Files.readAllBytes(Paths.get(validPetJson)));
        } catch (IOException e){
            System.out.println("===== Error with Pet Json Schema =====");
            e.printStackTrace();
        }
    }

    public void createIdPetObject(Object petId){
        jsonSchema = String.format(
                "{\"id\": %s, \"name\": \"doggie\", \"category\": {\"id\": 1, \"name\": \"Dogs\"}, \"photoUrls\": [\"String\"], \"tags\": [{\"id\": 0, \"name\": \"string\"}], \"status\": \"available\"}",
                petId
        );
    }

    public void createfullPetObject(String id, String name, String category_id, String category_name, String photo_url, String tag_id, String tag_name, String status){
        jsonSchema = String.format(
                "{\"id\": %s, \"name\": \"%s\", \"category\": {\"id\": %s, \"name\": \"%s\"}, \"photoUrls\": [\"%s\"], \"tags\": [{\"id\": %s, \"name\": \"%s\"}], \"status\": \"%s\"}",
                id, name, category_id, category_name, photo_url, tag_id, tag_name, status
        );
    }

    // ACCESS SCHEMA
    public String accessPetSchema(){
        return this.jsonSchema;
    }

}
