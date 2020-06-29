package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao
{   @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getAll()
    {  String selectCommand="select * from product";
        return jdbcTemplate.query(selectCommand,(rs,row)->new Product
        (
            rs.getInt("id"),
            rs.getString("title"),
            rs.getInt("unitprice"))
        );
    }

    public int  add(Product pro)
    {
        String addCommand="insert into product(id,title,unitprice) values(?,?,?)";
        return jdbcTemplate.update(addCommand,pro.getid(),pro.gettitle(),pro.getunit());
    }
    
    public String delete(int id)
    {
        String deleteCommand="delete from product where id=?";
         jdbcTemplate.update(deleteCommand,new Object []{id});
         return "Deleted an Item";


    }
    public int update(Product prod)  
    {
        String updateCommand = "update product set title=?,unitprice=? where id="+prod.getid();
        return jdbcTemplate.update(updateCommand,
                                prod.gettitle(),
                                prod.getunit()); 
    }
}