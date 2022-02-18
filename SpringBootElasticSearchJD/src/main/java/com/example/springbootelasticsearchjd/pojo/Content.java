package com.example.springbootelasticsearchjd.pojo;

/**
 * 2022/2/17
 * Hewen
 * 云想衣裳花想容，春风拂槛露华浓
 * 最是人间留不住，朱颜辞镜花辞树
 */
public class Content {
    private String name;
    private String price;
    private String img;

    @Override
    public String toString() {
        return "Content{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Content() {
    }

    public Content(String name, String price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
