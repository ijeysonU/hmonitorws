package com.hmonitorws.hmonitorws.Ws.Repository;

import com.hmonitorws.hmonitorws.RootEntity;
import com.hmonitorws.hmonitorws.Ws.Models.DataPatient;
import com.hmonitorws.hmonitorws.Ws.Models.DataPatientEval;
import com.hmonitorws.hmonitorws.Ws.Models.DevicesResponse;
import com.hmonitorws.hmonitorws.Ws.Models.HistoriaResp;
import com.hmonitorws.hmonitorws.Ws.Models.PatientsResponse;
import com.hmonitorws.hmonitorws.Ws.Models.RespEncuesta;
import com.hmonitorws.hmonitorws.Ws.Models.ResponseNewPatient;
import com.hmonitorws.hmonitorws.Ws.Models.ResumenReponse;
import com.hmonitorws.hmonitorws.Ws.Models.SVLastdataResponse;
import com.hmonitorws.hmonitorws.Ws.Models.Statusconnect;
import com.hmonitorws.hmonitorws.Ws.Models.UserDeviceResumen;
import com.hmonitorws.hmonitorws.Ws.Models.UserPatientsResumenReponse;
import com.hmonitorws.hmonitorws.Ws.Models.VerifyEnc;
import com.hmonitorws.hmonitorws.Ws.Models.VitalSignsResponse;
import com.hmonitorws.hmonitorws.Ws.Models.responseCondicion;
import com.hmonitorws.hmonitorws.Ws.Models.tCondicion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<RootEntity, Integer>{
    @Query(value = "select * from fnpacientescontactoCompleto(:us, :tus)", nativeQuery = true)    
    List<PatientsResponse> getPatients(@Param("us") String us, @Param("tus") int tus);

    @Query(value = "select * from fn_listapacientesmedico(:us)", nativeQuery = true)
    List<DataPatientEval> getPatientsMedic(@Param("us") String us);

    @Query(value = "select * from fnDispositivosAsistente(:us, :tus)", nativeQuery = true)    
    List<DevicesResponse> getDevices(@Param("us") String Us, @Param("tus") Integer tUs);

    @Query(value = "select * from fnSignosVitalesPaciente (:us, :pc)", nativeQuery= true)
    List<VitalSignsResponse> getDataSignsPatient(@Param("us") String Us, @Param("pc") String Pc);

    @Query(value = "select * from fnResumen(:us)", nativeQuery= true)
    ResumenReponse getResumen1(@Param("us") String Us);

    @Query(value = "select * from fnResDispositivosContacto(:us)", nativeQuery= true)
    UserDeviceResumen getResumen2(@Param("us") String Us);

    @Query(value = "select * from fnResPacientesActivosContacto(:us)", nativeQuery= true)
    UserPatientsResumenReponse getResumen3(@Param("us") String Us);

    @Query(value = "select * from fnUltimoRegistroSV(:pc)", nativeQuery = true)
    SVLastdataResponse getLastRegister(@Param("pc") String Pc);

    @Query(value = "select * from fnDataHojaPaciente(:us, :pc)", nativeQuery = true)
    DataPatient getPatient(@Param("us") String us,@Param("pc") String pc);

    @Query(value = "select * from spingresarencuesta(:r1, :r2, :r3, :r4, :r5, :r6, :r7, :r8, :r9, :r10, :r11, :r12, :r13, :r14, :pc, :us)", nativeQuery = true)
    HistoriaResp setRespuestas(@Param("r1") String r1, @Param("r2") String r2, @Param("r3") String r3,
     @Param("r4") String r4, @Param("r5") String r5, @Param("r6") String r6,
    @Param("r7") String r7, @Param("r8") String r8, @Param("r9") String r9,
    @Param("r10") String r10, @Param("r11") String r11, @Param("r12") String r12, 
    @Param("r13") String r13, @Param("r14") String r15, @Param("pc") String pc,
    @Param("us") String us);

    @Query(value="select * from fnconexiondispositivo(:pc)", nativeQuery = true)
    Statusconnect getStatusconnect(@Param("pc") String pc);

    @Query(value="select * from fnrespuestasencuesta(:pc)", nativeQuery = true)
    List<RespEncuesta> getRespuestas(@Param("pc") String pc);

    @Query(value = "select * from fnregistropaciente(:cr, :nm, :ap, :id, :ml, :gn, :fn, :cn, :tc)", nativeQuery = true)
    ResponseNewPatient resInsertPatient(@Param("cr") String cr, @Param("nm") String nm, @Param("ap") String ap, 
    @Param("id") String id, @Param("ml") String ml, @Param("gn") String gn, 
    @Param("fn") String fn, @Param("cn") String cn, @Param("tc") String tc);

    @Query(value = "select * from fnverificaencuesta(:pc)", nativeQuery = true)
        VerifyEnc getVerificador(@Param("pc") String pc);

    @Query(value = "select * from fn_select_tipo_condicion_paciente()", nativeQuery = true)
    List<tCondicion> getTCondicion();

    @Query(value = "select * from fncondicionfortype(:tc)", nativeQuery = true)
    List<responseCondicion> getCondicion(@Param("tc") String tc);
}
