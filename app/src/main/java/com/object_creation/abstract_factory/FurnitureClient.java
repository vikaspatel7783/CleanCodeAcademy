package com.object_creation.abstract_factory;

import com.object_creation.abstract_factory.factory.AbstractFurnitureFactory;
import com.object_creation.abstract_factory.products.Chair;
import com.object_creation.abstract_factory.products.Sofa;
import com.object_creation.abstract_factory.products.Table;

public class FurnitureClient {

    private AbstractFurnitureFactory furnitureFactory;

    public FurnitureClient(AbstractFurnitureFactory furnitureFactory) {
        this.furnitureFactory = furnitureFactory;
    }

    public Furniture getFurniture() {
        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();
        Table table = furnitureFactory.createTable();

        return new Furniture(chair, sofa, table);
    }

    class Furniture {
        Chair chair;
        Sofa sofa;
        Table table;

        Furniture(Chair chair, Sofa sofa, Table table) {
        }
    }

}
