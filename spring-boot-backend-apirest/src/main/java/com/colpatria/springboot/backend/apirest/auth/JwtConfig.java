package com.colpatria.springboot.backend.apirest.auth;

public class JwtConfig {
	
	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RCA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAqbg9rzA5KbkwTy7YEXeyH+sJgaCM4HfIGA1+afHAkZweG6Fc\r\n" + 
			"4ZGIyf9voc4g+uApGtmedjdtWT33ujXk4FHIAKMFc9O8ZqmFSFw43OVbwiVLM4vv\r\n" + 
			"5pbnmvATUlClS4mwO5GL8sC36tKmxSZ6v9KcEwL6YLRHwqInrKsQVyxP36yG4+se\r\n" + 
			"0WUIy6EkiGlxkaKE/1W1X8lh0XJOrzeuAm1LQzvfzpqcuYxHwIV7tdZkxCnthW+f\r\n" + 
			"1n1K1Lv9DSnWDOk8tDkjmZGG38owVV+QC2Sbt0k03CDY1Yu1LetE+lOvTn7VgiuB\r\n" + 
			"+dEtWmEXDvpUg9NcjMP5a74zFXzYZ2sxsboeswIDAQABAoIBAGv9/NoNYEIpQRER\r\n" + 
			"aJDszd27a4gdBacK8LpFU8vL9VFxukKwkW5CcXy+2WRmydt4aQ9Zq5fjOuQPJyNI\r\n" + 
			"icMmppGpKZ4C+52DfniFnfUIyDMoEcrR3yull+ehnVnCUPtYuFefDCLB+AUmVtGZ\r\n" + 
			"439NXtxGB9UiwYqaLY6UJsihPI3Aq6lDdkKu/dC6ZCq/A6ektryz27dZIF8J6hSs\r\n" + 
			"sKue++AYb7hVbT81bmgJG+VDM4J3USK6r8tmQgI5Rww/y3R5hcmDhS6M9nzj+oYq\r\n" + 
			"FN0a33R8uh3wUNVpe61JYzfzT1brpNHZ2MkTjscKQkGMbF/S7cauNtYw2LFHVbPx\r\n" + 
			"AWiZuVECgYEA0k8zs2RYIuq7TSTKpSfEzbvzpmrYJQRj6JIUsuFvmgmno6qPReiy\r\n" + 
			"xE3/H6Z7sVr0EFRzZuRVcMGnNh/TbIP74XQGsKt+jiTBpnrVOKW9TChtqPo3sKhv\r\n" + 
			"l2XmNveDFlmztydUMsvSjR2mmeQyDNDS8oGDze2exDNMydKp/xHunXsCgYEAzpeO\r\n" + 
			"3NFF8B0k5SO4DTfi/jbsaL/1RcNJlWxLJu839DTYELJpXaBK6ID14UqIeWNDSURi\r\n" + 
			"qOUnL7QkAyJ1ckf9VaInfihcysmkI8MfbOgjbKkZt8i55ph3N7nVDrC6UUbKl5ux\r\n" + 
			"43ddeseld6Y+m9BAdtooWP30toShTVgK1p280ikCgYBZ631KhWvduglNaZ6vULqn\r\n" + 
			"0GXT0LkL0r248cSh2xuxe9FOfB14IY9VuZeMe81FPoM9/C2/X39cj6Aj1yW5rxDi\r\n" + 
			"C47UuO6KbhLSUJCcANlYF60TY7Ct+saDsBDnjZph0waxF8K7WUR0C6pxAA2aRyr6\r\n" + 
			"fv/Q63lHoDuDy2vd4FfqwwKBgQCkfwsTClMs0JfrF9jaNZC5qFPvSEFtDgVORA9G\r\n" + 
			"7h1YhqcwDE9XbGWY4e5mN+mY9g/CjAAeyW+9TSuLj2mC2I2AHQBjNJJGKe5XR2uD\r\n" + 
			"VQe34qGGs/5J/UaYCZD7BH8mbj6sHx2yp/234LYBIk8h090whZ6w1W1/0vV410yx\r\n" + 
			"/KE3mQKBgQCa1i72+xYJZvK5brwTvfpBW8mJqbyoC/5xnwWjObL2ofiU8coImYGR\r\n" + 
			"OABxIlPyVZ5lv/kMCjZ64VG9l0jdS8CUeHxJrCZEmPfiarnYEoIRzFUMDjWbbSmz\r\n" + 
			"SH/nmNrEYoae/Q8nO1QjGNaxMBy2V0bsvAxGLCfe3nd/518lt49Wzg==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RCA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqbg9rzA5KbkwTy7YEXey\r\n" + 
			"H+sJgaCM4HfIGA1+afHAkZweG6Fc4ZGIyf9voc4g+uApGtmedjdtWT33ujXk4FHI\r\n" + 
			"AKMFc9O8ZqmFSFw43OVbwiVLM4vv5pbnmvATUlClS4mwO5GL8sC36tKmxSZ6v9Kc\r\n" + 
			"EwL6YLRHwqInrKsQVyxP36yG4+se0WUIy6EkiGlxkaKE/1W1X8lh0XJOrzeuAm1L\r\n" + 
			"QzvfzpqcuYxHwIV7tdZkxCnthW+f1n1K1Lv9DSnWDOk8tDkjmZGG38owVV+QC2Sb\r\n" + 
			"t0k03CDY1Yu1LetE+lOvTn7VgiuB+dEtWmEXDvpUg9NcjMP5a74zFXzYZ2sxsboe\r\n" + 
			"swIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";

}
