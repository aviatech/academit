package ru.maslenkin.ws;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ProductServiceImpl implements ProductService  {
	
	 private static Map<Integer, Product> products;
	    public ProductServiceImpl() {
	        if (products == null)
	            products = new HashMap<Integer,Product>();
	    }

	@Override
	public boolean addProduct(Product name) {
		  if (products.get(name.getId()) != null)
	            return false;
	        products.put(name.getId(), name);
	        return true;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product[] getProduct() {
		 Set<Integer> ids = products.keySet();
	        Product[] p = new Product[ids.size()];
	        int i = 0;
	        for(Integer id : ids){
	            p[i] = products.get(id);
	            i++;
	        }
	        return p;
	}
	

}
