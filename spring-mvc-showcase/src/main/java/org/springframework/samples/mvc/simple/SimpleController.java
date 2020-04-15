package org.springframework.samples.mvc.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@GetMapping("/simple")
	public String simple() {
		return "Hello world!";
	}
}

/*
@RestControlle
 - @Controller + @ResponseBody
 - @ResponseBody를 모든 메소드에서 적용합니다. 메소드의 반환 결과(문자열)를 JSON 형태로 반환합니다.
 
 @Controller 와 @RestController 의 차이 
 @Controller 
  - API와 view를 동시에 사용하는 경우에 사용합니다. API 서비스로 사용하는 경우는 @ResponseBody를 사용하여 객체를 반환합니다. view(화면)를 return 하는 것이  주목적입니다.
 @RestController 
  - view가 필요없는 API만 지원하는 서비스에서 사용합니다. (Spring 4.0.1부터 제공)
  - @RequestMapping 메서드가 기본적으로 @ResponseBody 포함합니다. data(json, xml 등) return이 주목적입니다.
  - @RestController = @Controller + @ResponseBody
*/

/*
@GetMapping
 - @RequestMapping(method = RequestMethod.GET) 의 축약형으로 사용합니다.  (Spring 4.3.0 부터 제공)
*/