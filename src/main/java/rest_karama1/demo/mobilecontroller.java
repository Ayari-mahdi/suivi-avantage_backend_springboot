package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//*******************************  payment WEB AND MOBILE   *************************
@RestController
@CrossOrigin(origins = "*")
public class mobilecontroller {

    @Autowired
    private repository2 repository2 ;

    @Autowired
    private repository6 repository6 ;
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
    public  List<doss_avgass> searchemployeesparemployer(@PathVariable String numaffiliation)
    {
        String y1=numaffiliation.substring(0,6);
        String y2=numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2= Long.parseLong(y2);
        return repository6.search2(x1,x2);
    }

    //*******************  RETURN LIST OF EMPLOYEE PER EMPLOYER by date year *********************
    @GetMapping("/listemployeesperemployer/{numaffiliation}/{trim}/{year}")
    public  List<doss_avgass> searchemployeebydate(@PathVariable String numaffiliation,@PathVariable char trim,@PathVariable String year) {
        String y1 = numaffiliation.substring(0, 6);
        String y2 = numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2 = Long.parseLong(y2);
        long Year = Long.parseLong(year);

        List<doss_avgass> result=new ArrayList<>() ;
        List<doss_avgass> employeelist = repository6.search2(x1, x2);
        employeelist.forEach((e) -> {
                    String month1 ="";
                    String month2="" ;
                    String day1="01" ;
                    String day2="" ;
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
                    int c2=  datedeb.compareTo(date2);
                    Date datefin = e.getDaa_dtfin();
                    int c3=  datefin.compareTo(date1);
                    int c4=  datefin.compareTo(date2);
                    if (c1>0 && c4<0)
                    {
                        result.add(e);
                    }
                    else if(c4 >0 && c3<0)
                    {
                        result.add(e);
                    }
                    else if (c1<0 && c2>0)
                    {
                        result.add(e);
                    }


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
        );

 return  result;

    }
    //*******************  ADD EMPLOYEE SALARY  *********************
    @PostMapping("/employeeSalary/{numMat}/{numcle}/{salary}")
    public  void employeeSalary(@PathVariable String numMat,@PathVariable String numcle,@PathVariable Long salary)
    {
        long x1 = Long.parseLong(numMat);
        long x2= Long.parseLong(numcle);
        doss_avgass employee =  repository6.searchemployee(x1,x2);
     employee.getDaa_dtdeb();

        employee.setDaa_salaire(salary);
    }




}
