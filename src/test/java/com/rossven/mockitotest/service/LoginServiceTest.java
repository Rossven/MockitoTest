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

//Mockito Annotasyonları kullanabilmek için @RunWith annotasyonunu kullanıyoruz.
@RunWith(MockitoJUnitRunner.class)
public class LoginServiceTest {

    @Mock// userdao servisini mockluyoruz
    UserDao userDao;

    @InjectMocks // mockladıgımız parcaları test ettigimiz service'e enjekte ediyoruz.
    private LoginService loginService;

    @Test // Test etmek istedğimiz fonksiyona @Test Annotasyonunu ekliyoruz.
    public void canLogin(){
        String userName = "Atakan";
        String userPassword = "111222";

        //before
        //Basit bir User sinifi olusturup icine denemek icin rastgele degerlerimizi atıyoruz.
        User user = new User(userName,userPassword);

        //when
        //userDao'ya findUserByName metodu çagrisi gelirse, benim olusturmus oldugum user'i döndürmesini saglıyoruz.
        //eger when kullanmasaydık cagri bize null deger döndürecekti.
        when(userDao.findUserByName(userName)).thenReturn(user);


        //then
        //Burdada kullanıcı adı ve sifremizin retrun edilen userdaki bilgiler ile eslesip eslesmedigini gördükten
        // sonra döndürülen sonucun true olup olmadığını kontrol ediyoruz. Eger False deger döndürüyor ise test basarisizlikla sonuclanir
        assertTrue(loginService.canLogin(userName,userPassword));


        //findUserByName metodunun, canLogin metodu içinde cagirildiginda dogru sonuc verip vermedigini kontrol ediyoruz.
        verify(userDao).findUserByName("Atakan");


    }

}