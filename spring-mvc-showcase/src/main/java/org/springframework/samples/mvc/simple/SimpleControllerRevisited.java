package org.springframework.samples.mvc.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleControllerRevisited {

	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

	//@GetMapping(path="/simple/revisited", headers="Accept=text/plain")
	//@GetMapping(value = "/simple/revisited", consumes = "application/json")
	@GetMapping(value = "/simple/revisited", produces = "application/json")
	public String simple() {
		logger.info("SimpleControllerRevisited.simple");
		return "Hello world revisited!";
	}

}

/*
Content-Type Header 
 - Http request를 통해 data가 전달될 때, 데이터의 종류를 친절하게 가이드 해 줄수 있는 정보입니다. 즉, Content-Type Header을 통해 해당 request에 대한 data(body)에 대한 동작을 제어 할 수 있습니다.

Http 요청과 이를 다루기 위한 Controller 의 메소드를 연결하는 어노테이션
Http Method 와 연결하는 방법
 - @RequestMapping(value="/users", method=RequestMethod.POST)
 - From Spring 4.3 version (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping)
Http 특정 헤더와 연결하는 방법
 - @RequestMapping(method = RequestMethod.GET, headers = "content-type=application/json")
Http Parameter 와 연결하는 방법
 - @RequestMapping(method = RequestMethod.GET, params = "type=raw")
Content-Type Header 와 연결하는 방법
 - @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
Accept Header 와 연결하는 방법
 - @RequestMapping(method = RequestMethod.GET, produces = "application/json")


*/