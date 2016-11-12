package grafica;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class ObjetoGrafico {
	protected JLabel grafico;
	protected Icon image[];
	protected final int anchoPixel = 64;
	protected final int altoPixel = 64;
	protected Point pos;

	public ObjetoGrafico(int x, int y) {
		pos = new Point(x, y);
	}

	public Point getPos() {
		return pos;
	}

	public JLabel getGrafico() {
		if (this.grafico == null) {
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, anchoPixel, altoPixel);
		}
		return this.grafico;
	}

	public int getAnchoPixel() {
		return anchoPixel;
	}

	public int getAltoPixel() {
		return altoPixel;
	}

	public void cambiarGrafico(int dir) {
	}
}
