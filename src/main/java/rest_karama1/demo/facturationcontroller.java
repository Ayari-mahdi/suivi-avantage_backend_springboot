package rest_karama1.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class facturationcontroller {
    @Autowired
    private repository10 repository10;
    //********************************************************************************************* GET LIST OF INVOICES
    @GetMapping("/facturation")
    public List<facturation> fact(){
        return repository10.findAll();
    }
    //********************************************************************************************* GET LIST OF INVOICES BY EMPLOYER
    @GetMapping("/facturation/{numemp}/{ann}/{trim}")
    public List<facturation> searchfact(@PathVariable long numemp,@PathVariable long ann,@PathVariable long trim){
     // facturation list= repository10.search(numemp).map(x->x.get(0)).orElseThrow(()-> new ResourceNotFoundException("nt founddd"));
        List<facturation> list= repository10.search(numemp,ann,trim);
        if (repository10.search(numemp,ann,trim).isEmpty())
        {
           throw new ResourceNotFoundException("facturation not found for :"+numemp );
        }
 return list;


    }

}
