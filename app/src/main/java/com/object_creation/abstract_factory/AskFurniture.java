package com.object_creation.abstract_factory;

public class AskFurniture {

    public FurnitureClient.Furniture askForFurniture(String furnitureType) {
        if (furnitureType.equals("Indian")) {
            return new FurnitureClient(new IndianFurnitureFactory()).getFurniture();
        } else if (furnitureType.equals("Arabian")) {
            return new FurnitureClient(new ArabianFurnitureFactory()).getFurniture();
        }
        return null;
    }

}
