package jlin2.examples.localtesting

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class EmailValidatorTest {
    
    @Test
    fun correctEmailTest(){
        val result = EmailValidator.isValidEmail("123@abc.com")
        assertEquals(true,result)
    }
    @Test
    fun correctEmailSubdomainTest(){
        val result = EmailValidator.isValidEmail("123@abc.co.ca")
        assertEquals(true,result)
    }

    @Test
    fun incorrectEmailTest(){
        val result = EmailValidator.isValidEmail("123@abc")
        assertEquals(false,result)
    }

    @Test
    fun incorrectEmailWithDoubleDotsTest(){
        val result = EmailValidator.isValidEmail("123@abc..com")
        assertEquals(false,result)
    }

    @Test
    fun incorrectEmailAddressFormat(){
        val result = EmailValidator.isValidEmail("@abc.com")
        assertEquals(false, result)
    }

    @Test
    fun incorrectEmailDomainFormat(){
        val result = EmailValidator.isValidEmail("testing123")
        assertEquals(false, result)
    }

    @Test
    fun incorrectEmailWithEmptyString(){
        val result = EmailValidator.isValidEmail("")
        assertEquals(false, result)
    }

    @Test
    fun incorrectEmailWithNull(){
        val result = EmailValidator.isValidEmail(null)
        assertEquals(false, result)
    }
}