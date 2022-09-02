package com.hmonitorws.hmonitorws.Ws.Services;

import org.springframework.stereotype.Service;

import com.hmonitorws.hmonitorws.Ws.Models.DataPatient;
import com.hmonitorws.hmonitorws.Ws.Models.DataPatientEval;
import com.hmonitorws.hmonitorws.Ws.Models.DevicesResponse;
import com.hmonitorws.hmonitorws.Ws.Models.HistoriaResp;
import com.hmonitorws.hmonitorws.Ws.Models.PatientsResponse;
import com.hmonitorws.hmonitorws.Ws.Models.ResumenReponse;
import com.hmonitorws.hmonitorws.Ws.Models.SVLastdataResponse;
import com.hmonitorws.hmonitorws.Ws.Models.Statusconnect;
import com.hmonitorws.hmonitorws.Ws.Models.UserDeviceResumen;
import com.hmonitorws.hmonitorws.Ws.Models.UserPatientsResumenReponse;
import com.hmonitorws.hmonitorws.Ws.Models.VitalSignsResponse;
import com.hmonitorws.hmonitorws.Ws.Repository.ProcessRepository;

import java.util.List;

@Service
public class ProcessServices {
    
    private ProcessRepository processRepository;
    
    public ProcessServices(ProcessRepository processRepository){
        this.processRepository = processRepository;
    }

    public List<PatientsResponse> gPatientsResponses(String us, int tus){
        return processRepository.getPatients(us, tus);
    }
    public List<DataPatientEval> getPatientsMedic(String us){
        return processRepository.getPatientsMedic(us);
    }

    public List<DevicesResponse> getDevicesResponses(String us){
        return processRepository.getDevices(us);
    }

    public List<VitalSignsResponse> getVitalSignsResponses(String us, String pc){
        return processRepository.getDataSignsPatient(us, pc);
    }

    public ResumenReponse getResumenReponse(String us){
        return processRepository.getResumen1(us);
    }

    public UserDeviceResumen getUserDeviceResumen(String us){
        return processRepository.getResumen2(us);
    }

    public UserPatientsResumenReponse getPatientsResumenReponse(String us){
        return processRepository.getResumen3(us);
    }

    public SVLastdataResponse getLastSVdataResponse(String pc){
        return processRepository.getLastRegister(pc);
    }

    public DataPatient getPatient(String us, String pc){
        return processRepository.getPatient(us, pc);
    }
    public HistoriaResp gHistoriaResp(String r1, String r2, String r3,
     String r4, String r5, String r6, String r7, String r8, String r9, 
     String r10, String r11, String r12, String r13, String r14, String pc, String us){
        return processRepository.setRespuestas( r1,  r2,  r3,  r4,  r5,  r6,  r7, 
         r8,  r9,  r10,  r11,  r12,  r13,  r14, pc, us);
     }

     public Statusconnect getStatusconnect(String pc){
        return processRepository.getStatusconnect(pc);
    }
}
