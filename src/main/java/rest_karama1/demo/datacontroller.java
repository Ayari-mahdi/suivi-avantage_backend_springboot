package rest_karama1.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rest_karama1.demo.Spring_Security_Jwt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "*")
public class datacontroller {
   @Autowired
    private RestTemplate restTemplate;

   @Autowired
   private ParsingService parsingService;

   @Autowired
   private repository repository;

   @Autowired
   private repository2 repository2 ;

   @Autowired
   private repository3 repository3 ;

   @Autowired
   private repository4 repository4 ;

   @Autowired
   private repository5 repository5;

   @Autowired
   private repository6 repository6;

   @Autowired
   private repossitory7 repository7;

   @Autowired
   private repository8 repository8;

    @Autowired
    private repository9 repository9;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CNSS_agents_repo agents_repo;

    @Autowired
    private agents_roles_repo agents_roles_repo;

    @Autowired
    private myUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private JavaMailSender javaMailSender;



    @RequestMapping(value = "/authenticate",method =RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody authenticationrequest authenticationrequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationrequest.getUsername(),authenticationrequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("incorrect username and password",e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationrequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new authenticationresponse(jwt));
    }

    //********************************************************************************************* REGISTRATION
     @PostMapping("/registration")
    public void addagent(@RequestBody CNSS_agents CNSS_agents){

           if (agents_repo.findByUserName(CNSS_agents.getUsername()).isEmpty()) {
               CNSS_agents user = new CNSS_agents();
               user.setUsername(CNSS_agents.getUsername());
               user.setPassword(CNSS_agents.getPassword());
               user.setRoles(CNSS_agents.getRoles());
               agents_repo.saveAndFlush(user);
           }
           else {
           throw new ResourceNotFoundException("User name exist");
           }
     }
    //********************************************************************************************* ADD NEW ANETI ADVANTAGE
    @PostMapping("/add-aneti-avg")
    public void addadvantge(@RequestBody aneti_avg aneti_avg){

        aneti_avg newavantage = new aneti_avg();
        newavantage.setAvn_codav(aneti_avg.getAvn_codav());
        newavantage.setCode(aneti_avg.getCode());
        newavantage.setLib(aneti_avg.getLib());
        repository8.saveAndFlush(newavantage);
    }

