package org.springframework;

import org.junit.Test;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

public class MyRetryTemplateTests {

	@Test
	public void testSuccessfulRetry() throws Throwable {
		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setRetryPolicy(new SimpleRetryPolicy(5));
		String execute = retryTemplate.execute(new RetryCallback<String, Throwable>() {
			@Override
			public String doWithRetry(RetryContext context) throws Throwable {
				return "aa";
			}
		});
		System.out.println(execute);
	}

}