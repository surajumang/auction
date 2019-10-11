package com.orange.auction;

import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import com.orange.auction.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;


import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebClient {

//    Available only when a full server is running, I full server is not required then go for MockMvc
//    and WebMvcTest
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private MemberService memberService;

    @Test
    public void simple() {
        given(memberService.getUser("suraj")).willReturn(new Member("Suraj", "dfgd"));
        Member m = testRestTemplate.getForEntity("/users/suraj", Member.class).getBody();
        Assertions.assertThat(m.getFirstName()).isEqualTo("Suraj");
    }
}
