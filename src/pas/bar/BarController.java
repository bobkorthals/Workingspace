/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pas.bar;

import mvc.controller.AbstractController;

/**
 *
 * @author jkg
 */
public class BarController extends AbstractController {
    
    public void barAction(){
    Bar view=new Bar(this);
    open(view);
    }
    
    public void newBarOrderAction(){
    newBarOrder view=new newBarOrder(this);
    open(view);
    }
    
    public void editBarAction(){
    editBar view=new editBar(this);
    open(view);
    }
    
    public void productAction(){
    Product view=new Product(this);
    open(view);
    }
    
    public void paymentBarAction(){
    paymentBar view=new paymentBar(this);
    open(view);
    }
    
    public void addProductAction(){
    AddProduct view=new AddProduct(this);
    open(view);
    }
    
  

}
