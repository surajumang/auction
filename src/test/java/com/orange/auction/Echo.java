package com.orange.auction;

import com.orange.auction.endpoints.SampleEndpoint;
import com.orange.auction.model.Member;
import com.orange.auction.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SampleEndpoint.class)
public class Echo {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    public void echo() throws Exception {
        mockMvc.perform(get("/echo/hello")).andExpect(status().isOk());
    }

    @Test
    public void mockedMember() throws Exception {
        given(this.memberService.getUser("suraj")).willReturn(new Member("Suraj"));
        mockMvc.perform(get("/users/suraj")).andExpect(status().isOk());
    }

    @Test
    public void numberOfMembers() throws Exception {
        List<Member> members = new ArrayList<>();
        members.add(new Member("Suraj"));
        members.add(new Member("sujit"));

        given(this.memberService.getUsers()).willReturn(members);
        mockMvc.perform(get("/users")).andExpect(status().isOk());
    }
}

/*If it is required to test only the web layer, i.e if the controllers are working fine or not, then
* @WebMvcTest should be the way to go.*/
