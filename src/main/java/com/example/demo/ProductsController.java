package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductsController 
{
    @Autowired ProductDao productdao;
    @RequestMapping(value = "/get",method=RequestMethod.GET)
    @ResponseBody
    public List<Product> getAllProduct()
    {
            return   productdao.getAll();
    }
    @RequestMapping(value="/insert", method=RequestMethod.POST)
    @ResponseBody
    public String requestMethodName(@RequestBody Product pro) 
    {
        productdao.add(pro);
        return "Added Successfully";
    }


    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public String requestMethodName(@PathVariable int id) 
    {
        productdao.delete(id);
        return "Deleted Successfully";
    }
    @RequestMapping(value = "/update",
    method = RequestMethod.PUT)
    @ResponseBody
    public String updateEmployee(@RequestBody Product prod) {
    Integer result=productdao.update(prod);
    if(result==1){
                  return "Product is updated";
                 }
                 else{
                  return "Product is not  updated";
                 }
}
    
    
    

    
}