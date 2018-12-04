package model;
// Generated Apr 8, 2017 11:28:03 PM by Hibernate Tools 4.3.1



/**
 * Headphone generated by hbm2java
 */
public class Headphone  implements java.io.Serializable {


     private String pid;
     private Product product;
     private String name;
     private float price;
     private int count;
     private String company;
     private String type;
     private String model;
     private String color;
     private String connectorType;
     private String description;

    public Headphone() {
    }

	
    public Headphone(Product product, String name, float price, int count) {
        this.product = product;
        this.name = name;
        this.price = price;
        this.count = count;
    }
    public Headphone(Product product, String name, float price, int count, String company, String type, String model, String color, String connectorType, String description) {
       this.product = product;
       this.name = name;
       this.price = price;
       this.count = count;
       this.company = company;
       this.type = type;
       this.model = model;
       this.color = color;
       this.connectorType = connectorType;
       this.description = description;
    }
   
    public String getPid() {
        return this.pid;
    }
    
    public void setPid(String pid) {
        this.pid = pid;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return this.price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getConnectorType() {
        return this.connectorType;
    }
    
    public void setConnectorType(String connectorType) {
        this.connectorType = connectorType;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


