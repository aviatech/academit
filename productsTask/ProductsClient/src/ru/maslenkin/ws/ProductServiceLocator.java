/**
 * ProductServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ru.maslenkin.ws;

public class ProductServiceLocator extends org.apache.axis.client.Service implements ru.maslenkin.ws.ProductService {

    public ProductServiceLocator() {
    }


    public ProductServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProductServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Product
    private java.lang.String Product_address = "http://localhost:8080/Products/services/Product";

    public java.lang.String getProductAddress() {
        return Product_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ProductWSDDServiceName = "Product";

    public java.lang.String getProductWSDDServiceName() {
        return ProductWSDDServiceName;
    }

    public void setProductWSDDServiceName(java.lang.String name) {
        ProductWSDDServiceName = name;
    }

    public ru.maslenkin.ws.Product getProduct() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Product_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProduct(endpoint);
    }

    public ru.maslenkin.ws.Product getProduct(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ru.maslenkin.ws.ProductSoapBindingStub _stub = new ru.maslenkin.ws.ProductSoapBindingStub(portAddress, this);
            _stub.setPortName(getProductWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProductEndpointAddress(java.lang.String address) {
        Product_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ru.maslenkin.ws.Product.class.isAssignableFrom(serviceEndpointInterface)) {
                ru.maslenkin.ws.ProductSoapBindingStub _stub = new ru.maslenkin.ws.ProductSoapBindingStub(new java.net.URL(Product_address), this);
                _stub.setPortName(getProductWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Product".equals(inputPortName)) {
            return getProduct();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.maslenkin.ru", "ProductService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.maslenkin.ru", "Product"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Product".equals(portName)) {
            setProductEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
