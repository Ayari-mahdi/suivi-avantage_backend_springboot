package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

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
    public CHARTSModel_2  aadvantagenumbershisto () throws ParseException {

        List<ws_aneti_historique> list = new ArrayList<>();

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate d = localDateTime.toLocalDate();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        CHARTSModel_2 ch2 = new CHARTSModel_2();

        /////////////-------------
        c.setTime(new Date());
        String d00 = sdf.format(c.getTime());
        ch2.setDate1(d00);

        c.add(Calendar.DATE, -15);
        String d01 = sdf.format(c.getTime());
        ch2.setDate2(d01);

        c.add(Calendar.DATE, -15);
        String d02 = sdf.format(c.getTime());
        ch2.setDate3(d02);

        c.add(Calendar.DATE, -15);
        String d03 = sdf.format(c.getTime());
        ch2.setDate4(d03);

        c.add(Calendar.DATE, -15);
        String d04 = sdf.format(c.getTime());
        ch2.setDate5(d04);
        ////////////////-------------------
        LocalDate d1 = LocalDate.parse(d01);
        LocalDate d2 = LocalDate.parse(d02);
        LocalDate d3 = LocalDate.parse(d03);
        LocalDate d4 = LocalDate.parse(d04);
        ch2.setDate1karama(Anetidata_repo.count1("KARAMA"));
        ch2.setDate2karama(Anetidata_repo.countbetweendate("KARAMA",d1));
        ch2.setDate3karama(Anetidata_repo.countbetweendate("KARAMA",d2));
        ch2.setDate4karama(Anetidata_repo.countbetweendate("KARAMA",d3));
        ch2.setDate5karama(Anetidata_repo.countbetweendate("KARAMA",d4));

        ch2.setDate1civp(Anetidata_repo.count1("CIVP"));
        ch2.setDate2civp(Anetidata_repo.countbetweendate("CIVP",d1));
        ch2.setDate3civp(Anetidata_repo.countbetweendate("CIVP",d2));
        ch2.setDate4civp(Anetidata_repo.countbetweendate("CIVP",d3));
        ch2.setDate5civp(Anetidata_repo.countbetweendate("CIVP",d4));


        ch2.setDate1scv(Anetidata_repo.count1("SCV"));
        ch2.setDate2scv(Anetidata_repo.countbetweendate("SCV",d1));
        ch2.setDate3scv(Anetidata_repo.countbetweendate("SCV",d2));
        ch2.setDate4scv(Anetidata_repo.countbetweendate("SCV",d3));
        ch2.setDate5scv(Anetidata_repo.countbetweendate("SCV",d4));

        ch2.setDate1startupact(Anetidata_repo.count1("STARTUP-ACT"));
        ch2.setDate2startupact(Anetidata_repo.countbetweendate("STARTUP-ACT",d1));
        ch2.setDate3startupact(Anetidata_repo.countbetweendate("STARTUP-ACT",d2));
        ch2.setDate4startupact(Anetidata_repo.countbetweendate("STARTUP-ACT",d3));
        ch2.setDate5startupact(Anetidata_repo.countbetweendate("STARTUP-ACT",d4));
        ////////////////-------------------
      //    ws_aneti_historique l=  ws_aneti_historepo.selectfirst("KARAMA");
   //      l.setNumber(Anetidata_repo.countbydate(l.getImport_local()));
     //     list.add(l);

     //    Optional<ws_aneti_historique> l2=  ws_aneti_historepo.selectrest("KARAMA",l.getId());
   //      if (l2.isPresent()){
   //          l2.get().setNumber(Anetidata_repo.countbydate(l2.get().getImport_local()));
     //        list.add(l2.get());
     //
     //        Optional<ws_aneti_historique>  l3=  ws_aneti_historepo.selectrest("KARAMA",l2.get().getId());
     //        if (l3.isPresent()) {
    //            l3.get().setNumber(Anetidata_repo.countbydate(l3.get().getImport_local()));
     //            list.add(l3.get());
   //          }
    //     }


    //    ws_aneti_historique l4=  ws_aneti_historepo.selectfirst("CIVP");
   //     l4.setNumber(Anetidata_repo.countbydate(l4.getImport_local()));
  //      list.add(l4);
   //     Optional<ws_aneti_historique>   l5=  ws_aneti_historepo.selectrest("CIVP",l4.getId());
    //    if (l5.isPresent()) {
  //          l5.get().setNumber(Anetidata_repo.countbydate(l5.get().getImport_local()));
  //          list.add(l5.get());
  //          Optional<ws_aneti_historique> l6 = ws_aneti_historepo.selectrest("CIVP", l5.get().getId());
  //          if (l6.isPresent()) {
  //              l6.get().setNumber(Anetidata_repo.countbydate(l6.get().getImport_local()));
   //             list.add(l6.get());
    //        }
    //    }
      //  ws_aneti_historique l7=  ws_aneti_historepo.selectfirst("SCV");
   //     l7.setNumber(Anetidata_repo.countbydate(l7.getImport_local()));
  //      list.add(l7);
   //     Optional<ws_aneti_historique> l8=  ws_aneti_historepo.selectrest("SCV",l7.getId());
  //      if (l8.isPresent()) {
   //         l8.get().setNumber(Anetidata_repo.countbydate(l8.get().getImport_local()));
   //         list.add(l8.get());
  //          Optional<ws_aneti_historique> l9 = ws_aneti_historepo.selectrest("SCV", l8.get().getId());
   //         if (l9.isPresent()) {
  //              l9.get().setNumber(Anetidata_repo.countbydate(l9.get().getImport_local()));
  //              list.add(l9.get());
  //          }
  //      }
   //     ws_aneti_historique l10=  ws_aneti_historepo.selectfirst("STARTUP-ACT");
   //     l10.setNumber(Anetidata_repo.countbydate(l10.getImport_local()));
    //    list.add(l10);
    //    Optional<ws_aneti_historique> l11=  ws_aneti_historepo.selectrest("STARTUP-ACT",l10.getId());
    //    if (l11.isPresent()) {
     //   l11.get().setNumber(Anetidata_repo.countbydate(l11.get().getImport_local()));
      //  list.add(l11.get());
      //  Optional<ws_aneti_historique> l12 = ws_aneti_historepo.selectrest("STARTUP-ACT", l11.get().getId());
     //   if (l12.isPresent()) {
     //       l12.get().setNumber(Anetidata_repo.countbydate(l12.get().getImport_local()));
   //         list.add(l12.get());
   //     }
   // }

        return ch2;
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
    // ----------------------------------third CHART --------------------------------

    @GetMapping("/thirdchart")
    public CHARTSModel_3  numbermalefemale()
    {

        long kar1=  Anetidata_repo.countsex("KARAMA","MASCULIN");
        long civp1= Anetidata_repo.countsex("CIVP","MASCULIN");
        long scv1= Anetidata_repo.countsex("SCV","MASCULIN");
        long startup1= Anetidata_repo.countsex("STARTUP-ACT","MASCULIN");

        long kar2=  Anetidata_repo.countsex("KARAMA","FEMININE");
        long civp2= Anetidata_repo.countsex("CIVP","FEMININE");
        long scv2= Anetidata_repo.countsex("SCV","FEMININE");
        long startup2= Anetidata_repo.countsex("STARTUP-ACT","FEMININE");
        CHARTSModel_3 ch = new CHARTSModel_3();
        ch.setKarmale(kar1);
        ch.setKarfemale(kar2);
        ch.setCivpmale(civp1);
        ch.setCivpfemale(civp2);
        ch.setScvmale(scv1);
        ch.setScvfemale(scv2);
        ch.setStartupactmale(startup1);
        ch.setStartupactfemale(startup2);

        // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return ch ;
    }

    // ----------------------------------Forth CHART :PIE CHART--------------------------------
    @GetMapping("/forthchart")
    public CHARTSModel_1  faultyandnotyet ()
    {
        long totalnumber= Anetidata_repo.count();
        long done=  Anetidata_repo.count2();
        long notyet= Anetidata_repo.count21();
        long faulty= Anetidata_repo.count22();

        long x1= (done * 100)/ totalnumber ;
        long x2 =(notyet * 100)/ totalnumber ;
        long x3= (faulty * 100)/ totalnumber ;
        CHARTSModel_1 ch = new CHARTSModel_1();
        ch.setKarpercentage(x1);
        ch.setCivppercentage(x2);
        ch.setScvpercentage(x3);
        // repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
        return ch ;
    }
}
