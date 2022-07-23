import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradorDeFigurinhas {
	
	public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
		
		//leitura da imagem
		
		/*
		 * lendo de um arquivo local 
		 * InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg")); 
		 * BufferedImage imagemOriginal = ImageIO.read(inputStream);
		 * 
		 * 
		 */
		
		//lendo de um endereço da WEB
		//InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg").openStream();
		 BufferedImage imagemOriginal = ImageIO.read(inputStream);
		 
		
		
		//criar nova imagem em memória em transparência e com tamanho novo
		
		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getWidth();
		int novaAltura = altura + 200;
		BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		//copiar imagem original para nova imagem (em memória)
		Graphics2D graphics =(Graphics2D) novaImagem.createGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);

		//configuração da fonte da palavra que vai no sticker do zap
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
		graphics.setFont(fonte);
		graphics.setColor(Color.BLUE);
		//escrever frase na nova imagem
		graphics.drawString("TOPZERA", 100, novaAltura -100);
		
		//escrever a nova imagem em um arquivo
		
		ImageIO.write(novaImagem, "png", new File(nomeArquivo));
	}
	
}