    //********************************************************************************************* ADD NEW ROLE
    @PostMapping("/add-role")
    public void addadvantge(@RequestBody agents_roles agents_role){

        agents_roles newrole = new agents_roles();
        newrole.setRolename(agents_role.getRolename());
        newrole.setRolecode(agents_role.getRolecode());
        agents_roles_repo.saveAndFlush(newrole);
    }
    //********************************************************************************************* GET EMPLOYERS ADVANTAGES FILES
   @GetMapping ("/get_avn")
   public List<dossieravantage> get_avn(){
      return repository2.findAll();

   }
    //********************************************************************************************* CREATE FILES FOR ALL DATA
   @PostMapping(value = {"/post_avn/{numaff1}/{cin}/{typavg}","/post_avn"})
   public void WS_aneti(@PathVariable(required = false)String numaff1,@PathVariable(required = false)String cin,@PathVariable(required = false)String typavg)
           {

       ArrayList<data_karama> emp = new ArrayList<>();
       ArrayList<data_karama> ass = new ArrayList<>();
       //Map<Long, Boolean> resultss = new HashMap<>();
       //final long[] bo = {0};
       //Map<String,ArrayList<data_karama>> results = new HashMap<>();
       String result2 = "";
       String result1 = "";
       AtomicLong h = new AtomicLong();
       //parse date
       DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       //localdate
       Date input = new Date();
       LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       if (numaff1 == null && cin == null)
       {
           List<ws_aneti_historique> list2 = repository9.findAll();
           list2.forEach((rows)->{
               rows.setBoo_creation_dossier(1L);
               rows.setCreation_dossier(66324L);
               rows.setNumber(1L);
           });



          List<data_karama> list = repository4.findAll();
           list.forEach((data)->{
            aneti_avg data2= repository8.codavn(data.getType_contrat());
            String codavg=  data2.getCode();

            // if (data.getEmp_exist()==null )
           // {
             String v1 = data.getNumero_affiliation();

             /////--------------------------SAME SAME SAME SAME SAME--------------------------
             // check if there is no anomalie , numm aff only digits and length == 8
             if(v1.matches("\\d+") && v1.length()==8)
             {
             String v11= v1.substring(0,6);
             String v12=v1.substring(6);
             long numaf = Long.parseLong(v11);
             long numcle = Long.parseLong(v12);
             // check iff employer has a record in "dossieravantage"
             h.set(repository2.countt(numaf,numcle,codavg));
          //CREATION DOSSIEER AVANTAGE PAR EMPLOYEUR---------------------------

             if (h.get() == 0)
             {
                 //checking if there is an employer has an emp_mat = numaf
                 boolean boo = repository3.brcod(numaf).isPresent();
                // if yes create dossieravanatge for this employer
                 if (boo ) {
                     long brcod = repository3.brcod(numaf).get();
                     data.setEmp_exist(1L);
                     data.setBur_cod(brcod);
                     dossieravantage davn = new dossieravantage();
                     Date sysdate = repository2.currentdate();
                     davn.setEmp_mat(numaf);
                     davn.setEmp_cle(numcle);
                     //---------
                     //List<Optional<employeur>> op = new ArrayList<>();
                     //op.add(Optional.ofNullable(repository3.findById(numaf).orElseThrow(() -> new ResourceNotFoundException("employeur not found "))));
                     // repository3.brcod(numaf);
                     //repository3.brcodd(op.get(0).get());
                     //op.get(0).isPresent();
                     //----------
                     davn.setBur_cod(brcod);
                     //count number of br_cod in table advantages
                     long nb = repository2.countByBur_cod(brcod);
                      nb++;
                     long count_br = nb;
                     String xt = String.valueOf(count_br);
                     String xp = "0000";
                     if (count_br < 10) {
                         xp = "0" + "0" + "0" + xt;
                     } else if (count_br < 100) {
                         xp = "0" + "0" + xt;
                     } else if (count_br < 1000) {
                         xp = "0" + xt;
                     }
                     String k4 = String.valueOf(davn.getBur_cod());
                     String k5 = String.valueOf(date.getYear());
                     String k6 = k4 + k5 + xp;
                     //long k7 = Long.valueOf(k6).longValue();
                     long k7 = Long.parseLong(k6);
                     davn.setDoa_refdoss(k7);
                     //aneti_avg data2= repository8.codavn(data.getType_contrat());
                     davn.setAvn_codav(data2.getAvn_codav());
                     //davn.setAvn_codav("20190542CK");
                     //davn.setDoa_dtedep(sysdate);
                     davn.setDoa_dtedep(date);
                     Date date1 = null;
                     try {
                         date1 = format.parse(data.getDate_debut());

                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                     davn.setDoa_dtedeb(date1);
                     Date date2 = null;
                     try {
                         date2 = format.parse(data.getDate_finprevesionnelle());
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                     //  Object parts = dt.getDate_finprevesionnelle().split("-");
                     davn.setDoa_dtefin(date2);
                     davn.setDoa_obs("WEB SERVICE ANETI" + ' ' + date);
                     davn.setDoa_agent(66324L);
                     // davn.setDoa_dtdresit(sysdate);)
                     davn.setDoa_dtdresit(date);
                     davn.setDoa_reffisc(data.getMatricule());
                     repository2.saveAndFlush(davn);
                 }
                 else {
                      //repository3.brcod(numaf).orElseThrow(()-> new ResourceNotFoundException("employeur not found "));
                     emp.add(data);
                 }
             }

             else {
                 //if employer already have a record then we gonna change emp_exist value to 1
                 data.setEmp_exist(1L);
                 data.setBur_cod(repository3.brcod(numaf).get());
                 repository4.saveAndFlush(data) ;
             }
  //CREATION DOSSIER AVANTAGE PAR ASS ------------------------------------------
           if (!repository5.search_ben(data.getCin()).isEmpty())
           { if ( repository5.search_ben(data.getCin()).get(0).isPresent() && repository3.brcod(numaf).isPresent())
           {

                   long brcod = repository3.brcod(numaf).get();
                   data.setAss_exist(1L);
                   data.setBur_cod(brcod);
                beneficiaire ben = repository5.search_ben(data.getCin()).get(0).get();
                long v= repository6.search_dossavgass(ben.getAss_mat());
                      if (v==0) {
                doss_avgass davgass = new doss_avgass();
                davgass.setAss_mat(ben.getAss_mat());
                davgass.setAss_cle(ben.getAss_cle());
                davgass.setEmp_mat(numaf);
                davgass.setEmp_cle(numcle);
                davgass.setBur_cod(brcod);
                davgass.setDoa_refdos(repository2.geterfdoss(numaf));
                Date datedb = null;
                try {
                    datedb = format.parse((data.getDate_debut()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                davgass.setDaa_dtdeb(datedb);

                Date datefinprv = null;
                try {
                    datefinprv = format.parse((data.getDate_finprevesionnelle()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                davgass.setDaa_dtfin(datefinprv);
                davgass.setDaa_cin(Long.parseLong(data.getCin()));
                davgass.setDaa_dtsais(date);
                davgass.setDaa_numref(data.getReference_accord());
                davgass.setDaa_nom(ben.getBen_nom());
                davgass.setDaa_prenom(ben.getBen_prenom());
                davgass.setDaa_agent(66324L);
                davgass.setDaa_flgper(1);
                repository6.saveAndFlush(davgass);
            }
               }}
               else
                   {
                       ass.add(data);

                   }
             //-----------------------------------------------------------------
            }
           }
           //}
         );

           list2.forEach((rows)->{
               rows.setNumber(0L);
           });
         }

       else
           {

               assert numaff1 != null;
               String v11= numaff1.substring(0,6);
               String v12= numaff1.substring(6);
               long numaf = Long.parseLong(v11);
               long numcle = Long.parseLong(v12);
               aneti_avg data2= repository8.codavn(typavg);
               String codavg=  data2.getCode();
               h.set(repository2.countt(numaf,numcle,codavg));
               //CREATION DOSSIEER AVANTAGE PAR EMPLOYEUR---------------------------

               data_karama data = repository4.findbynumaff(numaff1,cin,typavg);
               if (h.get() == 0)
               {
                   boolean boo = repository3.brcod(numaf).isPresent();
                   //resultss.put(bo[0],boo);
                   // bo[0]++ ;
                   if (boo ) {
                       data.setEmp_exist(1L);
                       long brcod = repository3.brcod(numaf).get();

                       data.setBur_cod(brcod);
                       dossieravantage davn = new dossieravantage();
                       Date sysdate = repository2.currentdate();
                       davn.setEmp_mat(numaf);
                       davn.setEmp_cle(numcle);
                       //---------
                       //List<Optional<employeur>> op = new ArrayList<>();
                       //op.add(Optional.ofNullable(repository3.findById(numaf).orElseThrow(() -> new ResourceNotFoundException("employeur not found "))));
                       // repository3.brcod(numaf);
                       //repository3.brcodd(op.get(0).get());
                       //op.get(0).isPresent();
                       //----------
                       davn.setBur_cod(repository3.brcod(numaf).get());
                       //count number of br_cod in table advantages
                       long nbb = repository3.brcod(numaf).get();
                       long nb = repository2.countByBur_cod(nbb);
                       nb++;
                       long count_br = nb;
                       String xt = String.valueOf(count_br);
                       String xp = "0000";
                       if (count_br < 10) {
                           xp = "0" + "0" + "0" + xt;
                       } else if (count_br < 100) {
                           xp = "0" + "0" + xt;
                       } else if (count_br < 1000) {
                           xp = "0" + xt;
                       }
                       String k4 = String.valueOf(davn.getBur_cod());
                       String k5 = String.valueOf(date.getYear());
                       String k6 = k4 + k5 + xp;
                       //long k7 = Long.valueOf(k6).longValue();
                       long k7 = Long.parseLong(k6);
                       davn.setDoa_refdoss(k7);
                       //davn.setAvn_codav("20190542CK");
                      // aneti_avg data2= repository8.codavn(data.getType_contrat());
                       davn.setAvn_codav(typavg);

                       //davn.setDoa_dtedep(sysdate);
                       davn.setDoa_dtedep(date);
                       Date date1 = null;
                       try {
                           date1 = format.parse(data.getDate_debut());
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                       davn.setDoa_dtedeb(date1);
                       Date date2 = null;
                       try {
                           date2 = format.parse(data.getDate_finprevesionnelle());
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                       //  Object parts = dt.getDate_finprevesionnelle().split("-");
                       davn.setDoa_dtefin(date2);
                       davn.setDoa_obs("web SERVICE ANETI" + ' ' + date);
                       davn.setDoa_agent(66324L);
                       // davn.setDoa_dtdresit(sysdate);
                       davn.setDoa_dtdresit(date);
                       davn.setDoa_reffisc(data.getMatricule());
                       repository2.saveAndFlush(davn);
                   }
                   else {
                       //repository3.brcod(numaf).orElseThrow(()-> new ResourceNotFoundException("employeur not found "));
                       result2 = "employer doesnt exist";
                       emp.add(data);
                   }
               }
               else {

                  data.setEmp_exist(1L);
                  data.setBur_cod(repository3.brcod(numaf).get());
                  repository4.saveAndFlush(data);


               }
               //CREATION DOSSIER AVANTAGE PAR ASS ------------------------------------------
               if (!repository5.search_ben(data.getCin()).isEmpty())
               { if ( repository5.search_ben(data.getCin()).get(0).isPresent() && repository3.brcod(numaf).isPresent())
               {
                   data.setAss_exist(1L);
                   long brcod = repository3.brcod(numaf).get();

                   data.setBur_cod(brcod);
                   beneficiaire ben = repository5.search_ben(data.getCin()).get(0).get();
                   long v= repository6.search_dossavgass(ben.getAss_mat());
                   if (v==0) {
                       doss_avgass davgass = new doss_avgass();
                       davgass.setAss_mat(ben.getAss_mat());
                       davgass.setAss_cle(ben.getAss_cle());
                       davgass.setEmp_mat(numaf);
                       davgass.setEmp_cle(numcle);
                       davgass.setBur_cod(repository3.brcod(numaf).get());
                       davgass.setDoa_refdos(repository2.geterfdoss(numaf));
                       Date datedb = null;
                       try {
                           datedb = format.parse((data.getDate_debut()));
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                       davgass.setDaa_dtdeb(datedb);
                       Date datefinprv = null;
                       try {
                           datefinprv = format.parse((data.getDate_finprevesionnelle()));
                       } catch (ParseException e) {
                           e.printStackTrace();
                       }
                       davgass.setDaa_dtfin(datefinprv);
                       davgass.setDaa_cin(Long.parseLong(data.getCin()));
                       davgass.setDaa_dtsais(date);
                       davgass.setDaa_numref(data.getReference_accord());
                       davgass.setDaa_nom(ben.getBen_nom());
                       davgass.setDaa_prenom(ben.getBen_prenom());
                       davgass.setDaa_agent(66324L);
                       davgass.setDaa_flgper(1);
                       repository6.saveAndFlush(davgass);
                   }
                   repository4.saveAndFlush(data);
               }
               else {
               result2 = "employer doesnt exist";
               }

               }
               else
               {
                   ass.add(data);
                   result1 = "beneficiairie doesnt exist";

               }

           }
      // results.put("beneficiare doesnt exist yet",ass);
      // results.put("employeur doesnt exist yet ",emp);
       String res= result2+" "+result1;
       //return res ;
   }

   //********************************************************************************************* GET ALL DATA


    //********************************************************************************************* GET ALL CNSS DESKS
   @GetMapping("/getbrcod")
   public List<bureau> get_bur()
   {
       return   repository7.findAll();
   }
    //********************************************************************************************* GET ALL ANETI ADVANTAGES
   @GetMapping("/getavn")
   public List<aneti_avg> getavgcod(){

       return   repository8.findAll();
   }
    //********************************************************************************************* GET IMPORTS TRACES
   @GetMapping("/gethistorique")
   public List<ws_aneti_historique> gethisto(){

        return  repository9.findAllByOrderByIdAsc();
    }
//***************************************************************************************************
    @GetMapping("/get")
    public List<data_karama> get_angular(){

        //repository4.findAll();
        return    repository4.findbyavg();
    }
//************************************************************************** send email
    @GetMapping("/getfaulty")
    public List<data_karama> get_faulty(){
        System.out.println("sending email");
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("ayarii.mahdii@gmail.com");
        simpleMailMessage.setTo("yasmine.bechiekh@gmail.com");
        simpleMailMessage.setSubject("test from spring boot ");
        simpleMailMessage.setText("hi there  ");
        javaMailSender.send(simpleMailMessage);
        System.out.println("email sent");
        return repository4.findfaulty();
    }
    //**********************************************

    //***********************
    @GetMapping("/getnotyetregistered")
    public List<data_karama> get_notyetregistered(){

        return repository4.findnotyetregistered();
    }
    //*************

   //********************************************************************************************** SEARCH IN ALL DATA LIST
   @GetMapping(value={  "/get/{typavg}/{burcod}","/get/{typavg}/{burcod}/{cin}"})
   public List<data_karama> recherche
   ( @PathVariable(required = false)String typavg ,@PathVariable long burcod,@PathVariable(required = false)String cin)
   {List<data_karama> list = new ArrayList<>();
       if (cin == null )
        {
         list =  repository4.findBy_burcod(typavg,burcod);
        }
       else
       {
           list =repository4.findBy_burcod_cin(typavg,burcod,cin);
       }
     //  else
    //  {
        //   list = repository4.findBy_burcod_numaff(burcod,numero_affiliation,cin);
     //  }

     //  else if (numero_affiliation == null)
      // {
     //      list = repository4.findBy_burcod_numaff(burcod,numero_affiliation,cin);
      // }

   //    else
    //   {
   //           list = repository4.findByall(burcod, cin, numero_affiliation);
    //   }

       return   list;
   }
    //*************************************************************************** IMPORT FROM ANETI APIs BY TYPE AND DATE OF  ADVANTAGE
   @PostMapping("/rest_aneti/{dateavantage}/{typeavantage}")
    public void getall(@PathVariable String dateavantage,@PathVariable String typeavantage) throws JsonProcessingException {
       Date input = new Date();
      // LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
       ///
       LocalDateTime localDateTime = LocalDateTime.now();
       LocalDate date = localDateTime.toLocalDate();
       ///
       final long[] id_list_regelement = {0};
       //String url = "http://localhost:8080/api";
       String url ="http://10.222.6.3/CNSS/beneficiaire_dt.php?date="+ dateavantage+"&programme="+typeavantage;
        /////////fake_karama list = parsingService.parse(url);
       aneti_avg aneti_avg1 =repository8.codavn(typeavantage);

       ResponseEntity<String> t = restTemplate.getForEntity(url,String.class);
       /////// String y =  t.getBody();
      // fake_karama h = new fake_karama();
       ObjectMapper mapper = new ObjectMapper();
       /////String root1 = mapper.readValue(url,String.class);
       String g = String.valueOf(t.getBody());
       //System.out.println(g);
       System.out.println(g.substring(5));
       JsonNode root = mapper.readTree(g.substring(5));
       //JsonNode root = mapper.readTree(g);
       //////String result = root.path("result").textValue();
       //long numberColumns = root.path("numberColumns").longValue();
       //long numberLines = root.path("numberLines").longValue();
       //////h.setResult(result);
      // h.setNumberColumns(numberColumns);
      // h.setNumberLines(numberLines);
   ///////root.path("dataset")**********************************
       JsonNode dataset2 = root.path("dataset");
       //JsonNode dataset2 = root.path("dataset2");
      //  ArrayList<data_karama> ex1 = new ArrayList<>();
       final long[] lpp = {0};

//**************************************************************************
       ws_aneti_historique historique = new ws_aneti_historique();
       historique.setAgent(66324L);
       historique.setType_contrat(typeavantage);
       historique.setDate_import(dateavantage);

       LocalDate d = localDateTime.toLocalDate();
       historique.setImport_local(d);
       //long x = repository9.count();
       long x = repository9.selectmaxid();
     //  ws_aneti_historique lastone= repository9.search_histo_id(x);
      // long newid = lastone.getId()+1;
       historique.setId(x+1);
       repository9.saveAndFlush(historique);
     //***********************************************************************

   dataset2.forEach((e)->{
            data_karama j = new data_karama();

            if (lpp[0] == 0)
            {
                lpp[0]++;
                return;
            }

      String cin =  e.get(0).textValue();
            if(cin.length()==8){
              j.setCin(cin);
            }
            else {
                j.setEmp_exist(2L);
                j.setAss_exist(2L);
                j.setCin(cin);
            }
       j.setNom_prenom(e.get(1).textValue());
       j.setGenre(e.get(2).textValue());
       j.setType_contrat(e.get(3).textValue());
       j.setDate_debut(e.get(4).textValue());
       j.setDate_finprevesionnelle(e.get(5).textValue());
       j.setDate_fin_reelle(e.get(6).textValue());
       j.setSituation(e.get(7).textValue());
       j.setDate_situation(e.get(8).textValue());
       j.setMatricule(e.get(9).textValue());
       String numaffiliation= e.get(10).textValue();
      //  String st3="";
       if (numaffiliation.length()==9) {
           String st1 = numaffiliation.substring(0, 6);
           String st2 = numaffiliation.substring(7);

           j.setNumero_affiliation(st1+st2);
       }
       else if (numaffiliation.length()==0)
       {
           j.setNumero_affiliation("empty");
           j.setEmp_exist(2L);
           j.setAss_exist(2L);
       }
       else{
           j.setNumero_affiliation(numaffiliation);
           j.setEmp_exist(2L);
           j.setAss_exist(2L);
       }

       j.setReference_accord(e.get(11).textValue());
       j.setDate_accord(e.get(12).textValue());
       j.setRaison_sociale_entreprise(e.get(13).textValue());
       j.setNom_etablissement(e.get(14).textValue());
       j.setDate(date);
       Optional<data_karama> data = repository4.findbycin(j.getNumero_affiliation(), e.get(0).textValue(),aneti_avg1.getCode());

       if (data.isPresent())
       {
           j.setEmp_exist(data.get().getEmp_exist());
           j.setAss_exist(data.get().getAss_exist());
           //j.setBur_cod(data.get().getBur_cod());
       }
         j.setFrom_date(dateavantage);

         if (aneti_avg1.getCode().equals("KARAMA"))
         {
             JsonNode listreglements = e.get(15);
             ArrayList<dataset> ex = new ArrayList<>();
             final long[] lp = {0};
             listreglements.forEach((k) ->
             {
                 dataset l = new dataset();
                 if (lp[0] == 0) {
                     lp[0]++;
                     return;
                 }
                 l.setId(id_list_regelement[0]);
                 id_list_regelement[0]++;
                 l.setSituation_reglement(k.get(0).textValue());
                 l.setMois_reglement(k.get(1).textValue());
                 l.setAnnee_reglement(k.get(2).textValue());
                 l.setSalaire(k.get(3).textValue());
                 l.setMontant_verse(k.get(4).textValue());
                 ex.add(l);
             });
             j.setListe_reglements(ex);
         }
            //ex1.add(j);
         repository4.saveAndFlush(j);
            });
            //h.setDataset2(ex1);
        //----------------------------

       //////// fake_karama root2 = mapper2.readValue(y,fake_karama.class);
        /////////data_karama root3 = mapper2.readValue(y,data_karama.class);
      //////////  ArrayList<ArrayList<Object>> name2 = root2.getDataset2();
       /////// String name3 = root3.getCin();
      //////      System.out.println(t.getBody());
         ///////   System.out.println(dataset2);
       ///////     System.out.println(name2);
            /////System.out.println(name3);
           /////// System.out.println(first_dataset);
           ///// System.out.println(listreglements);
        /////h.setDataset2(name2);
        //-----------
      // System.out.println();
        //*****************************************************
        //fake_karama z=h ;
       // repository4.saveAndFlush(ex1);
       //return h;

   }
}
