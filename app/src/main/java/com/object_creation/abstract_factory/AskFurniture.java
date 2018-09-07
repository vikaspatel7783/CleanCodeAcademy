package com.object_creation.abstract_factory;

import com.object_creation.abstract_factory.factory.ArabianFurnitureFactory;
import com.object_creation.abstract_factory.factory.IndianFurnitureFactory;

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
