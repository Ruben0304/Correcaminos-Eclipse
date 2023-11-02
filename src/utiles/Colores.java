package utiles;

import java.awt.Color;

public final class Colores {
	public static Color VERDE_OSCURO = new Color(0x2A6438);
	public static Color VERDE_CLARO = new Color(0x5EC267);
	public static Color AZUL_CLARO = new Color(0x395CC1);
	public static Color AZUL_MEDIO = new Color(0x2E53BE);
	public static Color AZUL_OSCURO = new Color(0x2E53BE);
	public static Color FONDO_OSCURO = new Color(0x171717);
	public static Color TEXTO_OSCURO = new Color(0x252525);
	public static Color TEXTO_GRIS = new Color(0x989898);
	public static Color ROJO_ERROR = new Color(0xA5473D);
	public static Color BLANCO = new Color(0xFDFDFD);
	public static Color NEGRO = new Color(0x000000);
	public static Color ROJO = new Color(0xAE070F);

	public static void modoOscuro() {
		VERDE_CLARO = new Color(0x2A6438);
		AZUL_CLARO = new Color(0x2E53BE);
		BLANCO = new Color(0x171717);
		FONDO_OSCURO = new Color(0xFDFDFD);
		NEGRO = new Color(0xFDFDFD);
		TEXTO_OSCURO = new Color(0xFDFDFD);
		TEXTO_GRIS = new Color(0xFDFDFD);
	}
}
