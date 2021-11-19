package kz.app.cart.shopping.beans;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
public RestTemplate getRestTemplate() {//здесь название рест темплейта надо поменять так как уже есть данный пример в инвентори
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        requestFactory.setConnectTimeout(3000);

        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();

        credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("rest-client", "p@ssword"));

        HttpClient client = HttpClientBuilder
        .create()
        .setDefaultCredentialsProvider(credentialsProvider)
        .build();

        requestFactory.setHttpClient(client);
        return new RestTemplate(requestFactory);
        }