#!/bin/bash
for i in {1..999};
do
 curl 'https://www.google.com/search?sxsrf=ALeKk02DvYzd1-84s0y9-LU4cFjhYiF1HQ%3A1599139659369&ei=S-9QX_OPFofQsAXHy66ACg&q=vachi+aluminium&oq=vachi+aluminium&gs_lcp=CgZwc3ktYWIQDFAAWABg4GZoAHAAeACAAQCIAQCSAQCYAQCqAQdnd3Mtd2l6&sclient=psy-ab&ved=0ahUKEwiz4d66i83rAhUHKKwKHcelC6AQ4dUDCA0' \
  -H 'authority: www.google.com' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
  -H 'x-client-data: +MfKAQjnyMoBCOnIygEItMvKAQiV1soBCLvXygEY+b/KAQ==' \
  -H 'sec-fetch-site: same-origin' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-user: ?1' \
  -H 'sec-fetch-dest: document' \
  -H 'referer: https://www.google.com/' \
  -H 'accept-language: en-US,en;q=0.9' \
  -H 'cookie: CGIC=pbWFnZS93ZWJwLGltYWdlL2FwbmcsKi8qO3E9MC44LGFwcGxpY2F0aW9uL3NpZ25lZC1leGNoYW5nZTt2PWIzO3E9MC45; CONSENT=YES+US.en+201907; HSID=AbvVa9C2RXsvICY7d; SSID=AOTt8-SCEVc0Xb4O6; APISID=mHnDvgjfm58N_aNy/AqZjrdhKplv_cpxJo; SAPISID=xoxty7gZLapLmlHo/AfWf7-rD9Z2ME5COL; __Secure-3PAPISID=xoxty7gZLapLmlHo/AfWf7-rD9Z2ME5COL; SID=0gciryktkioJx3CMstgT2m0iVjj3A5YRORX-DcEm1zlThXwrMo2UoWtC7-xdo0hP0B-9bQ.; __Secure-3PSID=0gciryktkioJx3CMstgT2m0iVjj3A5YRORX-DcEm1zlThXwrb45CqGj5XCKhS0n6-1wK1w.; ANID=AHWqTUk7jTUvsvDkrNBXtsy4QjEG1nLpye29S9f8dgIj8zCjrrd3gzTGXFIXJr9Y; S=billing-ui-v3=xPauNF5z4wNh-jy_1cfUBmR7dio7mZ0r:billing-ui-v3-efe=xPauNF5z4wNh-jy_1cfUBmR7dio7mZ0r:grandcentral=F6VGhLhybW6HP_BOME2PIBPIsTYpxH0J; OTZ=5604357_76_80_104160_76_446820; SEARCH_SAMESITE=CgQIy5AB; COMPASS=calendar=CowBAAlriVc__dAkTJiYXPczYNSG8IJdLVBtvevwmKXZJ6DHhnTIp9IBwYtUHtfevzW5vENofHKrI7PsQIY3T_mcohld-_24NNA9Ey_C9UtGIvGumc1hR3iCYgZbJml4beol66fbg8nKCwu7VnDafmGASvTNURhaY3liAbOC0_ikWUhkgQYcRFp_SStBKvQQi-K--gUalwEACWuJVypBkw1NHOl8Heqd2xYaW5ruGV4ZSy4B233smTjmWuPFDKnH7R7f1grVlZtXU8FTCd_P3e74wkCOpE3YRcTnOC-NMY1f7DT6BiwUEj5QBr4pIDAzwB5KBNeanHHK8C5r55zZZLjXTJaDU2koT_LlUmbqz-JDulUIY2ZdOClkQGLAXsiLGgDX99BeLWHwM3TdoHsA; NID=204=QW153Qh6EYQquBTGkwWvV1fstGqvpXgWGgwPbVQNmCz4-XT6PR1kuccGc4sUWbQ6dEjS_muSL01C3vjAXR4Vzlnkv5aKIy_ZEBjYfI9mqcBC5WmH2fet4BjUPPRpamKWJLLauBPP4bZAsiIyJLX0KJbCiBtrRHFK1wj1PhIFw-Um-Jzk0xeynvGEOrQ1KbVDyul2ums8qYV_PE2LVaywF3fMwcd_poR2e_pOkooDNtlvnpuYBN0mB2zw16CL_y7MrOKlgNPhwSjF59vGMtz_mr6Ijctd9_xAfV0SkMCMOiY14c39wLRJc7HctgT0zKh8oFhJulj9QbpjB-Z6R4RCxBSxi0QtbqwjqzkEe5xttAY_VnR3qgwXS0Mr_J3m1X3_eGags6EfK1KKFO0_Fvtl_fpo8tM2; 1P_JAR=2020-09-03-13; DV=I34vsreU9xdKYIVCLK0l39tsA2xCRddjR6BRUOEUpAEAAADRB9mqW1MGoQAAAMSt4XBT30qDQgAAAA; SIDCC=AJi4QfGA2jS2mEvX5s9qfOlzj3lPsxh5WqoPHHIqCON-t1suwp29LdDVvRYLOC0GEo8OPJlTi3s; __Secure-3PSIDCC=AJi4QfEUl2HWgzEZIciKivDYtP2R1EO8aPL6BqPucziVUKi9cSn3bRIcuz8_P6xG63Z2-oJK1Q' \
  --compressed > 1.html
 sleep 2
 curl 'https://www.google.com/search?sxsrf=ALeKk03SM9VMKp6WdU3amdGt1xNjs_KYSA%3A1599139825321&ei=8e9QX6SLE4yytQX4ob_oBQ&q=vachi+enterprises+raipur&oq=vachi+enterprises+raipur&gs_lcp=CgZwc3ktYWIQDDIECCMQJ1AAWABgsoACaABwAHgAgAHaAogB2gKSAQMzLTGYAQCqAQdnd3Mtd2l6wAEB&sclient=psy-ab&ved=0ahUKEwjkx--JjM3rAhUMWa0KHfjQD10Q4dUDCA0' \
  -H 'authority: www.google.com' \
  -H 'pragma: no-cache' \
  -H 'cache-control: no-cache' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
  -H 'x-client-data: EY+b/KAQ==' \
  -H 'sec-fetch-site: same-origin' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-user: ?1' \
  -H 'sec-fetch-dest: document' \
  -H 'referer: https://www.google.com/' \
  -H 'accept-language: en-US,en;q=0.9' \
  -H 'cookie: CGIC=aW9uL3NpZ25lZC1leGNoYW5nZTt2PWIzO3E9MC45; CONSENT=YES+US.en+201907; HSID=AbvVa9C2RXsvICY7d; SSID=AOTt8-SCEVc0Xb4O6; APISID=mHnDvgjfm58N_aNy/AqZjrdhKplv_cpxJo; SAPISID=xoxty7gZLapLmlHo/AfWf7-rD9Z2ME5COL; __Secure-3PAPISID=xoxty7gZLapLmlHo/AfWf7-rD9Z2ME5COL; SID=0gciryktkioJx3CMstgT2m0iVjj3A5YRORX-DcEm1zlThXwrMo2UoWtC7-xdo0hP0B-9bQ.; __Secure-3PSID=0gciryktkioJx3CMstgT2m0iVjj3A5YRORX-DcEm1zlThXwrb45CqGj5XCKhS0n6-1wK1w.; ANID=AHWqTUk7jTUvsvDkrNBXtsy4QjEG1nLpye29S9f8dgIj8zCjrrd3gzTGXFIXJr9Y; S=billing-ui-v3=xPauNF5z4wNh-jy_1cfUBmR7dio7mZ0r:billing-ui-v3-efe=xPauNF5z4wNh-jy_1cfUBmR7dio7mZ0r:grandcentral=F6VGhLhybW6HP_BOME2PIBPIsTYpxH0J; OTZ=5604357_76_80_104160_76_446820; SEARCH_SAMESITE=CgQIy5AB; COMPASS=calendar=CowBAAlriVc__dAkTJiYXPczYNSG8IJdLVBtvevwmKXZJ6DHhnTIp9IBwYtUHtfevzW5vENofHKrI7PsQIY3T_mcohld-_24NNA9Ey_C9UtGIvGumc1hR3iCYgZbJml4beol66fbg8nKCwu7VnDafmGASvTNURhaY3liAbOC0_ikWUhkgQYcRFp_SStBKvQQi-K--gUalwEACWuJVypBkw1NHOl8Heqd2xYaW5ruGV4ZSy4B233smTjmWuPFDKnH7R7f1grVlZtXU8FTCd_P3e74wkCOpE3YRcTnOC-NMY1f7DT6BiwUEj5QBr4pIDAzwB5KBNeanHHK8C5r55zZZLjXTJaDU2koT_LlUmbqz-JDulUIY2ZdOClkQGLAXsiLGgDX99BeLWHwM3TdoHsA; NID=204=QW153Qh6EYQquBTGkwWvV1fstGqvpXgWGgwPbVQNmCz4-XT6PR1kuccGc4sUWbQ6dEjS_muSL01C3vjAXR4Vzlnkv5aKIy_ZEBjYfI9mqcBC5WmH2fet4BjUPPRpamKWJLLauBPP4bZAsiIyJLX0KJbCiBtrRHFK1wj1PhIFw-Um-Jzk0xeynvGEOrQ1KbVDyul2ums8qYV_PE2LVaywF3fMwcd_poR2e_pOkooDNtlvnpuYBN0mB2zw16CL_y7MrOKlgNPhwSjF59vGMtz_mr6Ijctd9_xAfV0SkMCMOiY14c39wLRJc7HctgT0zKh8oFhJulj9QbpjB-Z6R4RCxBSxi0QtbqwjqzkEe5xttAY_VnR3qgwXS0Mr_J3m1X3_eGags6EfK1KKFO0_Fvtl_fpo8tM2; 1P_JAR=2020-09-03-13; DV=I34vsreU9xda8NgRaBRUOAXZnJRCRVfcGg439a00KAIAAADRB9mqW1MGwQAAAFwWU3e_ST6XWQAAAFYoxNJa8r3NGQAAAA; SIDCC=AJi4QfHYNDou9tzFPmXAWWXHeRhMCjdbBkMa97c4N6ar8K7uWaIrnfC44Wnf_-RUFIElQQi9Ej8; __Secure-3PSIDCC=AJi4QfEWgflG5Bh-CePJTbcMUKPyqiWF0SKeFYohh--0w9Rj-F91X2F7A4gEvGS_uHYyssuU_Q' \
  --compressed > 2.html
 sleep 2
 curl "https://vachienterprisesraipur.business.site/"  > 3.html
 sleep 2  
 curl 'https://www.justdial.com/Raipur-Chhattisgarh/search?q=vachi-aluminium' \
  -H 'authority: www.justdial.com' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
  -H 'sec-fetch-site: same-origin' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-user: ?1' \
  -H 'sec-fetch-dest: document' \
  -H 'accept-language: en-US,en;q=0.9' \
  --compressed > 4.html
done
