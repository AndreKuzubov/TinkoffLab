import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by andre on 21.02.2017.
 */
public interface FixerApi {

    @GET("/latest")
    Call<PostFixerModel> getData(@Query("base") String base, @Query("symbols") String symbols);
}
