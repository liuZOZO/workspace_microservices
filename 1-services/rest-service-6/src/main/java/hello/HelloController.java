package hello;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Autowired
	private RestTemplate restTemplate;

    @RequestMapping("/hello6")
    public Value hello6(HttpSession session, 
//    		@RequestHeader(value="Cookie") String cookies, 
    		@RequestParam(value="cal", defaultValue="50") String cal)  throws InterruptedException, ExecutionException{

        double cal2 = Math.abs(Double.valueOf(cal));
        log.info(String.valueOf(cal2));
        
        
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
			uid = UUID.randomUUID();
			session.setAttribute("uid", uid);
			session.setAttribute("current_cal", cal);
			log.info("--------session created 6-----------:" + uid + ":" + session.getAttribute("current_cal"));
		}else{
			log.info("--------session recoverred 6-----------:" + uid + ":" + session.getAttribute("current_cal"));
		}
		
		
//        log.info("cookies: " + cookies);
		log.info("session: " + session.getId());
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cookie", "SESSION=" + session.getId());
		ResponseEntity<Value> exchange = restTemplate.exchange("http://rest-service-3:16003/hello3?name=service-6&cal="+cal2, 
				HttpMethod.GET,new HttpEntity<Void>(headers), Value.class);
		Value value = exchange.getBody();
        
//        Value value = restTemplate.getForObject("http://rest-service-3:16003/hello3?name=service-6&cal="+cal2, Value.class);
        
		log.info(value.toString());
		return value;
    }
}

