package rest_karama1.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class mobilecontroller {

    @Autowired
    private repository2 repository2 ;

    @Autowired
    private repository6 repository6 ;

    @GetMapping("/search_employer/{numaffiliation}")
    public dossieravantage searchemployer(@PathVariable String numaffiliation){
        String y1=numaffiliation.substring(0,6);
        String y2=numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2= Long.parseLong(y2);
        return repository2.search(x1,x2).orElseThrow(()-> new ResourceNotFoundException("employer not found"));
    }
    @GetMapping("/listemployeesperemployer/{numaffiliation}")
    public  List<doss_avgass> searchemployeesparemployer(@PathVariable String numaffiliation){
        String y1=numaffiliation.substring(0,6);
        String y2=numaffiliation.substring(7);
        long x1 = Long.parseLong(y1);
        long x2= Long.parseLong(y2);
        return repository6.search2(x1,x2);
    }

}
