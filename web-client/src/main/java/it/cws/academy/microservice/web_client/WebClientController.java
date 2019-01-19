/**
 * 
 */
package it.cws.academy.microservice.web_client;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import it.cws.academy.microservice.model.Person;

/**
 * @author Dmitrij.colautti
 *
 */
@Controller
public class WebClientController {
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/zuul")
  public String handleRequestZuul(@RequestParam(value="id") int id, Model model) {
      //accessing hello-service
      List<ServiceInstance> instances = discoveryClient.getInstances("zuul-server");
      if (instances != null && instances.size() > 0) {
          ServiceInstance serviceInstance = instances.get(0);
          String url = serviceInstance.getUri().toString();
          url = url + "microservice/pers?id="+id;
          RestTemplate restTemplate = new RestTemplate();
          Person pers = restTemplate.getForObject(url, Person.class);
          model.addAttribute("msg", pers.getName());
          model.addAttribute("time", LocalDateTime.now());
      }
      return "hello-page";
  }
  
  @GetMapping("/micro")
  public String handleRequestMicro(@RequestParam(value="id") int id, Model model) {
      //accessing hello-service
      List<ServiceInstance> instances = discoveryClient.getInstances("microservice");
      if (instances != null && instances.size() > 0) {//todo: replace with a load balancing mechanism
          ServiceInstance serviceInstance = instances.get(0);
          String url = serviceInstance.getUri().toString();
          url = url + "/pers?id="+id;
          RestTemplate restTemplate = new RestTemplate();
          Person pers = restTemplate.getForObject(url, Person.class);
          model.addAttribute("msg", pers.getName());
          model.addAttribute("time", LocalDateTime.now());
      }
      return "hello-page";
  }
}