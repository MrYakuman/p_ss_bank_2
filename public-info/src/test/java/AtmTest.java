import com.bank.publicinfo.controller.LicenseController;
import com.bank.publicinfo.dto.LicenseDTO;
import com.bank.publicinfo.entity.License;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class AtmTest {
    @Mock
    LicenseController licenseControllerSpy = Mockito.spy(LicenseController.class);
    @Test
    public void test() {
        Mockito.when(
                licenseControllerSpy.postLicense(new License(22, "photo3", null))
                ).thenReturn( new LicenseDTO("photo3"));
    }
}
