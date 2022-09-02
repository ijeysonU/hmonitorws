package com.hmonitorws.hmonitorws.Ws.Controllers;



import java.io.Console;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hmonitorws.hmonitorws.Ws.Models.LoginResponse;
import com.hmonitorws.hmonitorws.Ws.Models.UserDataResponse;
import com.hmonitorws.hmonitorws.Ws.Security.Encriptar;
import com.hmonitorws.hmonitorws.Ws.Services.MailServices;
import com.hmonitorws.hmonitorws.Ws.Services.UserServices;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    private final UserServices userServices;
    private MailServices mailServices;
    private Encriptar encriptar;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value="wLogin", method= RequestMethod.POST)
    public LoginResponse loginUser(@RequestParam String us, @RequestParam String ps){
        
        String PassJs1 = encriptar.sha1(ps);
        System.out.println(PassJs1);
        return userServices.userLogin(us, PassJs1);

    }

    @RequestMapping(value = "wRegister", method = RequestMethod.POST)
    public ResponseEntity<Object> UserRegister(@RequestParam String NomR, @RequestParam String ApeR,
    @RequestParam String CorR, @RequestParam String GenR, 
    @RequestParam String FecR,@RequestParam String PsSc){
        String validate = userServices.VerfUser(CorR);
        String vrf = NomR.substring(0, 2) + GenR + FecR.substring(0, 4) + ApeR.substring(0, 8);
        String codVerf = encriptar.sha1(vrf);
        codVerf = codVerf.substring(0, 12); 
        String PsEc = encriptar.sha1(PsSc);
        if(validate == "200"){        
            return new ResponseEntity<Object>(userServices.userRegister(NomR, ApeR, CorR, GenR, FecR, PsEc, codVerf), HttpStatus.valueOf(200));
        }
        String Message = "Your verification code as: "+codVerf;
               
        mailServices.sendEmail(CorR, "Verification Code ", Message);
        return new ResponseEntity<Object>(validate, HttpStatus.valueOf(200)); 
    }

    @RequestMapping(value = "wDataUser", method = RequestMethod.GET)
    public UserDataResponse wDataUser(@RequestParam String Mail){
        return userServices.DataUser(Mail);
        
    }
}
