//GET COOKIE OF REQUEST
    List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();
    for (HttpCookie cookie : cookies) {
        if (cookie.getName() == 'cookieName'){
            cookieName = cookie.getValue();
        }
    }

//----------------------------

// REUSE COOKIES FOR EVERY REQUEST.
CookieManager cookieManager = new CookieManager()
CookieHandler.setDefault(cookieManager)

//----------------------------

//  GET REQUEST
def url = new URL('https://url.com')
HttpURLConnection conn = (HttpURLConnection) url.openConnection()
conn.setRequestMethod("GET")
conn.setInstanceFollowRedirects(false)

//ACTION IF RESPONSE OK
if(conn.responseCode in [400,402]) {

}

//----------------------------

// POST REQUEST
def url = new URL('https://url.com')
conn = (HttpURLConnection) url.openConnection()
conn.setRequestMethod("POST")
//SET PROPERTY
conn.setRequestProperty("Accept", "application/json")
//GET RESPONSE
        logger.info("Response: " + conn.responseCode + " " + conn.responseMessage)
//GET PARAMS OF REQUEST
    InputStream is = new BufferedInputStream(conn.getInputStream())
    def jsonResp = new groovy.json.JsonSlurper().parseText(is.text)
    var1 = jsonResp.varResponseName1
    var2 = jsonResp.varResponseName2

//----------------------------

//COMPLEX REQUEST
            def url = new URL('https://url.com')
            conn = (HttpURLConnection) url.openConnection()
            conn.setDoOutput(true)
            conn.setRequestMethod("POST")
            conn.setRequestProperty("Content-Type", "application/json; utf-8")
            conn.setRequestProperty("AuthorizationHeader", "Bearer " + bearer)
	    //JSON body object
            JSONObject body=new JSONObject()
            body.put("Claim1",Claim2)
            body.put("Claim2", Claim2)
            body.put("Property1", "value")
            body.put("Property2", "value")

            OutputStreamWriter wr= new OutputStreamWriter(conn2.getOutputStream())
            wr.write(body.toString())
            wr.flush()
            wr.close()
            logger.info("Response " + conn2.responseCode)
            logger.info ("\nData1: " + data1 + " \nData2: " + data2 + "\nData3: " + data3)
            conn2.disconnect()
