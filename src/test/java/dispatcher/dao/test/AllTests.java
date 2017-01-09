package dispatcher.dao.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dispatcher.controller.test.ExportToExcelControllerTest;
import dispatcher.controller.test.LoginControllerTest;
import dispatcher.controller.test.ProviderControllerTest;
import dispatcher.controller.test.ReportControllerTest;
import dispatcher.controller.test.SupplyControllerTest;

@RunWith(Suite.class)
@SuiteClasses({ LoginControllerTest.class, ProviderControllerTest.class, SupplyControllerTest.class,
		ExportToExcelControllerTest.class, ReportControllerTest.class, ProviderDaoImplTest.class,
		SupplyDaoImplTest.class })
public class AllTests {

}
