package ru;

public class Item {
    private String id;
    private String name, desc;
    private long created;
    private String[] comments;

    Item (String name,String desc, long create){
        this.name = name;
        this.desc = desc;
        this.created = create;
    }

    public void setId(String st) {
        this.id = st;
    }

    public String getId() {
        return this.id;
    }
    public String getName() {
        return name;
    }
}

