package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

//*******************************  payment WEB AND MOBILE   *************************
@RestController
@CrossOrigin(origins = "*")
public class mobilecontroller {

    @Autowired
    private repository2 repository2 ;

    @Autowired
    private repository6 repository6 ;

    @Autowired
    private test_payment_repo payment_repo;

    @Autowired
    private Complaintrepo complaintrepo;
    //******************* SEARCH IF EMPLOYER HAVE AN ADVANTAGE FILE *********************
    @GetMapping("/search_employer/{numaffiliation}")
    public dossieravantage searchemployer(@PathVariable String numaffiliation)
    {
        String y1=numaffiliation.substring(0,6);
        String y2=numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2= Long.parseLong(y2);
        return repository2.search(x1,x2).orElseThrow(()-> new ResourceNotFoundException("employer not found"));
    }
    //*******************  RETURN LIST OF EMPLOYEE PER EMPLOYER  *********************
    @GetMapping("/listemployeesperemployer/{numaffiliation}")
    public List<doss_avgass> searchemployeesparemployer(@PathVariable String numaffiliation)
    {
        String y1=numaffiliation.substring(0,6);
        String y2=numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2= Long.parseLong(y2);
        return repository6.search2(x1,x2).orElseThrow(()-> new ResourceNotFoundException("empty list"));
    }

    //*******************  RETURN LIST OF EMPLOYEE PER EMPLOYER by trim and  year *********************
    @GetMapping("/listemployeesperemployer/{numaffiliation}/{trim}/{year}")
    public  List<doss_avgass> searchemployeebydate(@PathVariable String numaffiliation, @PathVariable char trim, @PathVariable String year) {
        String y1 = numaffiliation.substring(0, 6);
        String y2 = numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2 = Long.parseLong(y2);
        //long Year = Long.parseLong(year);

        List<doss_avgass> result=new ArrayList<>() ;
        Optional<List<doss_avgass>> employeelist = repository6.search2(x1, x2);
        //employeelist.get().forEach((e)->......
        employeelist.ifPresent(doss_avgasses -> doss_avgasses.forEach((e) -> {
                    String month1 = "";
                    String month2 = "";
                    String day1 = "01";
                    String day2 = "";
                    if (trim == '1') {
                        month1 = "01";
                        month2 = "03";

                        day2 = "31";
                    }
                    if (trim == '2') {
                        month1 = "04";
                        month2 = "06";

                        day2 = "30";
                    }
                    if (trim == '3') {
                        month1 = "07";
                        month2 = "09";

                        day2 = "30";
                    }
                    if (trim == '4') {
                        month1 = "10";
                        month2 = "12";

                        day2 = "31";
                    }
                    String datex = year + '-' + month1 + '-' + day1;
                    String datey = year + '-' + month2 + '-' + day2;
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    try {
                        date1 = format.parse(datex);

                    } catch (ParseException x) {
                        x.printStackTrace();
                    }
                    Date date2 = null;
                    try {
                        date2 = format.parse(datey);

                    } catch (ParseException x) {
                        x.printStackTrace();
                    }

                    Date datedeb = e.getDaa_dtdeb();
                    int c1 = datedeb.compareTo(date1);
                    int c2 = datedeb.compareTo(date2);
                    Date datefin = e.getDaa_dtfin();
                    int c3 = datefin.compareTo(date1);
                    int c4 = datefin.compareTo(date2);
                    if (c1 > 0 && c2 < 0) {
                        result.add(e);
                    } else if (c3 > 0 && c4 < 0) {
                        result.add(e);
                    } else if (c1 < 0 && c2 < 0 && c3 > 0 && c4 > 0) {
                        result.add(e);
                    }


//result.add(c1);
//result.add(c2);
//result.add(c3);
//result.add(c4);
                    //  String debyear = datedeb.toString().substring(0,4);
                    //     long debYear = Long.parseLong(debyear);
                    //     String debmonth = datedeb.toString().substring(5,7);
                    //      long debMonth = Long.parseLong(debmonth);
                    //      String debday = datedeb.toString().substring(8,10);
                    //      long debDay = Long.parseLong(debday);
                    //      Date datefin = e.getDaa_dtfin();
                    //         String finyear = datedeb.toString().substring(0,4);
                    //      long finYear = Long.parseLong(finyear);
                    //     String finmonth = datedeb.toString().substring(5,7);
                    //    long finMonth = Long.parseLong(finmonth);
                    //     String finday = datedeb.toString().substring(8,10);
                    //     long finDay = Long.parseLong(finday);

                    //     if (Year >= debYear && Year <= finYear && debMonth < month2)  &&(finMonth< )) )
                    //      {
                    // if(finMonth >month1)
                    //             {
                    //                result.add(e);
                    //             }
                    //           }
                }
        ));

 return  result;

    }
    //*******************  ADD EMPLOYEE SALARY  *********************
    @PostMapping("/employeeSalary/{salaire}/{trim}/{year}/{avg}")
    public  void employeeSalary(@RequestBody doss_avgass payment,@PathVariable String salaire,
                                @PathVariable char trim, @PathVariable String year,@PathVariable String avg )
    {  // Date input = new Date();
       // LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        //long x1 = Long.parseLong(numMat);
        //long x2= Long.parseLong(numcle);
        //doss_avgass employee =  repository6.searchemployee(x1,x2);
    //    employee.getDaa_dtdeb();
        payment newpay = new payment();
        newpay.setNumemp(payment.getEmp_mat());
        newpay.setCleemp(payment.getEmp_cle());
        newpay.setNumass(payment.getAss_mat());
        newpay.setCleass( payment.getAss_cle());

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localdate = localDateTime.toLocalDate();
        newpay.setSalaire(salaire);
        newpay.setDtsaisisalaire(localdate);
        newpay.setTrim(trim);
        newpay.setYear(year);
        newpay.setAvg(avg);

        payment_repo.saveAndFlush(newpay);
        //////TEST
       //long x1=payment.getAss_mat();
        //long x2=payment.getAss_cle();
      //  doss_avgass employee =  repository6.searchemployee(x1,x2);
      //  long sa =Long.parseLong(salaire);
     //   employee.setDaa_salaire(sa);
        ////////
    }

