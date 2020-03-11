/*
Code for generate and sign JWT with dates, subject and claims
For languages: Java
*/

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.text.DateFormat; 
import io.jsonwebtoken.Jwts;
import java.security.*;
import java.security.spec.*;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

//Set time in ms
millis = 7200000;

//In case that ypu need to sign JWT with custom claims or a subject, call them here
subject = ${subject};
claim1 = ${claim1};

//Call privateKey in 'pivate' Object
Key privateKey = vars.getObject("private");

//Create dates (-2h, now, +2h)
Timestamp HActual1 = new Timestamp(System.currentTimeMillis());
HActual = HActual1.getTime();
HPrevious = (HActual1.getTime()-millis);
HLater = (HActual1.getTime()+millis);

//Format timestamp
DateFormat simple = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy"); 
Date HActual = new Date(HActual);
Date HPrevious = new Date(HPrevious);
Date HLater = new Date(HLater);

//sign JWT with subject, claim and PrivateKey
String jwt = Jwts.builder().setNotBefore(HPrevious).setIssuedAt(HActual).setExpiration(HLater).setSubject(subject).claim(claim1).signWith(privateKey).compact();

//Put JWT in JMeter var for use in header for autentication
vars.put("jwt", jwt);

