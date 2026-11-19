package com.store.model;

public class InvoiceDetail {
    private int id;
    private int invoiceId;
    private int productId;
    private int quantity;
    private double price;

    public InvoiceDetail() {}

    public InvoiceDetail(int id, int invoiceId, int productId, int quantity, double price) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() { return id; }
    public int getInvoiceId() { return invoiceId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }
    public void setProductId(int productId) { this.productId = productId; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setPrice(double price) { this.price = price; }

    public double getLineTotal() {
        return price * quantity;
    }
}