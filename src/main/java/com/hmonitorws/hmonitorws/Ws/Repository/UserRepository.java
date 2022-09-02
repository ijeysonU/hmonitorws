package com.hmonitorws.hmonitorws.Ws.Repository;

import com.hmonitorws.hmonitorws.RootEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.hmonitorws.hmonitorws.Ws.Models.LoginResponse;
import com.hmonitorws.hmonitorws.Ws.Models.RegUserResponse;
import com.hmonitorws.hmonitorws.Ws.Models.UserDataResponse;

@Repository
public interface UserRepository extends JpaRepository<RootEntity, Integer> {
    @Query(value = "select * from fnlogin (:us, :ps)", nativeQuery = true)
    LoginResponse loginUser(@Param("us") String us, @Param("ps") String ps);

    @Query(value = "select * from fnRegistroUsuarioCont (:NomR, :ApeR, :CorR, :GenR, :FecR, :PasSc, :codVer)", nativeQuery = true)
    RegUserResponse UserRegister(@Param("NomR") String NomR, @Param("ApeR")String ApeR,
    @Param("CorR") String CorR, @Param("GenR") String GenR, 
    @Param("FecR")String FecR,@Param("PasSc") String PsSc, 
    @Param("codVer")String codVer);

    @Query(value = "select * from fnVerificarCorreo (:corR)", nativeQuery = true)
    String VerfUser(@Param("corR") String corR);

    @Query(value = "select * from fnDatauser(:Mail)", nativeQuery = true)
    UserDataResponse DataUser(@Param("Mail") String Mail);
}
