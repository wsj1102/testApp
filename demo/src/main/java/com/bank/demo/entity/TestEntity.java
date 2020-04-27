package com.bank.demo.entity;

/**
 * TestEntity
 */
public class TestEntity {

    private String map ;
    private String main ;
    private TestEntity entity ;

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public TestEntity getEntity() {
        return entity;
    }

    public void setEntity(TestEntity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "TestEntity [entity=" + entity + ", main=" + main + ", map=" + map + "]";
    }

    
    
}