package ru.maslenkin.ws;

public class ProductProxy implements ru.maslenkin.ws.Product {
  private String _endpoint = null;
  private ru.maslenkin.ws.Product product = null;
  
  public ProductProxy() {
    _initProductProxy();
  }
  
  public ProductProxy(String endpoint) {
    _endpoint = endpoint;
    _initProductProxy();
  }
  
  private void _initProductProxy() {
    try {
      product = (new ru.maslenkin.ws.ProductServiceLocator()).getProduct();
      if (product != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)product)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)product)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (product != null)
      ((javax.xml.rpc.Stub)product)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ru.maslenkin.ws.Product getProduct() {
    if (product == null)
      _initProductProxy();
    return product;
  }
  
  
}