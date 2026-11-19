package com.store.model;

import java.util.Date;

public class Invoice {
    private int id;
    private Date invoiceDate;
    private double total;
    private int customerId;
    private int employeeId;

    public Invoice() {
        this.invoiceDate = new Date();
    }

    public Invoice(int id, double total, int customerId, int employeeId) {
        this.id = id;
        this.invoiceDate = new Date();
        this.total = total;
        this.customerId = customerId;
        this.employeeId = employeeId;
    }

    public int getId() { return id; }
    public Date getInvoiceDate() { return invoiceDate; }
    public double getTotal() { return total; }
    public int getCustomerId() { return customerId; }
    public int getEmployeeId() { return employeeId; }

    public void setId(int id) { this.id = id; }
    public void setTotal(double total) { this.total = total; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
}