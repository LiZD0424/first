package com.example.demo.util;

import com.example.demo.entity.HttpResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import static org.apache.http.Consts.UTF_8;

public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
    public static final String  HTTPS="https";
    public static CloseableHttpClient getHttpClient()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory>create();
        ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
        registryBuilder.register("http", plainSF);
        //指定信任密钥存储对象和连接套接字工厂
        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        //信任任何链接
        TrustStrategy anyTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                return true;
            }
        };
        SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
        LayeredConnectionSocketFactory sslSF =
                new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        registryBuilder.register(HTTPS, sslSF);
        Registry<ConnectionSocketFactory> registry = registryBuilder.build();
        //设置连接管理器
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
        //构建客户端
        return HttpClientBuilder.create().setConnectionManager(connManager).build();
    }
    public static HttpResult doGet(String url) throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if (url.contains(HTTPS)) {
            httpClient = getHttpClient();
        }
        logger.info("begin doGet, url is {}", url);
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity httpEntity = httpResponse.getEntity();
        int httpCode = httpResponse.getStatusLine().getStatusCode();
        String result = EntityUtils.toString(httpEntity, UTF_8);
        logger.info("httpcode : [{}], result : [{}]", httpCode, result);
        HttpResult httpResult = new HttpResult();
        httpResult.setHttpCode(httpCode);
        httpResult.setResult(result);
        return httpResult;
    }
}
