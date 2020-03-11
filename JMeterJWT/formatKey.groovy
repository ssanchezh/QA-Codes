/*
Code for prepare PrivateKey for using at generate JWT
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

//Call variable PrivateKey generate at 'CreateKeyPair'
String privateKey = "${PrivateKey}";

//Format and sign Key with RSA
 public static Key loadPrivateKey(String stored) throws GeneralSecurityException, IOException {
 byte[] data = Base64.getDecoder().decode((stored.getBytes()));
 PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
 KeyFactory fact = KeyFactory.getInstance("RSA");
 PrivateKey pubKey = fact.generatePrivate(spec);
 //return fact.generatePublic(spec);
}

//Put private Key format as objetc
private = loadPrivateKey(privateKey);
vars.putObject("private",private);


