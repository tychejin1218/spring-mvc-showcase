package org.springframework.samples.mvc.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.samples.mvc.simple.SimpleController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class RequestDataController {

	private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);

	/*
	@RequestParam
	 - HTTP GET 요청에 파리미터를 메서드의 파라미터로 전달 받을 때 사용합니다.
	 - @RequestParam(value = "foo", required = false, defaultValue = "bar") String foo
	 - value : 파리미터명
	 - required : 파라미터의 필수 여부 (기본 값은 true) - 값이 true일 때 요청 파리미터가 없거나 기본 값이 없으면 400에러 발생
	 - defaultValue : 파라미터가 없을 경우 기본 값을 설정
	*/

	/*@GetMapping("param")
	public String withParam(@RequestParam String foo) {
		logger.info("foo:[{}]", foo);
		return "Obtained 'foo' query parameter value '" + foo + "'";
	}*/

	/*@GetMapping("param")
	public String withParam(@RequestParam(value = "foo", required = true) String foo) {
		logger.info("withParam - foo:[{}]", foo);
		return "Obtained 'foo' query parameter value '" + foo + "'";
	}*/

	@GetMapping("param")
	public String withParam(@RequestParam(value = "foo", required = true, defaultValue = "bar") String foo) {
		logger.info("withParam - foo:[{}]", foo);
		return "Obtained 'foo' query parameter value '" + foo + "'";
	}

	@GetMapping("group")
	public String withParamGroup(JavaBean bean) {
		logger.info("JavaBean:[{}]", bean.toString());
		return "Obtained parameter group " + bean.toString();
	}

	/*
	@PathVariable
	 - URI의 일부를 메서드의 파라미터로 전달 받을 때 사용합니다.
	*/	
	@GetMapping("path/{var}")
	public String withPathVariable(@PathVariable String var) {
		return "Obtained 'var' path variable value '" + var + "'";
	}

	/*
	@MatrixVariable
	 - URI의 일부 중 키/값으로 구분된 값을 메서드의 파리미터로 전달 받을 때 사용합니다.
	*/
	@GetMapping("{path}/simple")
	public String withMatrixVariable(@PathVariable String path, @MatrixVariable String foo) {
		return "Obtained matrix variable 'foo=" + foo + "' from path segment '" + path + "'";
	}

	@GetMapping("{path1}/{path2}")
	public String withMatrixVariablesMultiple(@PathVariable String path1, @MatrixVariable(name = "foo", pathVar = "path1") String foo1,
			@PathVariable String path2, @MatrixVariable(name = "foo", pathVar = "path2") String foo2) {

		return "Obtained matrix variable foo=" + foo1 + " from path segment '" + path1 + "' and variable 'foo=" + foo2 + " from path segment '"
				+ path2 + "'";
	}

	@GetMapping("header")
	public String withHeader(@RequestHeader String Accept) {
		return "Obtained 'Accept' header '" + Accept + "'";
	}

	@GetMapping("cookie")
	public String withCookie(@CookieValue String openid_provider) {
		return "Obtained 'openid_provider' cookie '" + openid_provider + "'";
	}

	@PostMapping("body")
	public String withBody(@RequestBody String body) {
		return "Posted request body '" + body + "'";
	}

	@PostMapping("entity")
	public String withEntity(HttpEntity<String> entity) {
		return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
	}

}
