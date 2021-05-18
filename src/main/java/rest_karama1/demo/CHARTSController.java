package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class CHARTSController {
    @Autowired
    repository4 Anetidata_repo;

    @Autowired
    repository9 ws_aneti_historepo;

// ----------------------------------FIRST CHART :PIE CHART--------------------------------
    @GetMapping("/firstchart")
    public CHARTSModel_1  actualadvantagepercentage ()
    {
     long totalnumber= Anetidata_repo.count();
     long karamanumber=  Anetidata_repo.count1("KARAMA");
     long civpnumber= Anetidata_repo.count1("CIVP");
     long csvnumber= Anetidata_repo.count1("SCV");
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
    @GetMapping("/secondchart")
    public List<ws_aneti_historique>  aadvantagenumbershisto ()
    {

        List<ws_aneti_historique> list = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate d = localDateTime.toLocalDate();
        //  if (d.getMonthValue()>=4)
        //  {
          ws_aneti_historique l=  ws_aneti_historepo.selectfirst("KARAMA");

          l.setNumber(Anetidata_repo.countbydate(l.getImport_local()));
          list.add(l);
         Optional<ws_aneti_historique> l2=  ws_aneti_historepo.selectrest("KARAMA",l.getId());
         if (l2.isPresent()){
             l2.get().setNumber(Anetidata_repo.countbydate(l2.get().getImport_local()));
             list.add(l2.get());
             Optional<ws_aneti_historique>  l3=  ws_aneti_historepo.selectrest("KARAMA",l2.get().getId());
             if (l3.isPresent()) {
                 l3.get().setNumber(Anetidata_repo.countbydate(l3.get().getImport_local()));
                 list.add(l3.get());
             }
         }


        ws_aneti_historique l4=  ws_aneti_historepo.selectfirst("CIVP");
        l4.setNumber(Anetidata_repo.countbydate(l4.getImport_local()));
        list.add(l4);
        Optional<ws_aneti_historique>   l5=  ws_aneti_historepo.selectrest("CIVP",l4.getId());
        if (l5.isPresent()) {
            l5.get().setNumber(Anetidata_repo.countbydate(l5.get().getImport_local()));
            list.add(l5.get());
            Optional<ws_aneti_historique> l6 = ws_aneti_historepo.selectrest("CIVP", l5.get().getId());
            if (l6.isPresent()) {
                l6.get().setNumber(Anetidata_repo.countbydate(l6.get().getImport_local()));
                list.add(l6.get());
            }
        }
        ws_aneti_historique l7=  ws_aneti_historepo.selectfirst("SCV");
        l7.setNumber(Anetidata_repo.countbydate(l7.getImport_local()));
        list.add(l7);
        Optional<ws_aneti_historique> l8=  ws_aneti_historepo.selectrest("SCV",l7.getId());
        if (l8.isPresent()) {
            l8.get().setNumber(Anetidata_repo.countbydate(l8.get().getImport_local()));
            list.add(l8.get());
            Optional<ws_aneti_historique> l9 = ws_aneti_historepo.selectrest("SCV", l8.get().getId());
            if (l9.isPresent()) {
                l9.get().setNumber(Anetidata_repo.countbydate(l9.get().getImport_local()));
                list.add(l9.get());
            }
        }
        ws_aneti_historique l10=  ws_aneti_historepo.selectfirst("STARTUP-ACT");
        l10.setNumber(Anetidata_repo.countbydate(l10.getImport_local()));
        list.add(l10);
        Optional<ws_aneti_historique> l11=  ws_aneti_historepo.selectrest("STARTUP-ACT",l10.getId());
        if (l11.isPresent()) {
        l11.get().setNumber(Anetidata_repo.countbydate(l11.get().getImport_local()));
        list.add(l11.get());
        Optional<ws_aneti_historique> l12 = ws_aneti_historepo.selectrest("STARTUP-ACT", l11.get().getId());
        if (l12.isPresent()) {
            l12.get().setNumber(Anetidata_repo.countbydate(l12.get().getImport_local()));
            list.add(l12.get());
        }
    }
         // }
     //   if (d.getMonthValue()<4)
     //    {
      //       d.getYear()
        // }
        // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return list ;
    }
//----------TEST CHART1--------
    @GetMapping("/charttest")
    public CHARTSModel_1  tesstchart1 ()
    {

        long x1= (250 * 100)/ 1000;
        long x2 =(400 * 100)/1000;
        long x3= (200 * 100)/ 1000 ;
        long x4= (150* 100)/1000;
        CHARTSModel_1 ch = new CHARTSModel_1();
        ch.setKarpercentage(x1);
        ch.setCivppercentage(x2);
        ch.setScvpercentage(x3);
        ch.setStartuppercentage(x4);

        // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return ch ;
    }


}
