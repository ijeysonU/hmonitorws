package com.hmonitorws.hmonitorws.Ws.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import com.hmonitorws.hmonitorws.Ws.Services.ProcessServices;

@RestController
@RequestMapping("/api/process")
@CrossOrigin("*")
public class ProcessController {
    
    private final ProcessServices processServices;

    public ProcessController (ProcessServices processServices){
        this.processServices = processServices;
    }

    @RequestMapping(value = "wListarPacientes", method = RequestMethod.GET)
    public List<PatientsResponse> getPatients(@RequestParam String us, @RequestParam int tus){
        return processServices.gPatientsResponses(us, tus);
    }

    @RequestMapping(value = "wListaPacientesMedico", method = RequestMethod.GET)
    public List<DataPatientEval> getPatientsMedic(@RequestParam String us){
        return processServices.getPatientsMedic(us);
    }

    @RequestMapping(value = "wListarDispositivos", method = RequestMethod.GET)
    public List<DevicesResponse> getDevices(@RequestParam String us){
        return processServices.getDevicesResponses(us);
    } 

    @RequestMapping(value = "wListarRegistrosPac", method = RequestMethod.GET)
    public List<VitalSignsResponse> getDataSignsResponses(@RequestParam String us, @RequestParam String pc){
        return processServices.getVitalSignsResponses(us, pc);
    }

    @RequestMapping(value = "wResumen", method = RequestMethod.GET)
    public ResumenReponse getResumen1(@RequestParam String us){
        return processServices.getResumenReponse(us);
    }

    @RequestMapping(value = "wResumenDispositivos", method = RequestMethod.GET)
    public UserDeviceResumen getResumen2(@RequestParam String us){
        return processServices.getUserDeviceResumen(us);
    }

    @RequestMapping(value = "wResumenPacientes", method = RequestMethod.GET)
    public UserPatientsResumenReponse getResumen3(@RequestParam String us){
        return processServices.getPatientsResumenReponse(us);
    }

    @RequestMapping(value = "wUltimoRegistro", method = RequestMethod.GET)
    public SVLastdataResponse getLastRegister(@RequestParam String pc){
        return processServices.getLastSVdataResponse(pc);
    }

    @RequestMapping(value="wDataPatient", method = RequestMethod.GET)
    public DataPatient getPatient(@RequestParam String us, @RequestParam String pc){
        return processServices.getPatient(us, pc);
    }

    @RequestMapping(value="wIngresoHistClinica", method = RequestMethod.POST)
    public HistoriaResp setDataHistClinica(
        @RequestParam String  r1,  @RequestParam String  r2,  @RequestParam String  r3,  
        @RequestParam String  r4,  @RequestParam String  r5,  @RequestParam String  r6,  
        @RequestParam String  r7,  @RequestParam String  r8,  @RequestParam String  r9,  
        @RequestParam String  r10,  @RequestParam String  r11,  @RequestParam String  r12,  
        @RequestParam String  r13,  @RequestParam String  r14, @RequestParam String pc,
        @RequestParam String us)
        {
            System.out.println(r1+ r2+ r3+ r4+"data"+ r5+"data"+ r6+"data"+ r7+"data"+ r8+"data"
            + r9+"data"+ r10+"data"+ r11+"data"+ r12+"data"+ r13+"data"+ r14+"data"+ pc+"data"+ us);
        return processServices.gHistoriaResp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, pc, us);
    }

    @RequestMapping(value="wEstadoConexion", method = RequestMethod.GET)
    public Statusconnect getStatusconnect(@RequestParam String pc){
        return processServices.getStatusconnect(pc);
    }
}
