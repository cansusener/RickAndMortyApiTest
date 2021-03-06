import io.restassured.response.Response;
import model.Character;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.BaseService;
import spec.ResponseSpec;

import java.sql.Timestamp;

public class ApiTesting extends BaseService {

    @Test
    public void GetCharacter() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Response responseBody = GetAll("/character", ResponseSpec.checkStatusCodeOk());

        Character[] result = responseBody.jsonPath().getObject("results", Character[].class);

        Assert.assertTrue(result.length > 0);    // eleman geliyor mu

        // 0dan kucuk ıse asagıdakı kontrollere hıc girmiyor


        //her karakterde olan ortak alanlar
        for (Character c : result) {
            Assert.assertFalse(c.getName().isEmpty(), "Name boş geldi");
            Assert.assertFalse(c.getGender().isEmpty(), "Gender Boş geldi");
            Assert.assertTrue(c.getId() > 0, "Id 0 dan küçük geldi");
            Assert.assertTrue(c.getEpisode().length > 0, "lenght 0 dan küçük geldi");
        }
    }
}
