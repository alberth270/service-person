package com.everis.proyect.controller;

import com.everis.proyect.entity.Person;
import com.everis.proyect.services.PersonService;
import io.reactivex.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/core")
public class PersonController {
  @Autowired
  PersonService service;
  private final Logger logger = LoggerFactory.getLogger(getClass().getName());
  /***
   * @author abancesa
   * @param documento
   * @return
   * @throws Exception 
   */
  
  @GetMapping("/persons")
  public Single<Person> getDocumento(@RequestParam(value = "documentNumber") 
      String documento) throws Exception {
    logger.info("documento: " + documento);
    try {
      logger.info(documento);
      return service.findbyDocumento(documento);
    } catch (Exception e) {
      logger.info(e.getMessage());
      return Single.just(new Person(0L, e.getMessage(), false, false));
    }
  }
  
/***
 * 
 * @param person
 * @param documentNumber
 * @return
 * @throws Exception
 */
  
  @PutMapping("/acualiza/reniec/{documentNumber}")
  public Single<Person> putPerson(@RequestBody Person person, @PathVariable String documentNumber)
      throws Exception {
    try {
      logger.info("entro a putPerson con valor: ${documentNumber}");
      return service.update(documentNumber, person);
    } catch (Exception e) {
      logger.info(e.getMessage());
      return Single.just(new Person(0L, e.getMessage(), true, true));
    }
  }
}