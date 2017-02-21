import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Map;

import retrofit2.http.FieldMap;

/**
 * Created by andre on 20.02.2017.
 */

public class PostFixerModel {

    @SerializedName("base")
    @Expose
    public String base;

    @SerializedName("date")
    @Expose
    public Date date;

    @SerializedName("rates")
    @Expose
    public Rates rates;

    class Rates {

        @SerializedName("AUD")
        public String AUD;
        @SerializedName("BGN")
        public String BGN;
        @SerializedName("BRL")
        public String BRL;
        @SerializedName("CAD")
        public String CAD;
        @SerializedName("CHF")
        public String CHF;
        @SerializedName("CNY")
        public String CNY;
        @SerializedName("CZK")
        public String CZK;
        @SerializedName("DKK")
        public String DKK;
        @SerializedName("GBP")
        public String GBP;
        @SerializedName("HKD")
        public String HKD;
        @SerializedName("HRK")
        public String HRK;
        @SerializedName("HUF")
        public String HUF;
        @SerializedName("IDR")
        public String IDR;
        @SerializedName("ILS")
        public String ILS;
        @SerializedName("INR")
        public String INR;
        @SerializedName("JPY")
        public String JPY;
        @SerializedName("KRW")
        public String KRW;
        @SerializedName("MXN")
        public String MXN;
        @SerializedName("MYR")
        public String MYR;
        @SerializedName("NOK")
        public String NOK;
        @SerializedName("NZD")
        public String NZD;
        @SerializedName("PHP")
        public String PHP;
        @SerializedName("PLN")
        public String PLN;
        @SerializedName("RON")
        public String RON;
        @SerializedName("RUB")
        public String RUB;
        @SerializedName("SEK")
        public String SEK;
        @SerializedName("SGD")
        public String SGD;
        @SerializedName("THB")
        public String THB;
        @SerializedName("TRY")
        public String TRY;
        @SerializedName("USD")
        public String USD;
        @SerializedName("ZAR")
        public String ZAR;

    }


}
