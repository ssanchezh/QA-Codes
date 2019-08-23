/*
Simple code for create JWT Token with RSA256 PrivateKey
Using library JJWT --->https://github.com/jwtk/jjwt
For languages: Groovy and Java
*/

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import java.security.Key
import java.security.NoSuchAlgorithmException;
import org.bouncycastle.jce.provider.BouncyCastleProvider
import sun.security.pkcs.PKCS8Key
import io.jsonwebtoken.security.InvalidKeyException
import io.jsonwebtoken.impl.TextCodec
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import io.jsonwebtoken.io.Decoder
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.io.Encoder
import io.jsonwebtoken.io.Serializer
import java.util.Date
import java.security.GeneralSecurityException
import java.security.spec.EncodedKeySpec
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.security.spec.RSAPublicKeySpec
import java.security.KeyFactory
import java.util.Base64
import org.apache.commons.lang.StringUtils

privKey = "YourPrivateKey"
CustomSubject = "CustomPayloadData"

//Create dates (-2h, now, +2h)
Date actualDate = new Date();
Calendar cl = Calendar. getInstance();
cl.setTime(actualDate);
cl.add(Calendar.HOUR, 2);
Calendar c2 = Calendar. getInstance();
c2.setTime(actualDate);
c2.add(Calendar.HOUR, -2);

java.security.Security.addProvider(
		 new org.bouncycastle.jce.provider.BouncyCastleProvider()
);


//Format and decode privateKey
public static Key loadPrivateKey(String stored) throws GeneralSecurityException, IOException {
	byte[] data = Base64.getDecoder().decode((stored.getBytes()));
	PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(data);
	KeyFactory fact = KeyFactory.getInstance("RSA");
	PrivateKey pubKey = fact.generatePrivate(spec);
	//return fact.generatePublic(spec);
}

//Create JWT 
String jws = Jwts.builder().setNotBefore(c2.getTime()).setIssuedAt(actualDate).setExpiration(cl.getTime()).setSubject(CustomSubject).signWith(SignatureAlgorithm.RS256, loadPrivateKey(privKey)).compact();
jwt = jws

//println(privKey)
//println(pubKey)
//println(jwt)
