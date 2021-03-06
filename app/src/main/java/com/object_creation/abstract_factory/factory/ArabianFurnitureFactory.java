package com.object_creation.abstract_factory.factory;

import com.object_creation.abstract_factory.products.Chair;
import com.object_creation.abstract_factory.products.Sofa;
import com.object_creation.abstract_factory.products.Table;
import com.object_creation.abstract_factory.products.concret_products.ArabianChair;
import com.object_creation.abstract_factory.products.concret_products.ArabianSofa;
import com.object_creation.abstract_factory.products.concret_products.ArabianTable;

public class ArabianFurnitureFactory extends AbstractFurnitureFactory {

    @Override
    public Chair createChair() {
        printLog("ArabianChair");
        return new ArabianChair();
    }

    @Override
    public Sofa createSofa() {
        printLog("ArabianSofa");
        return new ArabianSofa();
    }

    @Override
    public Table createTable() {
        printLog("ArabianTable");
        return new ArabianTable();
    }

    private void printLog(String log) {
        System.out.println(log);
    }

}
