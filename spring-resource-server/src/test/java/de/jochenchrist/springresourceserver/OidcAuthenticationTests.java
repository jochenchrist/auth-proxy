package de.jochenchrist.springresourceserver;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * Keycloak must be running on localhost.
 */
@Ignore("run manually, when Keycloak is running")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OidcAuthenticationTests {

	@Autowired
	MockMvc mvc;

	@Test
	public void shouldConvertSubToPrincipal() throws Exception {
		String jwt = validJwt();

		mvc.perform(get("/").header("Authorization", "Bearer " + jwt))
				.andExpect(content().string(containsString("23de8edb-c946-43b5-9c8b-e36f168bc248")));
	}

	private String validJwt() {
		// "sub": "23de8edb-c946-43b5-9c8b-e36f168bc248",
		// "exp": 2021-03-16
		return "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJaX1FsZS1DUUJ3dnhkVHdBWVRTLWF1VXEyVmlTMXRBZzE2NEIyV2R1VVZrIn0.eyJqdGkiOiJjNTMyNGYyNi03MjU5LTQzZGUtODZmYS04MGViZjFmZDYxMGMiLCJleHAiOjE2MTU5MjA3ODQsIm5iZiI6MCwiaWF0IjoxNTI5NjA3MTg0LCJpc3MiOiJodHRwOi8va2V5Y2xvYWs6ODA4MC9hdXRoL3JlYWxtcy9teWFwcCIsImF1ZCI6ImFwcDEiLCJzdWIiOiIyM2RlOGVkYi1jOTQ2LTQzYjUtOWM4Yi1lMzZmMTY4YmMyNDgiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhcHAxIiwibm9uY2UiOiIzOTM2ZjRhZjU1MzM4Mzc0YmJkYmUwN2VmM2IzMGEzYSIsImF1dGhfdGltZSI6MTUyOTYwNzE4NCwic2Vzc2lvbl9zdGF0ZSI6ImE5ODNjYWMxLWIzYTQtNDE4ZS1hZGQ0LWU0ZGY1MzgzMWI2MiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdCJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJ1c2VyX25hbWUiOiJqb2NoZW4iLCJuYW1lIjoiSm9jaGVuIENocmlzdCIsImdpdmVuX25hbWUiOiJKb2NoZW4iLCJmYW1pbHlfbmFtZSI6IkNocmlzdCIsImVtYWlsIjoiam9jaGVuLmNocmlzdEBpbm5vcS5jb20ifQ.oDeKtl5ziRTN1OHePq-QsCqrienjH_3p-8nzSo1WkHOasnXqxYcHL_llwY49VdEVBAodkfjEUwosBN5XQ9RaFZ-HCYQ0Tjcr22n5_aIdcWYnnEuLu8gwE0URnMaf3HAmulQWxo8h84R3yNmsmBNxdow8xEkGRtKRNLpBxC3HkVnDIdK4p4cI_IzfQpe__92-EBqfbXQ6J8GDq1SK7YdnaAONW56C_JbnihCAWOPwffYfPTrO_PgmgD1jHZZ2tPlYftbJZ1oEnoAyPixxi-Vz5LMpv_Xz0Df9d_3Kp_uqIO9UqPTWYeLsL38jDjA8TWSqONuuTu1Mwwyqm_AERJcyD";
	}
}
