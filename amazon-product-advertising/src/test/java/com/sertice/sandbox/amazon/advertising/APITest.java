package com.sertice.sandbox.amazon.advertising;

import java.math.BigInteger;

import org.junit.Test;

import com.sertice.sandbox.amazon.advertising.jaxws.AWSECommerceService;
import com.sertice.sandbox.amazon.advertising.jaxws.AWSECommerceServicePortType;
import com.sertice.sandbox.amazon.advertising.jaxws.Item;
import com.sertice.sandbox.amazon.advertising.jaxws.ItemSearch;
import com.sertice.sandbox.amazon.advertising.jaxws.ItemSearchRequest;
import com.sertice.sandbox.amazon.advertising.jaxws.ItemSearchResponse;
import com.sertice.sandbox.amazon.advertising.jaxws.Items;

public class APITest {

	@Test
	public void test1() {
		AWSECommerceService service = new AWSECommerceService();
		service.setHandlerResolver(new AwsHandlerResolver(AwsConfig
				.get("secretKey")));

		AWSECommerceServicePortType port = service
				.getAWSECommerceServicePortJP();

		ItemSearchRequest request = new ItemSearchRequest();
		request.setSearchIndex("Books");
		request.setKeywords("Scrum");
		request.setItemPage(BigInteger.valueOf(1L));

		ItemSearch itemSearch = new ItemSearch();
		itemSearch.setAssociateTag(AwsConfig.get("associateTag"));
		itemSearch.setAWSAccessKeyId(AwsConfig.get("accessKey"));
		itemSearch.getRequest().add(request);

		ItemSearchResponse response = port.itemSearch(itemSearch);

		for (Items itemList : response.getItems()) {
			for (Item item : itemList.getItem()) {
				System.out.println("Book Name: "
						+ item.getItemAttributes().getTitle());
			}
		}
	}

}