    //*******************  Calculate EMPLOYEE SALARIES sum before and after percentage deduction *********************

    @GetMapping("/paymentemployer/{numaffiliation}/{trim}/{year}/{avg}")
    public  PayResultList searchemployeesbydate(@PathVariable String numaffiliation,
                                                    @PathVariable char trim, @PathVariable String year,@PathVariable String avg) {
        String y1 = numaffiliation.substring(0, 6);
        String y2 = numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2 = Long.parseLong(y2);
        //long Year = Long.parseLong(year);
        Optional<List<payment>> employeelist = payment_repo.searchemp(x1, x2,trim,year,avg);
        AtomicLong total = new AtomicLong();
        employeelist.ifPresent(payments ->
                    payments.forEach((e) -> {
                                long x = Long.parseLong(e.getSalaire());
                                total.set(total.get() + x);
                            }
                    )
        );

        PayResultList PrepayResult = new PayResultList();
        PrepayResult.setTotal(total.longValue());

        if (avg.equalsIgnoreCase("KARAMA"))
        {   long taux = 50;
            long t = (50 * total.longValue())/ 100;
            PrepayResult.setTaux(taux);
            PrepayResult.setFinalsum(t);
        }
        if (avg.equalsIgnoreCase("SCV"))
        {   long taux = 20;
            long t = (20 * total.longValue())/ 100;
            PrepayResult.setTaux(taux);
            PrepayResult.setFinalsum(t);
        }
        if (avg.equalsIgnoreCase("CIVP"))
        {   long taux = 35;
            long t = (35 * total.longValue())/ 100;
            PrepayResult.setTaux(taux);
            PrepayResult.setFinalsum(t);
        }
        if (avg.equalsIgnoreCase("STARTUP-ACT"))
        {   long taux = 20;
            long t = (20 * total.longValue())/ 100;
            PrepayResult.setTaux(taux);
            PrepayResult.setFinalsum(t);
        }
        return  PrepayResult;

    }

//-----------------------------------add complaints-------------------
@PostMapping("/addcomplaint")
public void add_complaint( @RequestBody Complaints complaint)
{
    Complaints com = new Complaints();
    com.setEmail(complaint.getEmail());
    long x = complaintrepo.selectmaxid();
    com.setId(x+1);
    com.setComment(complaint.getComment());
    com.setTypeofproblem(complaint.getTypeofproblem());
    com.setName(complaint.getName());
   complaintrepo.saveAndFlush(com);
}
    //-----------------------------------list of complaints-------------------
    @PostMapping("/addcomplaint")
    public List<Complaints> list_complaint( )
    {
        return complaintrepo.findAll();
    }

}
