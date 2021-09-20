package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newID = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public String createPet (@RequestBody Pet pet) {
        Integer id = newID.getAndIncrement();
        petModel.add(pet, id);
        return "Pet with id '" + id + "' was created";
    }
    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }

    /*
    {
    "id": 3
    }
     */
    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer>id){
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet", consumes = "application/json", produces = "application/json")
    public void deletePet(@RequestParam("id") int id){
        petModel.delete(id);
    }

    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public Pet updatePet(@RequestBody Pet pet){
        petModel.edit(pet);
        return pet;
    }

}

