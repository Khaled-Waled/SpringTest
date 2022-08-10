package com.test.dto;

import com.test.enums.CustomerType;

import java.util.Date;
import java.util.List;

public class CustomerDTO
{
    private long id;
    private String firstName;
    private String lastName;


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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
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

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
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
