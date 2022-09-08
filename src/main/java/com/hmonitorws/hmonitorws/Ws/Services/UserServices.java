package com.hmonitorws.hmonitorws.Ws.Services;



import com.hmonitorws.hmonitorws.Ws.Models.LoginResponse;
import com.hmonitorws.hmonitorws.Ws.Models.RegUserResponse;
import com.hmonitorws.hmonitorws.Ws.Models.UserDataProfile;
import com.hmonitorws.hmonitorws.Ws.Models.UserDataResponse;
import com.hmonitorws.hmonitorws.Ws.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    
    private final UserRepository userRepository;
    
    public UserServices(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public LoginResponse userLogin(String Us, String Ps){
        return userRepository.loginUser(Us, Ps);
    }
    public String VerfUser(String CorR){
        return userRepository.VerfUser(CorR);
    }
    public UserDataResponse DataUser(String Mail){
        return userRepository.DataUser(Mail);
    }
    public RegUserResponse userRegister(String NomR, String ApeR,
    String CorR, String GenR, String FecR, String PsSc, String CodVer){
        return userRepository.UserRegister(NomR, ApeR, CorR, GenR, FecR, PsSc, CodVer);
    }

    public UserDataProfile getDataProf(String mail, Integer tusr){
        return userRepository.getDataProf(mail, tusr);
    }

    
}
