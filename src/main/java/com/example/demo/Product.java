package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product
{   @Id
    @Column(name = "id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="unitprice")
    private int unitprice;
    public Product(){}
    public Product(int id,String title,int unitprice)
    {   this.id=id;
        this.title=title;
        this.unitprice=unitprice;

    }
    public void setid(int id){this.id=id;}
    public int getid(){return id;}
    public void settitle(String tit){this.title=tit;}
    public String gettitle(){return title;}
    public void setunit(int un){this.unitprice=un;}
    public int getunit(){return unitprice;}




    
}