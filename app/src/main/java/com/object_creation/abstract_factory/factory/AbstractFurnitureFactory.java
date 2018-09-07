package com.object_creation.abstract_factory.factory;

import com.object_creation.abstract_factory.products.Chair;
import com.object_creation.abstract_factory.products.Sofa;
import com.object_creation.abstract_factory.products.Table;

public abstract class AbstractFurnitureFactory {

    public abstract Chair createChair();

    public abstract Sofa createSofa();

    public abstract Table createTable();

}
