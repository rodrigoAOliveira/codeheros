package rodrigo.provatecnica.codeheros.API;

import com.google.gson.Gson;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;
import rodrigo.provatecnica.codeheros.BuildConfig;

public class ModuleRetrofit {

    public static <S> S getService(Class<S> serviceClass) {

        //Instância do retrofit
        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("http://gateway.marvel.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(getUnsafeOkHttpClient())
                .build();

        return retrofit.create(serviceClass);
    }

    private static OkHttpClient getUnsafeOkHttpClient() {

        //Instancia do interceptador das requisições
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                @Override
                public void checkClientTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(
                        java.security.cert.X509Certificate[] chain,
                        String authType) throws CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return new java.security.cert.X509Certificate[0];
                }
            }};

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts,
                    new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext
                    .getSocketFactory();

            OkHttpClient okHttpClient = new OkHttpClient();
            if (BuildConfig.DEBUG) {
                okHttpClient = okHttpClient.newBuilder()
                        .sslSocketFactory(sslSocketFactory)
                        .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                        .readTimeout(15, TimeUnit.SECONDS)
                        .addInterceptor(loggingInterceptor).build();
            } else {
                okHttpClient = okHttpClient.newBuilder()
                        .sslSocketFactory(sslSocketFactory)
                        .hostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER)
                        .readTimeout(15, TimeUnit.SECONDS).build();
            }

            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
