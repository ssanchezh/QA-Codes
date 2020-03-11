/*
Simple code for create a pair of Keys, Public and Private Key.
This code create a keys in RSA256 and encode in Base64 for save them
Using library JJWT --->https://github.com/jwtk/jjwt
For languages: Groovy and Java
*/
import bsh.NameSource;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoder;
import io.jsonwebtoken.io.Serializer;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureAlgorithm.*;
import io.jsonwebtoken.*;
import java.security.*;
import io.jsonwebtoken.security.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64;
import java.io.UnsupportedEncodingException;
import org.apache.commons.*;
import org.apache.commons.lang.StringUtils;


// crete key pair RS256
KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
PublicKey publicKey = (PublicKey) keyPair.getPublic();
PrivateKey privateKey = (PrivateKey) keyPair.getPrivate();


String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());

// Convert and put keys in Jmeter variables (declare in 'User Defined Variables')
vars.put("PublicKey", new String(convertToPublicKey(encodedPublicKey)));
vars.put("PrivateKey", new String(convertToPrivateKey(encodedPrivateKey)));


//Encoded keys
private String convertToPublicKey(String key){
		StringBuilder result = new StringBuilder();
		//result.append("-----BEGIN PUBLIC KEY-----\n");
		result.append(key);
		//result.append("\n-----END PUBLIC KEY-----");
		return result.toString();
}
private String convertToPrivateKey(String key){
		StringBuilder result = new StringBuilder();
		//result.append("-----BEGIN PRIVATE KEY-----\n");
		result.append(key);
		//result.append("\n-----END PRIVATE KEY-----");
		return result.toString();
}

