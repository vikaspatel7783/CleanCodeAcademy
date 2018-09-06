package com.object_creation.abstract_factory;

import com.object_creation.abstract_factory.products.Chair;
import com.object_creation.abstract_factory.products.Sofa;
import com.object_creation.abstract_factory.products.Table;

public abstract class AbstractFurnitureFactory {

    abstract Chair createChair();

    abstract Sofa createSofa();

    abstract Table createTable();

}
