package ru.maslenkin.ws;

public interface ProductService {
	public boolean addProduct(Product name);
    public Product getProduct(int id);
    public Product [] getProduct();

}
