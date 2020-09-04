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
 sleep 5
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
 sleep 5
 curl "https://vachienterprisesraipur.business.site/"  > 3.html
 sleep 5  
 curl 'https://www.justdial.com/Raipur-Chhattisgarh/search?q=vachi-aluminium' \
  -H 'authority: www.justdial.com' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.83 Safari/537.36' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
  -H 'sec-fetch-site: same-origin' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-user: ?1' \
  -H 'sec-fetch-dest: document' \
  -H 'referer: https://www.justdial.com/Raipur-Chhattisgarh/search?q=vachi-aluminium' \
  -H 'accept-language: en-US,en;q=0.9' \
  -H 'cookie: ppc=; _ctok= _OC=2; UStab=; USset_tab=; USsortBy=; USsuscity=New%20York%2C%20NY; USsustate=NY; USintlusrcity=New%20York%2C%20NY; TKY=584e5f5451095b7d6a27ff6abff2a4fe7f01c6aa3c88b850e5d8d8c956b4d4c9; ppc=; usrcity=Leh Ladakh; scity=Raipur-Chhattisgarh; inweb_city=Raipur-Chhattisgarh; dealBackCity=Raipur-Chhattisgarh; akcty=Raipur-Chhattisgarh; jdeflg=0; attn_user=login; JDSID=K3ecvGmFzgLKZAeV7vu5wyjIDP9GVrXeWUKAWPMSgQE%253D; new_user=0; ck_city=chhattisgarh; profbd=0; bdcheck=1; tab=toprs; view=lst_v; docidarray=%7B%229999PX771.X771.200823180513.K7W8%22%3A%222020-08-27%22%2C%229999PX771.X771.180718123447.G5R1%22%3A%222020-08-27%22%7D; inweb_what=Aluminium+Section+Pipe+Dealers; BDprofile=1; _gid=GA1.2.516238480.1599138498; ak_bmsc=536F2AA3172C25BE6D130537883175E517C605841D210000C1EA505F5535D107~plH07IZFdhg/CsYJ/NAqsEY45ffycSiQmaYBJrG17UYk2gjJ1Oks2B3ZBkVi0UzlNO5cqpJ5Zuw8oxu6TF78Ad2mkjwqxjGU4r9RHejRBNaeroHYX94j6KD8Q8ZQDSe0YKYxVaYa3MDlAgPuKHfGyGTdaXdn+R36yjNRCILq4UmNvONQkqw0vvOa8bTI8YPGhtQ6FpmKcw2HhCe3yzLZ6h9r6e4qvhh3BkiiypA/8JY/O1rgCR2IASaitK3xODITsT; JDTID=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1OTkxMzg1MDksImp0aSI6Ik5qZ3VPVEF1TVRBMUxqRXhNbDlEYUhKdmJXVmZkMmx1Wkc5M2N3PT0iLCJpc3MiOiJ3d3cuanVzdGRpYWwuY29tIiwibmJmIjoxNTk5MTM4NTA5LCJleHAiOjE1OTkyMjQ5MDksImRhdGEiOnsiamRlZmxnIjoiMyJ9fQ.mvSXij2sSq-qzwoFR71ohnpeOMtNxMK7dTXw0Dd8N4o; main_city=Raipur-Chhattisgarh; PHPSESSID=ef9e7658db22cba0120d3aa610798fab; bm_sv=92ED7627D0C1CC964851CC27DC132850~Afz7B8G05o1hncNRszE7TD5vqKEYRjHF1WdhzrTzvf4JgCVpLjc14b6Bxjpug/1t32ZkymXyRuHUofx44we+8NM4uRS4sN4HTJbaPt9yDybgsTc3kw/gm+oY91qjYY2+bhHi9WfTyglWiuNmh7fiuRK4OKzRsAGb8ByJvar+8TY=' \
  --compressed > 4.html
  sleep 5
done
