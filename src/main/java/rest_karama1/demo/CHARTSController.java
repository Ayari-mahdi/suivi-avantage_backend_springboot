package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CHARTSController {
    @Autowired
    repository4 Anetidata_repo;

    @Autowired
    repository9 ws_aneti_historepo;
// ----------------------------------FIRST CHART :PIE CHART--------------------------------
    @GetMapping("/listemployeesperemployer/{numaffiliation}")
    public CHARTSModel_1  actualadvantagepercentage ()
    {
     long totalnumber= Anetidata_repo.count();
     long karamanumber=  Anetidata_repo.count1("KARAMA");
     long civpnumber= Anetidata_repo.count1("CIVP");
     long csvnumber= Anetidata_repo.count1("CSV");
     long startupnumber= Anetidata_repo.count1("STARTUP-ACT");
     long x1= (karamanumber * 100)/ totalnumber ;
     long x2 =(civpnumber * 100)/ totalnumber ;
     long x3= (csvnumber * 100)/ totalnumber ;
     long x4= (startupnumber * 100)/ totalnumber ;
    CHARTSModel_1 ch = new CHARTSModel_1();
    ch.setKarpercentage(x1);
    ch.setCivppercentage(x2);
    ch.setScvpercentage(x3);
    ch.setStartuppercentage(x4);

       // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return ch ;
    }
    // ----------------------------------2ND CHART--------------------------------
    @GetMapping("/listemployeesperemployer/{numaffiliation}")
    public List<ws_aneti_historique>  aadvantagenumbershisto ()
    {

        List<ws_aneti_historique> list = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate d = localDateTime.toLocalDate();
        //  if (d.getMonthValue()>=4)
        //  {
          ws_aneti_historique l=  ws_aneti_historepo.selectfirst("KARAMA",d);
          l.setNumber(ws_aneti_historepo.countbydate(l.getImport_local()));
          list.add(l);
          ws_aneti_historique l2=  ws_aneti_historepo.selectrest("KARAMA",d,l.getId());
        l2.setNumber(ws_aneti_historepo.countbydate(l2.getImport_local()));
          list.add(l2);
          ws_aneti_historique l3=  ws_aneti_historepo.selectrest("KARAMA",d,l2.getId());
        l3.setNumber(ws_aneti_historepo.countbydate(l3.getImport_local()));
          list.add(l3);

        ws_aneti_historique l4=  ws_aneti_historepo.selectfirst("CIVP",d);
        l4.setNumber(ws_aneti_historepo.countbydate(l4.getImport_local()));
        list.add(l4);
        ws_aneti_historique l5=  ws_aneti_historepo.selectrest("CIVP",d,l4.getId());
        l5.setNumber(ws_aneti_historepo.countbydate(l5.getImport_local()));
        list.add(l5);
        ws_aneti_historique l6=  ws_aneti_historepo.selectrest("CIVP",d,l5.getId());
        l6.setNumber(ws_aneti_historepo.countbydate(l6.getImport_local()));
        list.add(l6);

        ws_aneti_historique l7=  ws_aneti_historepo.selectfirst("CSV",d);
        l7.setNumber(ws_aneti_historepo.countbydate(l7.getImport_local()));
        list.add(l7);
        ws_aneti_historique l8=  ws_aneti_historepo.selectrest("CSV",d,l7.getId());
        l8.setNumber(ws_aneti_historepo.countbydate(l8.getImport_local()));
        list.add(l8);
        ws_aneti_historique l9=  ws_aneti_historepo.selectrest("CSV",d,l8.getId());
        l9.setNumber(ws_aneti_historepo.countbydate(l9.getImport_local()));
        list.add(l9);

        ws_aneti_historique l10=  ws_aneti_historepo.selectfirst("STARTUP-ACT",d);
        l10.setNumber(ws_aneti_historepo.countbydate(l10.getImport_local()));
        list.add(l10);
        ws_aneti_historique l11=  ws_aneti_historepo.selectrest("STARTUP-ACT",d,l10.getId());
        l11.setNumber(ws_aneti_historepo.countbydate(l11.getImport_local()));
        list.add(l11);
        ws_aneti_historique l12=  ws_aneti_historepo.selectrest("STARTUP-ACT",d,l11.getId());
        l12.setNumber(ws_aneti_historepo.countbydate(l12.getImport_local()));
        list.add(l12);
         // }
     //   if (d.getMonthValue()<4)
     //    {
      //       d.getYear()
        // }
        // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return list ;
    }




}
