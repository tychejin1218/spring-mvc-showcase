package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.samples.mvc.simple.SimpleController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@GetMapping("/mapping/path")
	public String byPath() {
		return "Mapped by path!";
	}

	/*
	request.getContextPath()
	 - 웹 어플리케이션의 Context path를 리턴
	request.getRequestURI()
	 - 요청한 URI 정보를 리턴 (Context Path 이하의 나머지 부분을 의미) 
	request.getRequestURL()
	 - 요청한 URL 정보를 리턴
	*/

	// 요청 패턴 *(Asterisk)을 지정하여 핸들러에 매핑
	@GetMapping("/mapping/path/*")
	public String byPathPattern(HttpServletRequest request) {
		logger.info("request.getContextPath() : [{}] ", request.getContextPath());
		logger.info("request.getRequestURI() : [{}]", request.getRequestURI());
		logger.info("request.getRequestURL() : [{}]", request.getRequestURL());
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@GetMapping("/mapping/method")
	public String byMethod() {
		return "Mapped by path + method";
	}
	
	@GetMapping(path = "/mapping/parameter", params = "foo")
	public String byParameter() {
		logger.info("MappingController.byParameter()");
		return "Mapped by path + method + presence of query parameter!";
	}

	// 요청 파리미터의 특정 키 값을 제한하기 위해서는 params 속성을 사용
	@GetMapping(path = "/mapping/parameter", params = "!foo")
	public String byParameterNegation() {
		logger.info("MappingController.byParameterNegation()");
		return "Mapped by path + method + not presence of query parameter!";
	}
	
	// 제한한 특정 키 값이 많은 경우 많은 경우 배열로 지정
	@GetMapping(path = "/mapping/parameter", params = {"foo", "fruit"})
	public String byParameter01() {
		logger.info("MappingController.byParameter01()");
		return "Mapped by path + method + presence of query parameter!";
	}

	@GetMapping(path = "/mapping/header", headers = "FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@GetMapping(path = "/mapping/header", headers = "!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}

	@PostMapping(path = "/mapping/consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@GetMapping(path = "/mapping/produces", produces = MediaType.APPLICATION_JSON_VALUE)
	public JavaBean byProducesJson() {
		return new JavaBean();
	}

	@GetMapping(path = "/mapping/produces", produces = MediaType.APPLICATION_XML_VALUE)
	public JavaBean byProducesXml() {
		return new JavaBean();
	}

}
