package com.bookstore.commons.beans;

public class Product {
   private String id;
   private String name;
   private double price;
   private String category;
   private int pnum;
   private String imgurl;
   private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
       final int prime=31;
       int result=1;
       result=prime * result + ((id==null)? 0:id.hashCode());
       return result;
    }

    @Override
    public boolean equals(Object obj) {
        //如果两个对象是同一个对象，返回true
        if(this==obj)
            return true;
   //测试equals后，也就是参数是否为空，如果为空，返回false
        if(obj==null)
            return false;
        //判断两个对象是否为同种类型的对象，如果不是返回false
        if (getClass()!=obj.getClass())
            return false;
        // obj是product类型，就强制转换从product类型
        Product other=(Product)obj;
        //判断equals后的product的主键不为null，返回false
        if(id==null){
            if(other.id!=null)
                return false;}
        else if(!id.equals(other.id))//如果两个对象的id都不为null，两个id不相等，返回false
            return false;
        //两个对象是同一个类型，并且都不为null，并且它们的id都不为null，并且他们的id相等，返回true
        return true;
        }


     @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", pnum=" + pnum +
                ", imgurl='" + imgurl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
