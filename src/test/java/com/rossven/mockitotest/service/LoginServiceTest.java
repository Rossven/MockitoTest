package com.rossven.mockitotest.service;

import com.rossven.mockitotest.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock// userdao servisini mockluyoruz
    UserDao userDao;

    @InjectMocks // mockladıgımız parcaları test ettigimiz service'e enjekte ediyoruz.
    private LoginService loginService;

    @Test
    public void canLogin(){
        String userName = "Atakan";
        String userPassword = "111222";

        //before
        //Basit bir User sinifi olusturup icine degerlerimizi atıyoruz.
        User user = new User(userName,userPassword);

        //when
        //userDao'ya findUserByName metodu çagrisi gelirse, benim olusturmus oldugum user'i döndürmesini saglıyoruz.
        //eger when kullanmasaydık cagri bize null deger döndürecekti.
        when(userDao.findUserByName(userName)).thenReturn(user);


        //then
        //Burdada kullanıcı adı ve sifremizin dogru olduktan sonra döndürülen sonucun true olup olmadığını kontrol ediyoruz.
        assertTrue(loginService.canLogin(userName,userPassword));

        
        //findUserByName metodunun bize hangi çıktıyı verdiğini doğrulamış oluyoruz
        verify(userDao).findUserByName("Atakan");


    }

}