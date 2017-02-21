import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by andre on 20.02.2017.
 */
public class Main2 implements CommandLineProcess.CommandLineListener {
    private Retrofit retrofit;
    private FixerApi fixerApi;


    public static void main(String[] args) {
        new Main2().main();
    }

    public void main() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.fixer.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        fixerApi = retrofit.create(FixerApi.class);

//        System.out.println(fastCompile2());
        CommandLineProcess.run(this);
    }


    @Override
    public void userComGetRates(String base, String[] exchanges) {
        String exc = Arrays.toString(exchanges).replace("[", "").replace("]", "");
        System.out.println("loading...");
        fixerApi.getData(base, exc).enqueue(new Callback<PostFixerModel>() {
            @Override
            public void onResponse(Call<PostFixerModel> call, Response<PostFixerModel> response) {
                if (response.body().rates.AUD != null)
                    System.out.println(
                            response.body().base + "/AUD  :" +
                                    response.body().rates.AUD);
                if (response.body().rates.BGN != null)
                    System.out.println(
                            response.body().base + "/BGN  :" +
                                    response.body().rates.BGN);
                if (response.body().rates.BRL != null)
                    System.out.println(
                            response.body().base + "/BRL  :" +
                                    response.body().rates.BRL);
                if (response.body().rates.CAD != null)
                    System.out.println(
                            response.body().base + "/CAD  :" +
                                    response.body().rates.CAD);
                if (response.body().rates.CHF != null)
                    System.out.println(
                            response.body().base + "/CHF  :" +
                                    response.body().rates.CHF);
                if (response.body().rates.CNY != null)
                    System.out.println(
                            response.body().base + "/CNY  :" +
                                    response.body().rates.CNY);
                if (response.body().rates.CZK != null)
                    System.out.println(
                            response.body().base + "/CZK  :" +
                                    response.body().rates.CZK);
                if (response.body().rates.DKK != null)
                    System.out.println(
                            response.body().base + "/DKK  :" +
                                    response.body().rates.DKK);
                if (response.body().rates.GBP != null)
                    System.out.println(
                            response.body().base + "/GBP  :" +
                                    response.body().rates.GBP);
                if (response.body().rates.HKD != null)
                    System.out.println(
                            response.body().base + "/HKD  :" +
                                    response.body().rates.HKD);
                if (response.body().rates.HRK != null)
                    System.out.println(
                            response.body().base + "/HRK  :" +
                                    response.body().rates.HRK);
                if (response.body().rates.HUF != null)
                    System.out.println(
                            response.body().base + "/HUF  :" +
                                    response.body().rates.HUF);
                if (response.body().rates.IDR != null)
                    System.out.println(
                            response.body().base + "/IDR  :" +
                                    response.body().rates.IDR);
                if (response.body().rates.ILS != null)
                    System.out.println(
                            response.body().base + "/ILS  :" +
                                    response.body().rates.ILS);
                if (response.body().rates.INR != null)
                    System.out.println(
                            response.body().base + "/INR  :" +
                                    response.body().rates.INR);
                if (response.body().rates.JPY != null)
                    System.out.println(
                            response.body().base + "/JPY  :" +
                                    response.body().rates.JPY);
                if (response.body().rates.KRW != null)
                    System.out.println(
                            response.body().base + "/KRW  :" +
                                    response.body().rates.KRW);
                if (response.body().rates.MXN != null)
                    System.out.println(
                            response.body().base + "/MXN  :" +
                                    response.body().rates.MXN);
                if (response.body().rates.MYR != null)
                    System.out.println(
                            response.body().base + "/MYR  :" +
                                    response.body().rates.MYR);
                if (response.body().rates.NOK != null)
                    System.out.println(
                            response.body().base + "/NOK  :" +
                                    response.body().rates.NOK);
                if (response.body().rates.NZD != null)
                    System.out.println(
                            response.body().base + "/NZD  :" +
                                    response.body().rates.NZD);
                if (response.body().rates.PHP != null)
                    System.out.println(
                            response.body().base + "/PHP  :" +
                                    response.body().rates.PHP);
                if (response.body().rates.PLN != null)
                    System.out.println(
                            response.body().base + "/PLN  :" +
                                    response.body().rates.PLN);
                if (response.body().rates.RON != null)
                    System.out.println(
                            response.body().base + "/RON  :" +
                                    response.body().rates.RON);
                if (response.body().rates.RUB != null)
                    System.out.println(
                            response.body().base + "/RUB  :" +
                                    response.body().rates.RUB);
                if (response.body().rates.SEK != null)
                    System.out.println(
                            response.body().base + "/SEK  :" +
                                    response.body().rates.SEK);
                if (response.body().rates.SGD != null)
                    System.out.println(
                            response.body().base + "/SGD  :" +
                                    response.body().rates.SGD);
                if (response.body().rates.THB != null)
                    System.out.println(
                            response.body().base + "/THB  :" +
                                    response.body().rates.THB);
                if (response.body().rates.TRY != null)
                    System.out.println(
                            response.body().base + "/TRY  :" +
                                    response.body().rates.TRY);
                if (response.body().rates.USD != null)
                    System.out.println(
                            response.body().base + "/USD  :" +
                                    response.body().rates.USD);
                if (response.body().rates.ZAR != null)
                    System.out.println(
                            response.body().base + "/ZAR  :" +
                                    response.body().rates.ZAR);
            }

            @Override
            public void onFailure(Call<PostFixerModel> call, Throwable t) {
                System.out.println("error connect");
            }
        });
    }


    private String fastCompile() {
        String s = "AUD BGN BRL CAD CHF CNY CZK DKK GBP HKD HRK HUF IDR ILS INR JPY KRW MXN MYR NOK NZD PHP PLN RON RUB SEK SGD THB TRY USD ZAR";
        String[] exc = s.split(" ");

        String out = "";
        for (int i = 0; i < exc.length; i++) {
            out += "  @SerializedName(\"" + exc[i] + "\")\n" +
                    "        public String " + exc[i] + ";";
        }
        return out;
    }

    private String fastCompile2() {
        String s = "AUD BGN BRL CAD CHF CNY CZK DKK GBP HKD HRK HUF IDR ILS INR JPY KRW MXN MYR NOK NZD PHP PLN RON RUB SEK SGD THB TRY USD ZAR";
        String[] exc = s.split(" ");

        String out = "";
        for (int i = 0; i < exc.length; i++) {
            out += "   if (response.body().rates." + exc[i] + " != null)\n" +
                    "                    System.out.println(\n" +
                    "                            response.body().base + \"/" + exc[i] + "  :\" +\n" +
                    "                                    response.body().rates." + exc[i] + ");";
        }
        return out;
    }


}
