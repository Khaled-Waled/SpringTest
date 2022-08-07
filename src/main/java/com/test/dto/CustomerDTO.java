package com.test.dto;

import com.test.enums.CustomerType;

import java.util.Date;
import java.util.List;

public class CustomerDTO
{
    private long id;
    private String fName;
    private String lName;


    private String phone;
    private CustomerType customerType;

    private String address;
    private Date birthDate;
    private List<Integer> accountIDs;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public List<Integer> getAccountIDs()
    {
        return accountIDs;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public CustomerType getCustomerType()
    {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType)
    {
        this.customerType = customerType;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setAccountIDs(List<Integer> accountIDs)
    {
        this.accountIDs = accountIDs;
    }
}
