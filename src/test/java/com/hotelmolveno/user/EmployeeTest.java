package com.hotelmolveno.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {


    private Employee employee;

    @Before
    public void setup() {
        this.employee = new Employee();
    }

    @Test
    public void testSetID() {
        this.guest.setID(5);
        Assert.assertEquals(5, guest.getID());
    }
}

