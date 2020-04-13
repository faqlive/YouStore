package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPass {
	public static final String SHA_224 = "SHA-224";
	public static final String SHA_256 = "SHA-256";
	public static final String SHA_384 = "SHA-384";
	public static final String SHA_512 = "SHA-512";

	public static byte[] getPassDigest(String pass) {
		byte[] digest = null;
		try {
			// SE ESTABLECE EL METODO DE ENCRIPTACION
			MessageDigest md = MessageDigest.getInstance(SHA_256);
			// PASAMOS LA PASS A UN ARRAY DE BYTE Y LA SUBIMOS AL MD
			md.update(pass.getBytes());
			// OBTENEMOS UNA REPRESENTACION DE LA CONTRASEÑA
			digest = md.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return digest;
	}

	public static boolean equalsDigest(byte[] digesta, byte[] digestb) {
		return MessageDigest.isEqual(digesta, digestb);
	}

}
