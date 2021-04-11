package rest_karama1.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class facturationcontroller {
    @Autowired
    private repository10 repository10;
    @GetMapping("/facturation")
    public List<facturation> fact(){
        return repository10.findAll();
    }

    @GetMapping("/facturation/{numemp}")
    public Optional<List<facturation>> searchfact(@PathVariable long numemp){
        return  repository10.search(numemp);
    }


}
