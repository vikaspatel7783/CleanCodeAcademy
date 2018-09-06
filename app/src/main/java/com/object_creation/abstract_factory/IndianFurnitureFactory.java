package com.object_creation.abstract_factory;

import com.object_creation.abstract_factory.products.Chair;
import com.object_creation.abstract_factory.products.Sofa;
import com.object_creation.abstract_factory.products.Table;
import com.object_creation.abstract_factory.products.concret_products.IndianChair;
import com.object_creation.abstract_factory.products.concret_products.IndianSofa;
import com.object_creation.abstract_factory.products.concret_products.IndianTable;

public class IndianFurnitureFactory extends AbstractFurnitureFactory {

    @Override
    Chair createChair() {
        printLog("IndianChair");
        return new IndianChair();
    }

    @Override
    Sofa createSofa() {
        printLog("IndianSofa");
        return new IndianSofa();
    }

    @Override
    Table createTable() {
        printLog("IndianTable");
        return new IndianTable();
    }

    private void printLog(String log) {
        System.out.println(log);
    }

}
