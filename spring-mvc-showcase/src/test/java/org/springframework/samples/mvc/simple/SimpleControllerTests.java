package org.springframework.samples.mvc.simple;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;

public class SimpleControllerTests {

	@Test
	public void simple() throws Exception {
		standaloneSetup(new SimpleController()).build() //
				.perform(get("/simple")) //
				.andExpect(status().isOk()) //
				.andExpect(content().contentType("text/plain;charset=UTF-8")) //
				// .andExpect(content().contentType("text/plain;charset=ISO-8859-1")) //
				.andExpect(content().string("Hello world!"));
	}
}

/*
SimpleController를 등록하여 MockMvc 타입의 객체를 만들고, "/simple" 요청을 보낸 후 응답에 HttpStatus 코드가 "200"이고, 콘텐츠 타입이 "text/plain;charset=ISO-8859-1"이고, 본문에 "context"라는 값이 있는지 확인한다.
 
standaloneSetup()
 - 컨트롤러를 등록하여  MockMvc 타입의 객체를 생성합니다.
 
perform()
 - DispathcherServlet에 요청을 보냅니다.

andExpect()
 - 실행 결과를 검증하는 ResultMatcher 지정합니다.
*/