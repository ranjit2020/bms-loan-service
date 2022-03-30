package com.bms.loanservice;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LoanServiceApplicationTests {


	@Test
	public void contextLoads() {
		assertEquals(20,20*1);
	}

//	@Test
//	public void testGetLoanDetails() throws Exception{
//
//		LoanTypeMaster loanTypeMaster = new LoanTypeMaster("PL");
//		loanTypeMaster.setCreatedDate(new Date());
//		loanTypeMaster.setCreatedBy("sjain");
//
//
//		LoanDetail loanDetail = new LoanDetail(loanTypeMaster,123.12,new Date(),12.2,10);
//		loanDetail.setCreatedDate(new Date());
//		loanDetail.setCreatedBy("sjain");
//		List<LoanDetail> loanDetails = new ArrayList<>();
//		loanDetails.add(loanDetail);
//
//		APIResponse apiResponse = new APIResponse();
//		System.out.println(loanDetailRepository.findAll());
//
////        Mockito.when(apiResponse1).thenReturn(s);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("api/v1/loan/view").contentType(MediaType.APPLICATION_JSON);
////
////		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
////
////		System.out.println(result.getResponse());
//
////        Mockito.when()
////        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/loan/view").contentType(MediaType.APPLICATION_JSON));
//	}
}
