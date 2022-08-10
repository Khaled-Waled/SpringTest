package com.test.entities;


import com.test.dto.CustomerDTO;
import com.test.enums.CustomerType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "customers")
@Entity
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "customer_type")
    @Enumerated(EnumType.STRING)
    CustomerType customerType;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void getFromDTO(CustomerDTO customerDTO)
    {
        this.setFirstName(customerDTO.getFirstName());
        this.setLastName(customerDTO.getLastName());
        this.setCustomerType(customerDTO.getCustomerType());
        this.setAddress(customerDTO.getAddress());
        this.setBirthDate(customerDTO.getBirthDate());
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
