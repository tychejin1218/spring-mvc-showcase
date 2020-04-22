package org.springframework.samples.mvc.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.mvc.mapping.JavaBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/response", method=RequestMethod.GET)
public class ResponseController {

	@GetMapping("/annotation")
	public String responseBody() {
		return "The String ResponseBody";
	}

	@GetMapping("/charset/accept")
	public String responseAcceptHeaderCharset() {
		return "안녕 세상아! (\"Hello world!\" in Korea)";
	}

	@GetMapping(value="/charset/produce", produces="text/plain;charset=UTF-8")
	public String responseProducesConditionCharset() {
		return "안녕 세상아! (\"Hello world!\" in Korea)";
	}

	/*
	ResponseEntitys
	 - @ResponseBody 어노테이션과 같은 의미로, ResponseEntity를  return Type으로 지정하면 JSON (default) 또는 Xml Format으로 결과를 응답합니다.
	 - ResponseEntity를 사용하여 응답되는 Response의 Header의 HTTP Status Code를 직접 제어할 수 있습니다.
     - body()에 담겨질 객체는 Json 또는 Xml Format으로 응답할 수 있습니다.
	*/		
	@GetMapping("/entity/status")
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}

	@GetMapping("/entity/headers")
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/entity/test")
	public ResponseEntity<Object> responseEntityTest() {	
		JavaBean JavaBean = new JavaBean();
		return ResponseEntity.status(HttpStatus.OK).body(JavaBean);
	}

}
