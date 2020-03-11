# QA-Codes
In case you need to create an authentication header signed with a JSON Web Token (JWT) you can use the codes in this directory.

With them you can:
- Generate a key pair
- Save the generated keys
- Format and encode the generated keys
- Generate a JWT with dates, subject, claims customized and signed with the private key.

* Use case: Suppose we have to include an authentication header in our requests in JMeter.
This header consists of a JWT signed with several timestamp, and several data that the server will know and validate when checking the JWT. This JWT must be signed with a private key that only the client knows, which will be validated by the server with the associated public key that it must have previously.

With these codes, by adding them in your JMeter script in a JSR223 Sampler, you can sign a JWT as the use case.
