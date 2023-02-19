package application;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import library.MyService;

@SpringBootApplication(scanBasePackages = "library")
@RestController
public class DemoApplication {

  private final MyService myService;

  public DemoApplication(MyService myService) {
    this.myService = myService;
  }

  @GetMapping("/")
  public String home() {
    return myService.message();
  }

  @GetMapping("/12")
  public String multiple() {
	  String string = "";
	  for (int i = 0; i < 12; i++) {
		  string += myService.message();
	  }
	  return string;
  }
  
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
}