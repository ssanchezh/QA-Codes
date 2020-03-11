/*
Simple code for create a pair of Keys, Public and Private Key.
This code create a keys in RSA256 and encode in Base64 for save them
Using library JJWT --->https://github.com/jwtk/jjwt
For languages: Groovy and Java
*/

import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

			
//Generate KeyPair
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			kpg.initialize(2048); 
			
			KeyPair kp = kpg.generateKeyPair();
			PrivateKey prk = kp.getPrivate();
			PublicKey puk = kp.getPublic();
			
//Encode Key to Base64
			Base64.Encoder enc = Base64.getEncoder();
			
//Save Keys in global variables			
			GlobalVariable.privKey = enc.encodeToString(prk.getEncoded())
			GlobalVariable.pubKey = enc.encodeToString(puk.getEncoded())
			

//			println("Private Key: ")
//			println(GlobalVariable.privKey)
			
//			println("Public Key: ")
//			println(GlobalVariable.pubKey)
